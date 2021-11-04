import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;

public class Mandelbrot extends Complex {
    public static int[][] mandelbrot;
    public static int width, height, max;

    public static Color[] genPal(int num) {
        Color[] pal = new Color[num];
        for (int i = 0; i < num; i++) {
            pal[i] = Color.getHSBColor(i / 256f, 1f, 1f);
        }
        return pal;
    }
    
    public static int mand(Complex z, int max) {
        Complex temp = z;
        for (int i = 0; i < max; i++) {
            if (temp.abs() > 2) {
                return i;
            }
            temp = temp.multiply(temp).add(z);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        width = 500;
        height = 500;
        max = 255;
        double xMin = -1;
        double xMax = 1;
        double yMin = -1;
        double yMax = 1;
        mandelbrot = new int[width][height];

        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {
                double xPos = xMin*1.5 + (xMax - xMin) * r / ((double) width);
                double yPos = yMin + (yMax - yMin) * c / ((double) height);
                mandelbrot[r][c] = mand(new Complex(xPos, yPos), max);
            }
        }

        Thread thread = new Thread(new MandelbrotViewer());
        thread.start();
    }

    static class MandelbrotViewer implements Runnable {
        public Picture p = new Picture(width, height);

        @Override
        public void run() {
            Color[] colors = genPal(max);
            int offset = 1;

            while (true) {
                for (int r = 0; r < width; r++) {
                    for (int c = 0; c < height; c++) {
                        if (mandelbrot[r][c] == max) {
                            p.set(r, c, Color.BLACK);
                        } else {
                            p.set(r, c, colors[(mandelbrot[r][c] + offset) % max]);
                        }
                    }
                }
                offset++;
                p.show();
            }
            //p.save("Mandelbrot.jpg");
        }
    }
}