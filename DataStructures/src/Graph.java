import java.util.*;
import java.io.*;

public class Graph {
    private HashMap<String, TreeSet<String>> adjmap;
    private int numEdges = 0;

    public Graph() {
        adjmap = new HashMap<>();
    }

    public Graph(String filename, String delim) {
        adjmap = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String[] inputLine = sc.nextLine().split(delim);
                addEdge(inputLine[0], inputLine[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEdge(String v, String w) {
        if (!adjmap.containsKey(v))
            adjmap.put(v, new TreeSet<>());
        if (!adjmap.containsKey(w))
            adjmap.put(w, new TreeSet<>());
        adjmap.get(v).add(w);
        adjmap.get(w).add(v); // omit this for digraph
        numEdges++;
    }

    int V() {
        return adjmap.keySet().size();
    }

    int E() {
        return numEdges;
    }

    public Iterable<String> vertices() {
        return adjmap.keySet();
    }

    public Iterable<String> adjacentTo(String v) {
        return adjmap.get(v); // returning a treeset
    }

    int degree(String v) {
        return adjmap.get(v).size();
    }

    boolean hasVertex(String v) {
        return adjmap.containsKey(v);
    }

    boolean hasEdge(String v, String w) {
        if (!hasVertex(v))
            return false;
        if (!hasVertex(w))
            return false;
        return adjmap.get(v).contains(w);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String v : vertices()) {
            sb.append(v + ": " );
            for (String adj : adjacentTo(v))
                sb.append(adj + " ");
            sb.append("\n");
        }
        return sb.toString();
    }
}