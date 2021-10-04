import java.util.Scanner;

public class DartThrow {
    public static void main(String[] args) {

        //int area = 30;
        int totalArea = 100;
        int darts = 10000;

        System.out.println("The percentage of hits is: " + dartThrow(darts, totalArea));
    }

    public static double dartThrow(int darts, int totalArea) {
        double hits = 0;

        for (int i = 0; i < darts; i++) {
            double x = (Math.random() * 10);
            double y = (Math.random() * 10);

            if (y <= equation(x)) {
                hits++;
            }
        }

        return (hits/darts) * totalArea;
    }

    public static double equation(double x) {
        return (2 * Math.exp(-1 * Math.pow(x,2)));
    }
}
