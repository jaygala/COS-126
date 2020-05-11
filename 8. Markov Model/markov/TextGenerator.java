public class TextGenerator {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        String text = StdIn.readAll();
        String mod_text = text + text;
        MarkovModel m = new MarkovModel(text, k);
        String result = "";
        result += text.substring(0, k);
        for (int i = k; i < T; i++) {
            result += m.random(mod_text.substring(i, i + k));
        }
        System.out.println(result);
    }
}
