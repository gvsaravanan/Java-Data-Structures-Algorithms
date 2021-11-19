import java.util.Stack;

public class PostfixExpression {
    public static int evaluate(String exp)
    {
        Stack<Integer> s = new Stack<>();

        for (char c: exp.toCharArray())
        {
            if (Character.isDigit(c)) {
                s.push(c - '0');
            } else {
                int x = s.pop();
                int y = s.pop();

                if (c == '+') {
                    s.push(y + x);
                }
                else if (c == '-') {
                    s.push(y - x);
                }
                else if (c == '*') {
                    s.push(y * x);
                }
                else if (c == '/') {
                    s.push(y / x);
                }
            }
        }

        return s.pop();
    }

    public static void main(String[] args)
    {
        String exp = "138*+5/";
        System.out.println(evaluate(exp));
    }
}