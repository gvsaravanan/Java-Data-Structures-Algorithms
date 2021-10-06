import java.awt.Color;

public class ImageManipulation {
    public static void main(String[] args) {
        Picture p1 = new Picture("smilingMan1.jpg");
        Picture p2 = new Picture("smilingMan2.jpg");
        Picture p3 = new Picture(Math.min(p1.width(), p2.width()), Math.min(p1.height(), p2.height()));

        for (int frame = 0; frame < 1e9; frame++) {
            for (int i = 0; i < p3.width(); i++) {
                for (int j = 0; j < p3.height(); j++) {

                    Color temp1 = p1.get(i, j);
                    Color temp2 = p2.get(i, j);

                    int r = (int) ((temp1.getRed() * ((p3.width() - i) / ((double) p3.width()))) + (temp2.getRed() * (i / ((double) p3.width()))));
                    int g = (int) ((temp1.getGreen() * ((p3.width() - i) / ((double) p3.width()))) + (temp2.getGreen() * (i / ((double) p3.width()))));
                    int b = (int) ((temp1.getBlue() * ((p3.width() - i) / ((double) p3.width()))) + (temp2.getBlue() * (i / ((double) p3.width()))));

                    p3.set(i, j, new Color(r, g, b));
                    p3.show();
                }
            }

            for (int i = 0; i < p3.width(); i++) {
                for (int j = 0; j < p3.height(); j++) {

                    Color temp1 = p1.get(i, j);
                    Color temp2 = p2.get(i, j);

                    int r = (int) ((temp1.getRed() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getRed() * (i/((double) p3.width()))));
                    int g = (int) ((temp1.getGreen() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getGreen() * (i/((double) p3.width()))));
                    int b = (int) ((temp1.getBlue() * ((p3.width()-i)/((double) p3.width()))) + (temp2.getBlue() * (i/((double) p3.width()))));

                    p3.set(i, j, new Color(r, g, b));
                    p3.show();

                    r = Math.min(r ^ ((int) (Math.sin(2*Math.PI*((frame%255)/255f))*127+128)), 255);
                    g = Math.min(g ^ ((int) (Math.cos(2*Math.PI*((frame%255)/255f))*127+128)), 255);
                    b = Math.min(b & ((int) (Math.sin(2*Math.PI*((frame%255)/255f))*127+128)), 255);

                    p3.set(i, j, new Color(r, g, b));
                }
            }
            p3.show();

        }
    }
}
