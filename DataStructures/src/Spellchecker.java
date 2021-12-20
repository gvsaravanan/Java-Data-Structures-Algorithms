import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Spellchecker {
    public static void main(String[] args) throws IOException {
        Scanner datafile = new Scanner(new File("misspellings.txt"));
        Map<String, String> map = new HashMap<>();

        while (datafile.hasNext()) {
            datafile.nextLine();
            String s1 = datafile.next();
            String s2 = datafile.next();
            map.put(s1, s2.substring(1, s2.length() - 1));
        }

        String str = "It is a mistery why mispelling common words is concidered acceptible";
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                words[i] = map.get(words[i]);
            }
        }

        for (String s : words) {
            System.out.print(s + " ");
        }
        datafile.close();
    }
}
