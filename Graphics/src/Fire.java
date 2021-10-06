import java.awt.*;

public class Fire {
    public static Color[] genPal(int num) {
        Color[] pal = new Color[num];
        for (int i = 0; i < num; i++) {
            pal[i] = Color.getHSBColor(0.08f, 1f, (float) i / (num / 2));
            if (i > num / 2) {
                pal[i] = Color.getHSBColor(0.08f, (float) (num - i - 1) / (num / 2), 1f);
            }
        }
        return pal;
    }

    public static void main(String[] args) {
        Picture p = new Picture(1000, 300);
        Color[] palette = genPal(256);
        Color[][] fire = new Color[p.height()][p.width()];
        int row = p.height();

        for (int i = 0; i < p.width(); i++) {
            for (int j = 0; j < p.height(); j++) {
                //int palIndex = (int) ((double) i / p.width() * palette.length);
                p.set(i, j, palette[palette.length/3]);
            }
        }

        while (true) {
            for (int i = 0; i < fire[0].length; i++) {
                if (Math.random() > 0.5) {
                    fire[row - 1][i] = palette[0];
                } else {
                    fire[row - 1][i] = palette[palette.length-1];
                }
                p.set(i,row - 1, fire[row - 1][i]);
            }

            for (int i = 1; i < p.width() - 1; i++) {
                for (int j = 2; j < p.height() - 2; j++) {
                    int r = (int) ((p.get(i - 1, j + 1).getRed() + p.get(i,j + 1).getRed() + p.get(i + 1,j + 1).getRed() + p.get(i,j + 2).getRed()) / 4.01);
                    int g = (int) ((p.get(i - 1,j + 1).getGreen() + p.get(i,j + 1).getGreen() + p.get(i + 1,j + 1).getGreen() + p.get(i,j + 2).getGreen()) / 4.01);
                    int b = (int) ((p.get(i - 1,j + 1).getBlue() + p.get(i,j + 1).getBlue() + p.get(i + 1,j + 1).getBlue() + p.get(i,j + 2).getBlue()) / 4.01);
                    p.set(i, j, new Color(r, g, b));
                }
            }
            p.show();
        }
    }
}