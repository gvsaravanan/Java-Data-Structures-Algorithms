import java.io.*;
import java.util.*;

public class OddEvenSets {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("oddevent.dat"));

        while (s.hasNextLine()) {
            Set<Integer> odds = new TreeSet<>(), evens = new TreeSet<>();
            String[] arr = s.nextLine().split("\\s+");

            for (String a : arr) {
                int curr = Integer.parseInt(a);

                if (curr % 2 == 0) evens.add(curr);
                else odds.add(curr);
            }

            System.out.println("ODDS : " + odds);
            System.out.println("EVENS : " + evens + "\n");
        }
    }
}
