import java.util.*;
import java.util.LinkedList;

public class BaconNumbers {

    private Map<String, Integer> dist;
    private Map<String, String> prev;

    public BaconNumbers(Graph g, String s) {
        dist = new HashMap<>();
        prev = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        dist.put(s, 0);
        while (!queue.isEmpty()) {
            String curr = queue.remove();
            for (String adj : g.adjacentTo(curr)) {
                if (!dist.containsKey(adj)) {
                    queue.add(adj);
                    dist.put(s, dist.get(s) + 1);
                    prev.put(curr, adj);
                }
            }
        }
    }

    public int distanceTo(String v) {
        return dist.get(v);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph graph = new Graph("movies.txt", " ");
        String v = s.nextLine();
        BaconNumbers actorPath = new BaconNumbers(graph, v);

        System.out.println("Bacon Number for " + v + ": " + actorPath.distanceTo(v));
    }
}
