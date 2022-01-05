import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shrubbery implements Comparable {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("shrubbery.dat"));
        int cases = s.nextInt();
        for (int j = 0; j < cases; j++) {
            int n = s.nextInt();
            ArrayList<Shrubbery> shrubs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                shrubs.add(new Shrubbery(s.next(), s.nextInt(), s.nextDouble(), s.nextDouble()));
            }
            Shrubbery.compare = s.next();
            Collections.sort(shrubs);
            for (int i = 0; i < n; i++) {
                System.out.println(shrubs.get(i).name);
            }
            System.out.println("");
        }
    }

    private double size, price, nice;
    private String name;
    public static String compare;

    public Shrubbery(String name, double size, double price, double nice) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.nice = nice;
    }

    @Override
    public int compareTo(Object o) {
        Shrubbery other = (Shrubbery) o;

        if (compare.equals("SIZE")) {
            return Double.compare(size, other.size);
        } else if (compare.equals("PRICE")) {
            return Double.compare(price, other.price);
        } else if (compare.equals("NICE")) {
            return Double.compare(nice, other.nice);
        }
        return 0;
    }

}
