import java.util.Scanner;
import java.lang.*;

public class MonteCarlo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many times you want to run the simulation: ");
        int runs = scanner.nextInt();

        int counterOne = 0;
        int counterTwo = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i = 0; i < runs; i++) {
            counterOne = 0;
            for (int j = 0; j < 6; j++) {
                if ((int) (Math.random() * 6 + 1) == 1) {
                    counterOne++;
                }
            }

            if (counterOne >= 1) {
                countOne++;
            }
        }

        for (int i = 0; i < runs; i++) {
            counterTwo = 0;
            for (int j = 0; j < 12; j++) {
                if ((int) (Math.random() * 6 + 1) == 1) {
                    counterTwo++;
                }
            }

            if (counterTwo >= 2) {
                countTwo++;
            }
        }

        double resultOne = (double) countOne/runs * 100;
        double resultTwo = (double) countTwo/runs * 100;

        System.out.println("\nProbability of getting 1 at least once when rolling 6 times: " + resultOne);
        System.out.println("\nProbability of getting 2 at least once when rolling 12 times: " + resultTwo);
    }
}
