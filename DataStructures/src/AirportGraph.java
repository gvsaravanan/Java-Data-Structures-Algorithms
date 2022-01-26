import java.util.*;
import java.util.LinkedList;

public class AirportGraph {

    private Map<String, Integer> dist;
    private Map<String, String> prev;

    public AirportGraph(Graph g, String s) {
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

    public Stack<String> pathTo(String v) {
        Stack<String> path = new Stack<>();
        while (v != null && dist.containsKey(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("airline.txt", " ");
        String v = "LAX";
        AirportGraph schedule = new AirportGraph(graph, v);
        Stack<String> path = schedule.pathTo(v);

        System.out.println("Shortest path: " + schedule.distanceTo(v) + " / ");
        for (String loc : path) {
            System.out.println(loc + "-");
        }
    }
}
