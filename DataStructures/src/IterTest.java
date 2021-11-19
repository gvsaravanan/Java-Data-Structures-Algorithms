import java.util.Iterator;

class LinkedList<E> implements Iterable<E> {
    Node HEAD;
    int size;

    public void add(E data) {
        if (HEAD == null) {
            HEAD = new Node(data);
        } else {
            Node curr = HEAD;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        }
        size++;
    }

    public void remove() {}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = HEAD;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private class MyIterator implements Iterator<E> {
        Node curr = HEAD;

        public boolean hasNext() {
            return curr != null;
        }

        public E next() {
            E data = curr.data;
            curr = curr.next;
            return data;
        }

        public void remove() {}
    }
}

public class IterTest {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        System.out.println(a);
        for (String s : a) {
            System.out.println(s);
        }
    }
}
