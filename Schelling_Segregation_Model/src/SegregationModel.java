import java.awt.Color;
import java.util.*;

public class SegregationModel {

    private static Boolean[][] arr;
    private static double red, empty, threshold;

    public SegregationModel(double red, double empty, double threshold, int size) {
        arr = new Boolean[size][size];
        this.threshold = threshold;
        this.red = red;
        this.empty = empty;
    }

    public static void initialize() {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (Math.random() < empty) {
                    arr[r][c] = null;
                } else {
                    if (Math.random() < red) {
                        arr[r][c] = true;
                    } else {
                        arr[r][c] = false;
                    }
                }
            }
        }
    }

    public void draw(Picture p){
        for(int r = 0; r < p.width() - 1; r++){
            for (int c = 0; c < p.height() - 1; c++)
                if(arr[r][c] != null) {
                    if (arr[r][c]) {
                        p.set(r, c, new Color(255, 0, 0));
                    } else if (!arr[r][c]) {
                        p.set(r, c, new Color(0, 0, 255));
                    }
                }
                else {
                    p.set(r, c, new Color(0, 0, 0));
                }
        }

        p.show();
    }

    // isSatisfied method to check if spot on arr is satisfied
    public boolean isSatisfied(int r, int c) {
        int countOne = 0;
        int countTwo = 0;
        Boolean coordinate = arr[r][c];

        if (arr[(r + 1 + arr.length) % arr.length][c] != null) {
            countTwo++;
        }

        if (arr[(r - 1 + arr.length) % arr.length][c] != null) {
            countTwo++;
        }

        if (arr[r][(c + 1 + arr[0].length) % arr[0].length] != null) {
            countTwo++;
        }

        if (arr[r][(c - 1 + arr[0].length) % arr[0].length] != null) {
            countTwo++;
        }

        if (coordinate == arr[(r + 1 + arr.length) % arr.length][c] && arr[(r + 1 + arr.length) % arr.length][c] != null) {
            countOne++;
        }

        if (coordinate == arr[(r - 1 + arr.length) % arr.length][c] && arr[(r - 1 + arr.length) % arr.length][c] != null) {
            countOne++;
        }

        if (coordinate == arr[r][(c + 1 + arr[0].length) % arr[0].length] && arr[r][(c + 1 + arr[0].length) % arr[0].length] != null) {
            countOne++;
        }

        if (coordinate == arr[r][(c - 1 + arr[0].length) % arr[0].length] && arr[r][(c - 1 + arr[0].length) % arr[0].length] != null) {
            countOne++;
        }

        if (countTwo == 0) {
            return false;
        }

        return ((double) countOne) / countTwo >= threshold;
    }

    public void move() {
        ArrayList<Boolean> dissatisfied = new ArrayList<Boolean>();

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] == null){
                    dissatisfied.add(arr[r][c]);
                }else if (!isSatisfied(r, c)) {
                    dissatisfied.add(arr[r][c]);
                    arr[r][c] = null;
                }
            }
        }

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if(arr[r][c] == null){
                    int index = (int) (Math.floor(Math.random() * dissatisfied.size()));
                    arr[r][c] = dissatisfied.remove(index);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SegregationModel s = new SegregationModel(0.5, 0.2, 0.5, 500);
        SegregationModel.initialize();
        Picture p = new Picture(arr.length, arr[0].length);
        for (int i = 0; i < 100; i ++){
            s.draw(p);
            s.move();
            Thread.sleep(200);
        }
    }
}
