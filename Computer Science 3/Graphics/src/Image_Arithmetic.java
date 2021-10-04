import java.awt.Color;
import java.util.*;

public class Image_Arithmetic {
    public static void main(String[] args) {

        Picture p1 = new Picture("shrek.jpg");
        Picture p2 = new Picture("shrek2.jpg");
        Picture p3 = new Picture(Math.min(p1.width(), p2.width()), Math.min(p1.height(), p2.height()));

        for (int i = 0; i < Math.min(p1.width(), p2.width()); i++) {
            for (int j = 0; j < Math.min(p1.height(), p2.height()); j++) {
                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp1.getRed() + temp2.getRed();
                int g = temp1.getGreen() + temp2.getGreen();
                int b = temp1.getBlue() + temp2.getBlue();

                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }

                p3.set(i, j, new Color(r, g, b)); // add images
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp1.getRed() - temp2.getRed();
                int g = temp1.getGreen() - temp2.getGreen();
                int b = temp1.getBlue() - temp2.getBlue();

                if (r < 0) {
                    r = 0;
                }
                if (g < 0) {
                    g = 0;
                }
                if (b < 0) {
                    b = 0;
                }

                p3.set(i, j, new Color(r, g, b)); // subtract images
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp2.getRed() - temp1.getRed();
                int g = temp2.getGreen() - temp1.getGreen();
                int b = temp2.getBlue() - temp1.getBlue();

                if (r < 0) {
                    r = 0;
                }
                if (g < 0) {
                    g = 0;
                }
                if (b < 0) {
                    b = 0;
                }

                p3.set(i, j, new Color(r, g, b)); // subtract images in different order
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = Math.abs(temp1.getRed() - temp2.getRed());
                int g = Math.abs(temp1.getGreen() - temp2.getGreen());
                int b = Math.abs(temp1.getBlue() - temp2.getBlue());

                p3.set(i, j, new Color(r, g, b)); // absolute value
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = (int) (((temp1.getRed() / 255.0f) * (temp2.getRed() / 255.0f)) * 255);
                int g = (int) (((temp1.getGreen() / 255.0f) * (temp2.getGreen() / 255.0f)) * 255);
                int b = (int) (((temp1.getBlue() / 255.0f) * (temp2.getBlue() / 255.0f)) * 255);

                if (r < 0) {
                    r = 0;
                }
                if (g < 0) {
                    g = 0;
                }
                if (b < 0) {
                    b = 0;
                }

                p3.set(i, j, new Color(r, g, b)); // multiply
                */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = (temp1.getRed() + temp2.getRed()) / 2;
                int g = (temp1.getGreen() + temp2.getGreen()) / 2;
                int b = (temp1.getBlue() + temp2.getBlue()) / 2;

                p3.set(i, j, new Color(r, g, b)); // average
                 */


                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r1 = (int) ((temp1.getRed() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getRed() * (i/((double) p3.width()))));
                int g1 = (int) ((temp1.getGreen() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getGreen() * (i/((double) p3.width()))));
                int b1 = (int) ((temp1.getBlue() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getBlue() * (i/((double) p3.width()))));

                p3.set(i, j, new Color(r1, g1, b1)); // crossfade


                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp1.getRed() & temp2.getRed();
                int g = (temp1.getGreen() & temp2.getGreen());
                int b = (temp1.getBlue() & temp2.getBlue());

                p3.set(i, j, new Color(r, g, b)); // bitwise and
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp1.getRed() | temp2.getRed();
                int g = (temp1.getGreen() | temp2.getGreen());
                int b = (temp1.getBlue() | temp2.getBlue());

                p3.set(i, j, new Color(r, g, b)); // bitwise or
                 */

                /*
                Color temp1 = p1.get(i, j);
                Color temp2 = p2.get(i, j);

                int r = temp1.getRed() ^ temp2.getRed();
                int g = (temp1.getGreen() ^ temp2.getGreen());
                int b = (temp1.getBlue() ^ temp2.getBlue());

                p3.set(i, j, new Color(r, g, b)); // bitwise and
                 */
            }
        }
        p3.show();
    }
}