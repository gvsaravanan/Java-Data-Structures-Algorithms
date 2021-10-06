import java.util.Scanner;
import java.lang.*;

public class GamblersRuin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your stake: ");
        int stake = scanner.nextInt();

        System.out.print("Enter your goal: ");
        int goal = scanner.nextInt();

        System.out.print("Enter how many trials you want to run: ");
        int trials = scanner.nextInt();

        int bets = 0;
        int wins = 0;
        int losses = 0;

        for (int i = 0; i < trials; i++) {
            int cash = stake;

            while (cash > 0 && cash < goal) {
                bets++;

                if (Math.round(Math.random()) == 1.0) {
                    cash++;
                } else {
                    cash--;
                }
            }

            if (cash == goal) {
                wins++;
            } else if (cash == 0) {
                losses++;
            }
        }

        System.out.println("\nChances of winning: " + ((double) wins/trials * 100) + "%");
        System.out.println("Chances of losing: " + ((double) losses/trials * 100) + "%");
        System.out.println("Average number of bets: " + (double) bets/trials);
    }
}
