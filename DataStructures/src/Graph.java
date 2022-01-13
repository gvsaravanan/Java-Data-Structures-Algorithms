import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph {

    private Map<String, LinkedList<String>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public Graph(String filename) {
        map = new HashMap<>();
        Scanner s = new Scanner(filename);
        if (s.hasNextLine()) {
            String obj = s.next();
            map.put(obj, new LinkedList<>());
            map.get(obj).add(s.next());
        }
    }

    public void addEdge(String v, String w) {
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<String>());
        }

        if (!map.containsKey(w)) {
            map.put(w, new LinkedList<String>());
        }

        map.get(v).add(w);
        map.get(w).add(v);
    }

    public int V() {
        return map.keySet().size();
    }

    public int E() {
        int count = 0;
        for (String v : map.keySet()) {
            count += map.get(v).size;
        }
        return count / 2;
    }

    public Iterable<String> vertices() {
        System.out.println(map);
    }

    public Iterable<String> adjacentTo(String v) {
        return map.get(v);
    }

    public int degree(String v) {
        return map.get(v).size;
    }

    public boolean hasVertex(String v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(String v, String w) {
        return map.get(v).contains(w);
    }
}
