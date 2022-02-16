import java.util.ArrayList;
import java.util.Arrays;

public class Tree<T> {

    private final ArrayList<String> allowedPositions = (ArrayList<String>) Arrays.asList("left", "right");


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
}
