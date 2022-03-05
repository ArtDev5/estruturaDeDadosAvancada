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

    public void getSubTrees(Node<T> currentNode){
        ArrayList <T> subArvores = new ArrayList<T>();   
        if(currentNode == root){
            if(currentNode.getLeft() != null){
                getSubTrees(currentNode.getLeft(), subArvores);
            }
            if(currentNode.getRight() != null){
                getSubTrees(currentNode.getRight(), subArvores);
            }
        }
    }

    public void getSubTrees(Node<T> currentNode, ArrayList<T> subArvores){
        if(currentNode == root){
            if(currentNode.getLeft() != null){
                getSubTrees(currentNode.getLeft(), subArvores);
            }
            if(currentNode.getRight() != null){
                getSubTrees(currentNode.getRight(), subArvores);
            }
        }
        if(currentNode.getLeft() != null){
            if(!subArvores.contains(currentNode.getKey())){
                subArvores.add(currentNode.getKey());
                System.out.println("Sub Arvore: " + currentNode.getKey());
                getSubTrees(currentNode.getLeft(), subArvores);
            }
            getSubTrees(currentNode.getLeft(), subArvores);
        }
        if(currentNode.getRight() != null){
            if(!subArvores.contains(currentNode.getKey())){
                subArvores.add(currentNode.getKey());
                System.out.println("Sub Arvore: " + currentNode.getKey());
                getSubTrees(currentNode.getRight(), subArvores);
            }
            getSubTrees(currentNode.getRight(), subArvores);
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

    //TODO quantityOfAncestors
    public void takeDepth(Node<T> root) {
        ArrayList<NodeValues> results = findAncestry(root, 0, new ArrayList<>());
        Collections.sort(results);
        Collections.reverse(results);
        results.forEach(it -> {
            System.out.println("Node " + it.getKey() + " com profundidade: " + it.getValue());
        });
    }

    public void getLevel(Node<T> root) {
        int number = 0;
        ArrayList<NodeValues> results = findAncestry(root, number, new ArrayList<>());
        Collections.sort(results);
        Collections.reverse(results);
        results.forEach(it -> {
            System.out.println("Node " + it.getKey() + " com nível: " + it.getValue());
        });
    }

    public ArrayList<NodeValues> findAncestry(Node<T> currentNode, int number, ArrayList<NodeValues> list) {
        if (currentNode != null) {
            list.add(new NodeValues(currentNode.getKey(), number));
            list = findAncestry(currentNode.getLeft(), number + 1, list);
            list = findAncestry(currentNode.getRight(), number + 1, list);
        }
        return list;
    }

    public void walkThroughTree(Node<T> currentNode) {
        if (currentNode.getLeft() != null) {
            findDescendants(currentNode, 0);
            walkThroughTree(currentNode.getLeft());
        }
        if (currentNode.getRight() != null){
            findDescendants(currentNode, 0);
            walkThroughTree(currentNode.getRight());
        }

//        System.out.println(currentNode.getKey());
    }

    public void findDescendants(Node<T> currentNode, int number) {
        if (currentNode.getLeft() != null) {
            findDescendants(currentNode.getLeft(), number+1);
        }
        if (currentNode.getRight() != null){
            findDescendants(currentNode.getRight(), number+1);
        }

        System.out.println("com altura de " + number);
    }

    //TODO F Os níveis de cada nó



    public void getDegreeNodes(Node<T> currentNode){
        ArrayList<T> degreeNodes = new ArrayList<>();
        int degree = 0;
        if(currentNode.getLeft() != null){
            degreeNodes.add(currentNode.getKey());
            degree++;
        }
        if(currentNode.getRight() != null){
            degreeNodes.add(currentNode.getKey());
            degree++;
        }
        System.out.println("Nó " + currentNode.getKey() + " com grau: " + degree);
        if(currentNode.getLeft() != null){
            getDegreeNodes(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            getDegreeNodes(currentNode.getRight());
        }

    }

    public void getDegreeNodes(Node<T> currentNode, ArrayList<T> degreeNodes){
        int degree = 0;
        if(currentNode.getLeft() != null){
            degreeNodes.add(currentNode.getKey());
            degree++;
        }
        if(currentNode.getRight() != null){
            degreeNodes.add(currentNode.getKey());
            degree++;
        }
        if(!degreeNodes.contains(currentNode.getKey())){
            System.out.println("Nó " + currentNode.getKey() + " com grau: " + degree);
        }
        if(currentNode.getLeft() != null){
            getDegreeNodes(currentNode.getLeft(), degreeNodes);
        }
        if(currentNode.getRight() != null){
            getDegreeNodes(currentNode.getRight(), degreeNodes);
        }
        
    }
    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
