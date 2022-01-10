import java.util.*;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printToOrder() {
        if (left != null) left.printToOrder();
        System.out.println(data);
        if (right != null) right.printToOrder();
    }
}

class BST {
    Node root;

    public BST(){
        root = null;
    }

    void postOrder(Node node)  {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void inOrder(Node node)  {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void preOrder(Node node)  {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void levelOrder(Node root)
    {
        if (root == null) return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty())
        {
            curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {11, 45, 7, 17, 27, 67, 9};
        BST tree = new BST();
        tree.root = new Node(23);
        for (int n : nums) tree.root.insert(n);

        System.out.println("Pre-order Traversal:");
        tree.preOrder(tree.root);
        System.out.println("\nIn-order Traversal:");
        tree.inOrder(tree.root);
        System.out.println("\nPost-order Traversal:");
        tree.postOrder(tree.root);
        System.out.println("\nLevel-order Traversal:");
        tree.levelOrder(tree.root);

    }
}