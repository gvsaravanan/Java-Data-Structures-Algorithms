import java.util.Scanner;
import java.lang.*;

public class RGBtoCMYK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a value for r: ");
        double r = s.nextInt();
        while (r < 0.0 || r > 255.0) {
            System.out.print("Please enter a value between 0 and 255: ");
            r = s.nextInt();
        }

        System.out.print("Enter a value for g: ");
        double g = s.nextInt();
        while (g < 0.0 || g > 255.0) {
            System.out.print("Please enter a value between 0 and 255: ");
            g = s.nextInt();
        }

        System.out.print("Enter a value for b: ");
        double b = s.nextInt();
        while (b < 0.0 || b > 255.0) {
            System.out.print("Please enter a value between 0 and 255: ");
            b = s.nextInt();
        }

        double w = Math.max(Math.max(r/255, g/255), b/255);
        double c = (w - r/255)/w;
        double m = (w - g/255)/w;
        double y = (w - b/255)/w;
        double k = 1 - w;

        System.out.println("\nRGB value: (" + (int)r + ", " + (int)g + ", " + (int)b + ")");
        System.out.print("CMYK value: (" + c + ", " + m + ", " + y + ", " + k + ")");
    }
}
