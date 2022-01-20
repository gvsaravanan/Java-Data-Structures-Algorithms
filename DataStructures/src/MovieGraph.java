import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieGraph {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        Graph movies = new Graph("movies.txt", "/");
        String name = s.nextLine();

        for (String adj : movies.adjacentTo(name)) {
            System.out.println(adj);
        }
    }
}
