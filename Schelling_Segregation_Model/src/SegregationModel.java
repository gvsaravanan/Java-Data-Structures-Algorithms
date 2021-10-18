import java.awt.Color;
import java.util.*;

public class SegregationModel {

    private static int[][] arr;
    private static double red, blue, green, empty, threshold;

    public SegregationModel(double red, double blue, double green, double empty, double threshold, int size) {
        arr = new int[size][size];
        this.threshold = threshold;
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.empty = empty;
    }

    // Randomly initialize 2D array with values
    public static void initialize() {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                double random = Math.random();

                if (random < empty) {
                    arr[r][c] = 0;
                } else if (random < green) {
                    arr[r][c] = 1;
                } else if (random < blue) {
                    arr[r][c] = 2;
                } else {
                    arr[r][c] = 3;
                }
            }
        }
    }

    // Draw the 2D array as a Picture object
    public void draw(Picture p, Picture p1, int size){
        for(int r = 0; r < p.width()/size - 1; r++){
            for (int c = 0; c < p.height()/size - 1; c++)
                if(arr[r][c] != 0) {
                    if (arr[r][c] == 1) {
                        p.set(r, c, new Color(0, 255, 0));
                    } else if (arr[r][c] == 2) {
                        p.set(r, c, new Color(0, 0, 255));
                    } else {
                        p.set(r, c, new Color(255, 0, 0));
                    }
                }
                else {
                    p.set(r, c, new Color(0, 0, 0));
                }
        }

        for (int r = 0; r < p1.width() - 1; r++) {
            for (int c = 0; c < p1.height() - 1; c++) {
                Color color = p.get(r / size, c / size);
                p1.set(r, c, color);
            }
        }

        p1.show();
    }

    // Check if the agent at the given coordinate is satisfied or not
    public boolean isSatisfied(int r, int c) {
        int countOne = 0;
        int countTwo = 0;
        int[] xMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yMoves = {-1, 0, 1, -1, 1, -1, 0, 1};
        int coordinate = arr[r][c];

        for (int i = 0; i < xMoves.length; i++) {
            if (((0 <= r + xMoves[i]) && (r + xMoves[i] < arr.length)) && ((0 <= c + yMoves[i]) && (c + yMoves[i] < arr[0].length))) {
                if (arr[r + xMoves[i]][c + yMoves[i]] != 0) {
                    countOne++;
                    if (coordinate == arr[r + xMoves[i]][c + yMoves[i]]) {
                        countTwo++;
                    }
                }
            }
        }

        if (countOne == 0) {
            return false;
        }

        return (((double) countTwo) / countOne >= threshold);
    }

    // Move the dissatisfied agents to vacant spots and check if they are satisfied
    public double move() {
        ArrayList<Integer> dissatisfied = new ArrayList<>();
        double count = 0.0;

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] == 0){
                    dissatisfied.add(arr[r][c]);
                } else if (!isSatisfied(r, c)) {
                    dissatisfied.add(arr[r][c]);
                    arr[r][c] = 0;
                    count += 1.0;
                }
            }
        }

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if(arr[r][c] == 0){
                    int index = (int) (Math.floor(Math.random() * dissatisfied.size()));
                    arr[r][c] = dissatisfied.remove(index);
                }
            }
        }

        return ((arr.length * arr[0].length) - count) / (arr.length * arr[0].length);
    }

    // Initialize and run the simulation until every agent is satisfied
    public static void main(String[] args) throws InterruptedException {
        int pixelSize = 4;
        double satisfaction = 0.0;

        SegregationModel s = new SegregationModel(1, 0.68,0.39, 0.17, 0.7, 200);
        SegregationModel.initialize();
        Picture p = new Picture(arr.length * pixelSize, arr[0].length * pixelSize);
        Picture p1 = new Picture(arr.length, arr[0].length);

        System.out.println("Possible segregation splits of the population in Georgia");
        System.out.println("The tipping point for the similarity threshold is 0.84");

        while (satisfaction < 100.0){
            s.draw(p, p1, pixelSize);
            satisfaction = s.move() * 100;
            System.out.print("Percent satisfied: ");
            System.out.printf("%.2f", satisfaction);
            System.out.print("%\tPercent dissatisfied: ");
            System.out.printf("%.2f", 100 - satisfaction);
            System.out.print("%\r");
            Thread.sleep(1);
        }
    }
}