import java.util.ArrayList;
import java.awt.Color;
import java.util.Arrays;

public class WeedSpread {

    private static int[][] arr;
    private static String waterFlow;

    public WeedSpread(String w, int size) {
        arr = new int[size][size];
        this.waterFlow = w;
    }

    public void initialize() {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                arr[r][c] = 0;
            }
        }

        int rand1 = (int) (Math.random() * arr.length - 1) + 1;
        int rand2 = (int) (Math.random() * arr[0].length - 1) + 1;
        System.out.println(rand1 + " " + rand2);
        arr[rand1][rand2] = 1;
        System.out.println(arr[rand1][rand2]);

        rand1 = (int) (Math.random() * arr.length - 1) + 1;
        rand2 = (int) (Math.random() * arr[0].length - 1) + 1;
        System.out.println(rand1 + " " + rand2);
        arr[rand1][rand2] = 2;
        System.out.println(arr[rand1][rand2]);
    }

    public void draw(Picture p) {
        for(int r = 0; r < p.width() - 1; r++) {
            for (int c = 0; c < p.height() - 1; c++) {
                if (arr[r][c] == 0) {
                    p.set(r, c, new Color(193, 255, 157));
                }
                if (arr[r][c] == 1) {
                    p.set(r, c, new Color(80, 178, 80));
                }
                if (arr[r][c] == 2) {
                    p.set(r, c, new Color(0, 119, 0));
                }
            }
        }
        p.show();
    }

    public static boolean invasive(int r, int c){
        double rand = Math.random() * 10;

        switch (waterFlow) {
            case "North":
                if (rand <= 2.5) {
                    if (arr[r][c] != arr[(r + arr.length) % arr.length][(c + 1 + arr[0].length) % arr[0].length]) {
                        return true;
                    }
                }
                break;
            case "East":
                if (rand > 2.5 && rand <= 5) {
                    if (arr[r][c] != arr[(r + 1 + arr.length) % arr.length][(c + arr[0].length) % arr[0].length]) {
                        return true;
                    }
                }
                break;
            case "South":
                if (rand > 5 && rand >= 7.5) {
                    if (arr[r][c] != arr[(r + arr.length) % arr.length][(c - 1 + arr[0].length) % arr[0].length]) {
                        return true;
                    }
                }
                break;
            case "West":
                if (rand < 10) {
                    if (arr[r][c] != arr[(r - 1 + arr.length) % arr.length][(c + arr[0].length) % arr[0].length]) {
                        return true;
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + waterFlow);
        }

        return false;
    }

    public void move(int r, int c) {
        int[] xMoves;
        int[] yMoves;
        int coordinate = arr[r][c];

        switch (waterFlow) {
            case "North":
                int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
                int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
                xMoves = x;
                yMoves = y;
                break;
            case "East":
                int[] x1 = {-1, 0, 1, -1, 1, -1, 0, 1};
                int[] y1 = {1, 1, 1, 0, 0, -1, -1, -1};
                xMoves = x1;
                yMoves = y1;
                break;
            case "South":
                int[] x2 = {1, 1, 1, 0, 0, -1, -1, -1};
                int[] y2 = {-1, 0, 1, -1, 1, -1, 0, 1};
                xMoves = x2;
                yMoves = y2;
                break;
            case "West":
                int[] x3 = {-1, 0, 1, -1, 1, -1, 0, 1};
                int[] y3 = {-1, -1, -1, 0, 0, 1, 1, 1};
                xMoves = x3;
                yMoves = y3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + waterFlow);
        }

        for (int i = 0; i < xMoves.length; i++) {
            if (((0 <= r + xMoves[i]) && (r + xMoves[i] < arr.length)) && ((0 <= c + yMoves[i]) && (c + yMoves[i] < arr[0].length))) {
                if (coordinate == 1) {
                    arr[r + xMoves[i]][c + yMoves[i]] = 1;
                } else if (coordinate == 2) {
                    arr[r + xMoves[i]][c + yMoves[i]] = 2;
                }
            }
        }
    }

    public void spread() {
        for(int r = 0; r < arr.length; r++){
            for (int c = 0; c < arr[0].length; c++) {
                if (invasive(r, c)){
                    move(r, c);
                }
            }
        }
    }

    public boolean empty() {
        int counter = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] == 0) {
                    counter++;
                }
            }
        }

        return counter != 0;
    }

    public static void main(String[] args) throws InterruptedException {

        WeedSpread w = new WeedSpread("East", 500);
        Picture p = new Picture(arr.length, arr[0].length);
        w.initialize();

        while (w.empty()){
            w.draw(p);
            w.spread();
            Thread.sleep(1);
        }
    }

}
