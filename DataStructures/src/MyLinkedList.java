class MyNode {
    MyNode next, prev;
    int data;

    public MyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public MyNode getNext() {
        return next;
    }

    public MyNode getPrev() {
        return prev;
    }
}

public class MyLinkedList {
    MyNode head, tail;
    int length = size();

    public int size() {
        MyNode temp = head;
        int count = 0;

        while (temp != null)
        {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public boolean containsElement(int element) {
        MyNode temp = head;

        while(temp != null) {
            if (temp.data == element) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public MyNode findIndex(int index) {
        if (index < 0 || index > size()) {
            return null;
        }

        MyNode temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void add(int data) {
        if (head == null) {
            head = new MyNode(data);
        } else {
            MyNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new MyNode(data);
        }

        length = size();
    }

    public void insert(MyNode newNode, int index) {
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size()) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            MyNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            newNode.next.prev = newNode;
        }

        length = size();
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size()) {
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
        }

        length = size();
    }

    public void reverse() {
        MyNode temp = null;
        MyNode current = head;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyNode curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }
}