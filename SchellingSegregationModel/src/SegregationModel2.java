import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SegregationModel2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the size of the grid: ");
        int size = s.nextInt();

        System.out.print("Enter the percentage of vacant cells in initial state: ");
        double empty = s.nextDouble();
        double red = 0.5;

        System.out.print("Enter the threshold at which an agent is satisfied: ");
        double threshold = s.nextDouble();

        Picture p = new Picture(size, size);
        int[][] arr = randomize(size, empty, red, p);
        double[][] percentages = calcPercentages(arr);

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        for (double[] a : percentages) {
            System.out.println(Arrays.toString(a));
        }

        Satisfaction[][] satisfied = new Satisfaction[size][size];
        ArrayList<Coordinate> vacant = new ArrayList<>();
        ArrayList<Coordinate> dissatisfied = new ArrayList<>();

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] == 0) {
                    satisfied[r][c] = Satisfaction.VACANT;
                    vacant.add(new Coordinate(r, c, 0));
                } else {
                    if (((arr[r][c] == 1) && (percentages[r][c] >= threshold)) || (arr[r][c] == 2) && ((1 - percentages[r][c] >= threshold))) {
                        satisfied[r][c] = Satisfaction.SATISFIED;
                    } else {
                        satisfied[r][c] = Satisfaction.DISSATISFIED;
                        dissatisfied.add(new Coordinate(r, c, arr[r][c]));
                    }
                }
            }
        }

        int i = dissatisfied.size()-1;
        while (dissatisfied.size() != 0 && i > 0) {
            int index = (int) (Math.random()*vacant.size());
            Coordinate dis = vacant.get(index);
            Coordinate vac = dissatisfied.get(i);

            if (isSatisfied(vac, percentages, threshold)) {
                satisfied[dis.getX()][dis.getY()] = Satisfaction.SATISFIED;
                satisfied[vac.getX()][vac.getY()] = Satisfaction.VACANT;
                dissatisfied.remove(vac);
                vacant.set(index, dis);
            } else {
                Coordinate temp = vac;
                vac = dis;
                dis = temp;
            }
            i--;
        }


        for (Satisfaction[] S : satisfied) {
            System.out.println(Arrays.toString(S));
        }

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (satisfied[r][c] == Satisfaction.VACANT) {
                    arr[r][c] = 0;
                    p.set(r, c, new Color(255, 255, 255));
                } else {
                    if (satisfied[r][c] == Satisfaction.SATISFIED) {
                        arr[r][c] = 1;
                        p.set(r, c, new Color(255, 0, 0));
                    } else {
                        arr[r][c] = 2;
                        p.set(r, c, new Color(0,0,255));
                    }
                }
            }
        }

        p.show();
    }

    public static int[][] randomize(int size, double empty, double red, Picture p) {
        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Math.random() < empty) {
                    arr[i][j] = 0;
                    p.set(i, j, new Color(255, 255, 255));
                } else {
                    if (Math.random() < red) {
                        arr[i][j] = 1;
                        p.set(i, j, new Color(255, 0, 0));
                    } else {
                        arr[i][j] = 2;
                        p.set(i, j, new Color(0,0,255));
                    }
                }
            }
        }

        return arr;
    }

    public static double[][] calcPercentages(int[][] arr) {
        double[][] percentages = new double[arr.length][arr[0].length];
        int[] xMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yMoves = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                double countOne = 0.0;
                double countTwo = 0.0;
                for (int i = 0; i < xMoves.length; i++) {
                    if (((0 <= r + xMoves[i]) && (r + xMoves[i] < arr.length)) && ((0 <= c + yMoves[i]) && (c + yMoves[i] < arr[0].length))) {
                        if (arr[r + xMoves[i]][c + yMoves[i]] == 1) {
                            countOne += 1.0;
                        } else if (arr[r + xMoves[i]][c + yMoves[i]] == 2) {
                            countTwo += 1.0;
                        }
                    }
                }
                percentages[r][c] = countOne / (countOne + countTwo);
            }
        }

        return percentages;
    }

    public enum Satisfaction {
        VACANT(0),
        SATISFIED(1),
        DISSATISFIED(2);

        private final int value;

        Satisfaction(final int newValue) {
            value = newValue;
        }
    }

    public static boolean isSatisfied(Coordinate c, double[][] percentages, double threshold) {
        return (((c.getVal() == 1) && (percentages[c.getX()][c.getY()] >= threshold)) || (c.getVal() == 2) && ((1 - percentages[c.getX()][c.getY()] >= threshold)));
    }

    public static class Coordinate {
        int x = 0;
        int y = 0;
        int val = 0;

        public Coordinate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getVal() {
            return val;
        }
    }
}