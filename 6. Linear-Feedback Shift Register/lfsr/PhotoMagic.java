import java.awt.Color;

public class PhotoMagic {

    // returns a new picture that has a transformed copy of the given picture, using the given lfsr.
    public static Picture transform(Picture picture, LFSR lfsr) {
        Picture pic = new Picture(picture);
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                Color color = pic.get(i, j);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                int rand1 = lfsr.generate(8);
                int rand2 = lfsr.generate(8);
                int rand3 = lfsr.generate(8);

                int new_r = r ^ rand1;
                int new_g = g ^ rand2;
                int new_b = b ^ rand3;

                // //  If we want to make it black and white:
                // int new_r = r ^ rand1;
                // int new_g = r ^ rand1;
                // int new_b = r ^ rand1;

                Color new_col = new Color(new_r, new_g, new_b);
                pic.set(i, j, new_col);

            }
        }
        return pic;
    }

    // takes the name of an image file and a description of an lfsr as command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        LFSR lfsr = new LFSR(args[1], Integer.parseInt(args[2]));
        // PhotoMagic photoMagic = new PhotoMagic();
        Picture pic_new = transform(pic, lfsr);
        pic_new.show();
    }
}
