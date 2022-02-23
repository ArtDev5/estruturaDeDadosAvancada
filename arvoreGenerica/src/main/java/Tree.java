import java.util.*;

public class Tree<T> {

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

    //TODO refatorar root dos métodos
    public Node<T> insert(Node<T> root, Node<T> newNode) {

        if (root == null) return newNode;

        if (root.getLeft() == null && root.getRight() == null) {
            root.setLeft(
                    insert(root.getLeft(), newNode));
        } else if (root.getLeft() != null && root.getRight() == null) {
            root.setRight(
                    insert(root.getRight(), newNode)
            );
        } else {
            if (root.getLeft().getLeft() == null) {
                root.setLeft(insert(root.getLeft(), newNode));
            } else if (root.getRight().getLeft() == null) {
                root.setRight(insert(root.getRight(), newNode));
            } else {
                root.setLeft(insert(root.getLeft(), newNode));
            }
        }

        return root;
    }

    private Node<T> availableNode(Node<T> currentNode) {
        if (currentNode == null) return null;
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            return currentNode;
        }

        if (currentNode.getLeft() != null) {
            return availableNode(currentNode.getLeft());
        }
        return availableNode(currentNode.getRight());
    }

    public void getExternalsNodes(Node<T> currentNode) {
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            System.out.println("Nó folha: " + currentNode);
        } else {
            if (currentNode.getLeft() != null) {
                getExternalsNodes(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                getExternalsNodes(currentNode.getRight());
            }
        }
    }

    public void getSubarvores(Node<T> currentNode) {
        if (currentNode.getLeft() != null) {
            System.out.println("Subárvore: " + currentNode.getKey());
            getSubarvores(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            System.out.println("Subárvore: " + currentNode.getKey());
            getSubarvores(currentNode.getRight());
        }
    }


//    public Node<T> insertNode(Node<T> root, Node<T> newNode, PositionEnum positionEnum) {
//        if (root == null) {
//            return newNode;
//        }
//
//        if (PositionEnum.LEFT.equals(positionEnum) && root.getLeft() == null) {
//            root.setLeft(
//                    insertNode(root.getLeft(), newNode, PositionEnum.EMPTY));
//        } else if (PositionEnum.RIGHT.equals(positionEnum) && root.getRight() == null) {
//            root.setRight(
//                    insertNode(root.getRight(), newNode, PositionEnum.EMPTY));
//        } else {
//            if (root.getLeft() == null) {
//                root.setLeft(insertNode(root.getLeft(), newNode, positionEnum));
//            } else if (root.getRight() == null) {
//                root.setRight(insertNode(root.getRight(), newNode, positionEnum));
//            } else {
//                insertNode(root.getLeft(), newNode, positionEnum);
//            }
//        }
//
//        return root;
//    }

    //TODO D A altura de cada nó

    public void takeDepth(Node<T> root) {
        int number = 0;
        ArrayList<NodeValues> results = foundNode(root, number, new ArrayList<>());
        Collections.sort(results);
        Collections.reverse(results);
        results.forEach(it -> {
            System.out.println("Node " + it.getKey() + " com profundidade: " + it.getValue());
        });
    }

    public ArrayList<NodeValues> foundNode(Node<T> currentNode, int number, ArrayList<NodeValues> list) {
        if (currentNode != null) {
            list.add(new NodeValues(currentNode.getKey(), number));
            list = foundNode(currentNode.getLeft(), number + 1, list);
            list = foundNode(currentNode.getRight(), number + 1, list);
        }

        return list;
    }


    //TODO F Os níveis de cada nó


    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
