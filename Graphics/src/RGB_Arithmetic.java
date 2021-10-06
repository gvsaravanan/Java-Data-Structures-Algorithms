import java.awt.Color;

public class RGB_Arithmetic {
    public static void main(String[] args) {
        /*Picture p = new Picture(700,444);
        for (int frame = 0; frame < 1e9; frame++) {
            for(int i = 1; i < p.width(); i++) {
                for (int j = 0; j < p.height(); j++) {
                    p.set(i, j, new Color(frame % 256, 0, i*256/p.width()));
                }
            }
            p.show();
        }*/

        Picture p = new Picture("shrek.jpg");

        for (int i = 0; i < p.width(); i++) {
            for (int j = 0; j < p.height(); j++) {
                /*
                int rgb = 255 - p.getRGB(i, j);
                p.set(i, j, new Color(rgb)); // invert
                */

                /*
                Color c = p.get(i, j);
                int r = c.getRed() / 2;
                int g = c.getGreen() / 2;
                int b = c.getBlue() / 2;

                p.set(i, j, new Color(r, g, b)); // darken by dividing by 2
                */

                /*
                Color c = p.get(i, j);
                int r = c.getRed() - 50;
                int g = c.getGreen() - 50;
                int b = c.getBlue() - 50;

                if (r < 0) {
                    r = 0;
                }
                if (g < 0) {
                    g = 0;
                }
                if (b < 0) {
                    b = 0;
                }

                p.set(i, j, new Color(r, g, b)); // darken by subtracting 50
                 */

                /*
                Color c = p.get(i, j);
                int r = c.getRed() * 2;
                int g = c.getGreen() * 2;
                int b = c.getBlue() * 2;

                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }

                p.set(i, j, new Color(r, g, b)); // brighten by multiplying by 2
                 */

                /*
                Color c = p.get(i, j);
                int r = c.getRed() + 50;
                int g = c.getGreen() + 50;
                int b = c.getBlue() + 50;

                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }

                p.set(i, j, new Color(r, g, b)); // brighten by multiplying by 2
                */

                /*
                Color c = p.get(i, j);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int avg = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);

                p.set(i, j, new Color(avg, avg, avg)); // greyscale
                */

                /*
                Color c = p.get(i, j);
                int r = c.getRed();
                int g = c.getBlue();
                int b = c.getGreen();

                p.set(i, j, new Color(r, g, b)); // swap green and blue
                 */

            }
        }
        p.show();
    }
}