package BST;

public class BST<E extends Comparable<E>> {
    public class Node {
        private E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        add(root, e);

    }

    private void add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
         if (e.compareTo(node.e) > 0)
            add(node.right, e);
    }
}
