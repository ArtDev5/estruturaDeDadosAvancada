import java.util.ArrayList;
import java.util.Arrays;

public class Tree<T> {

    private final ArrayList<String> allowedPositions = new ArrayList<>(Arrays.asList("London", "Tokyo", "New York"));
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> insert(Node<T> root, Node<T> newNode, String position){

        if (root == null) {
            return newNode;
        }

        if (position.toLowerCase().equals("left")) {
            root.setLeft(
                    insert(root.getLeft(), newNode, position));
        } else {
            root.setRight(
                    insert(root.getRight(),newNode, position));
        }

        return root;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
