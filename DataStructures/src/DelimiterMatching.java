import java.util.Stack;

public class DelimiterMatching {
    public static int findIndex(Character arr[], Character c)
    {
        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        int i = 0;

        while (i < len) {
            if (arr[i] == c) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static String matching(String input) {
        Character[] opening = {'(', '{', '[', '<'};
        Character[] closing = {')', '}', ']', '>'};

        if (input.length() == 0) {
            System.out.println("String is empty");
        }

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (findIndex(opening, c) != -1) {
                s.push(c);
            } else if (findIndex(closing, c) != -1) {
                if (!s.isEmpty()) {
                    char c1 = s.pop();
                    if ((c == '(' && c1 != ')') || (c == '[' && c1 != ']') || (c == '{' && c1 != '}') || (c == '<' && c1 != '>')) {
                        return "not matching";
                    }
                } else {
                    return "missing left delimiter error";
                }
            }
        }
        if (!s.isEmpty()) {
            return "missing right delimiter error";
        }
        return "matching!";
    }

    public static void main(String[] args) {
        System.out.println(matching("c[d]"));
        System.out.println(matching("a{b[c]d}e"));
        System.out.println(matching("a{b(c]d}e"));
        System.out.println(matching("a[b{c}d]e}"));
        System.out.println(matching("a{b(c)"));
    }
}
