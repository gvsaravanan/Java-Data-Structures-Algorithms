import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class DijkstrasTwoStackAlgorithm {
    public static void main(String[] args) {
        evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    }

    public static void evaluate(String s) {
        String[] str = s.split("\\s+");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str));
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!q.isEmpty()) {
            String token = q.poll();
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(token);
                    break;
                case ")":
                    vals.push(operation(ops, vals));
                    break;
                default:
                    vals.push(Double.parseDouble(token));
                    break;
            }
        }
        System.out.println(s + " = " + operation(ops, vals));
    }

    public static Double operation(Stack<String> ops, Stack<Double> vals) {
        double v = vals.pop();
        if (!ops.empty()) {
            String op = ops.pop();
            switch (op) {
                case "+":
                    v = vals.pop() + v;
                    break;
                case "-":
                    v = vals.pop() - v;
                    break;
                case "*":
                    v = vals.pop() * v;
                    break;
                case "/":
                    v = vals.pop() / v;
                    break;
                case "sqrt":
                    v = Math.sqrt(v);
                    break;
                default:
                    break;
            }
        }
        return v;
    }
}
