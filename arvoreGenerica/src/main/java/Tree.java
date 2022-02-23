import java.util.ArrayList;
import java.util.Arrays;

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

    public void getSubarvores(Node<T> currentNode){
        ArrayList <T> subArvores = new ArrayList<T>();   
        if(currentNode == root){
            if(currentNode.getLeft() != null){
                getSubarvores(currentNode.getLeft(), subArvores);
            }
            if(currentNode.getRight() != null){
                getSubarvores(currentNode.getRight(), subArvores);
            }
        }
    }

    public void getSubarvores(Node<T> currentNode, ArrayList<T> subArvores){
        if(currentNode == root){
            if(currentNode.getLeft() != null){
                getSubarvores(currentNode.getLeft(), subArvores);
            }
            if(currentNode.getRight() != null){
                getSubarvores(currentNode.getRight(), subArvores);
            }
        }
        if(currentNode.getLeft() != null){
            if(!subArvores.contains(currentNode.getKey())){
                subArvores.add(currentNode.getKey());
                System.out.println("Sub Arvore: " + currentNode.getKey());
                getSubarvores(currentNode.getLeft(), subArvores);
            }
            getSubarvores(currentNode.getLeft(), subArvores);
        }
        if(currentNode.getRight() != null){
            if(!subArvores.contains(currentNode.getKey())){
                subArvores.add(currentNode.getKey());
                System.out.println("Sub Arvore: " + currentNode.getKey());
                getSubarvores(currentNode.getRight(), subArvores);
            }
            getSubarvores(currentNode.getRight(), subArvores);
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

    //TODO E A profundidade de cada nó
//    public int takeDepth(Node<T> root, Node<T> specificNode) {
//        int i = 0;
//        return i + foundNode(root, specificNode);
//    }

//    public Node<T> foundNode(Node<T> currentNode, T wantedKey) {
//        if (currentNode == null) return null;
//        if (currentNode.getKey() == wantedKey) return currentNode;
//        if (currentNode.getLeft() != null) return foundNode(currentNode.getLeft(), wantedKey);
//        return foundNode(currentNode.getRight(), wantedKey);
//    }


    //TODO F Os níveis de cada nó


    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
