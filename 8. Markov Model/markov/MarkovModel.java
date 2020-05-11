public class MarkovModel {

    private int k;
    private ST<String, Integer> st1;
    private ST<String, int[]> st2;

    // creates a Markov model of order k based on the specified text
    public MarkovModel(String text, int k) {
        this.k = k;
        String modified_text = text + text;
        st1 = new ST<String, Integer>();
        st2 = new ST<String, int[]>();
        for (int i = 0; i < text.length(); i++) {
            String key = modified_text.substring(i, i + k);
            if (st1.contains(key)) {
                st1.put(key, st1.get(key) + 1);
                int[] all_chars = st2.get(key);
                all_chars[modified_text.charAt(i + k)]++;
                st2.put(key, all_chars);
            }
            else {
                st1.put(key, 1);
                st2.put(key, new int[128]);
                int[] all_chars = st2.get(key);
                all_chars[modified_text.charAt(i + k)]++;
                st2.put(key, all_chars);
            }
        }
    }

    // returns the order of the model (also known as k)
    public int order() {
        return k;
    }

    // returns a String representation of the model (more info below)
    public String toString() {
        String result = "";
        for (String s : st2.keys()) {
            // StdOut.print(s + ": ");
            result += s + ": ";
            for (int i = 0; i < 128; i++) {
                if (st2.get(s)[i] > 0) {
                    char c = (char) i;
                    // StdOut.print(c + " " + st2.get(s)[i] + " ");
                    result += c + " " + st2.get(s)[i] + " ";
                }
            }
            // StdOut.println();
            result += '\n';
        }
        return result;
    }

    // returns the # of times 'kgram' appeared in the input text
    public int freq(String kgram) {
        if (kgram.length() != k) {
            throw new IllegalArgumentException("Length of kgram is not k");
        }
        return st1.get(kgram);
    }

    // returns the # of times 'c' followed 'kgram' in the input text
    public int freq(String kgram, char c) {
        if (kgram.length() != k) {
            throw new IllegalArgumentException("Length of kgram is not k");
        }
        return st2.get(kgram)[c];
    }

    // returns a random character, chosen with weight proportional to the
    // number of times each character followed 'kgram' in the input text
    public char random(String kgram) {
        if (kgram.length() != k) {
            throw new IllegalArgumentException("Length of kgram is not k");
        }
        int index = StdRandom.discrete(st2.get(kgram));
        // System.out.println((char) index);
        return (char) index;
    }

    // tests all instance methods to make sure they're working as expected
    public static void main(String[] args) {
        String text1 = "banana";
        MarkovModel model1 = new MarkovModel(text1, 2);
        StdOut.println(model1);
        // model1.random("na");
        // String text2 = "gagggagaggcgagaaa";
        // MarkovModel model2 = new MarkovModel(text2, 2);
        // StdOut.println(model2);
    }
}

