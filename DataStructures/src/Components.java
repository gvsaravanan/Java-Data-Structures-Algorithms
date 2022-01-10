import java.io.File;
import java.util.*;

public class Components {
    static Map<String, String[]> m = new HashMap<String, String[]>();

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("components.dat"));
        int count = s.nextInt();

        for (int i = 0; i < count; i++) {
            String obj = s.next();
            String[] arr1 = s.nextLine().split(" ");
            String[] arr2 = new String[arr1.length - 2];
            if (arr1.length - 2 >= 0) System.arraycopy(arr1, 2, arr2, 0, arr1.length - 2);
            m.put(obj, arr2);
        }

        count = s.nextInt();
        s.nextLine();

        for (int i = 0; i < count; i++) {
            Map<String, Integer> finalRecipe = new HashMap<>();
            String testWord = s.nextLine();

            if (m.containsKey(testWord)) {
                craft(finalRecipe, testWord);
            }

            System.out.println(testWord + " = " + finalRecipe);
        }
    }

    public static void craft(Map<String, Integer> map, String name) {
        for (String word : m.get(name)) {
            if (m.containsKey(word)) {
                craft(map, word);
            } else {
                if (!map.containsKey(word)) {
                    map.put(word, 0);
                }
                map.put(word, map.get(word) + 1);
            }
        }
    }
}
