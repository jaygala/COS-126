public class GuitarHero {
    public static void main(String[] args) {

        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] gs = new GuitarString[37];
        Keyboard keyboard = new Keyboard();
        for (int i = 0; i < 37; i++) {
            gs[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }

        while (true) {
            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {

                // the key the user played
                char key = keyboard.nextKeyPlayed();

                try {
                    gs[keyboardString.indexOf(key)].pluck();
                    System.out.println(keyboardString.indexOf(key));
                }
                catch (Exception e) {
                    //ignore
                }

            }

            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i < 37; i++) {
                sample += gs[i].sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < 37; i++) {
                gs[i].tic();
            }
        }
    }
}

