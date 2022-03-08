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

    public void getDegreeNodes(Node<T> currentNode){
        int degree = 0;
        if(currentNode.getLeft() != null){
            degree++;
        }
        if(currentNode.getRight() != null){
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

    public void getHeight(Node<T> currentNode) {
        ArrayList<Integer> list;
        int count = 0;
        if (currentNode.getLeft() != null && currentNode.getRight() == null
                || currentNode.getLeft() != null && currentNode.getRight() != null) {
            count+=1;
            list = findDescendants(currentNode, 0, new ArrayList<>());
            System.out.print("Node " + currentNode.getKey() +" com altura " + list.get(0));
            System.out.println();
            getHeight(currentNode.getLeft());
        }
        if (currentNode.getRight() != null){
            if (count == 0) {
                list = findDescendants(currentNode, 0, new ArrayList<>());
                System.out.print("Node " + currentNode.getKey() +" com altura " + list.get(0));
                System.out.println();
            }
            getHeight(currentNode.getRight());
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            System.out.println("Node " + currentNode.getKey() + " com altura 0");
        }
    }

    public void takeDepths(Node<T> root) {
        ArrayList<NodeValues> results = findAncestries(root, 0, new ArrayList<>());

        Collections.sort(results);
        Collections.reverse(results);
        results.forEach(it -> System.out.println("Node " + it.getKey() + " com profundidade: " + it.getValue()));

    }

    public void getLevels(Node<T> root) {
        ArrayList<NodeValues> results = findAncestries(root, 0, new ArrayList<>());

        Collections.sort(results);
        Collections.reverse(results);
        results.forEach(it -> System.out.println("Node " + it.getKey() + " com nível: " + it.getValue()));
    }


    private ArrayList<NodeValues> findAncestries(Node<T> currentNode, int number, ArrayList<NodeValues> list) {
        if (currentNode != null) {
            list.add(new NodeValues(currentNode.getKey(), number));
            list = findAncestries(currentNode.getLeft(), number + 1, list);
            list = findAncestries(currentNode.getRight(), number + 1, list);
        }
        return list;
    }

    private ArrayList<Integer> findDescendants(Node<T> currentNode, Integer number, ArrayList<Integer> list) {
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (list.isEmpty()) {
                list.add(number);
            } else {
                list.add(Math.max(list.get(0), number));
            }
        } else {
            if (currentNode.getLeft() != null) {
                findDescendants(currentNode.getLeft(), number+1, list);
            }
            if (currentNode.getRight() != null){
                findDescendants(currentNode.getRight(), number+1, list);
            }
        }

        return list;
    }

    public void getSubTrees(Node<T> currentNode){
        
        int count = 0;
        if(currentNode.getLeft() != null){
            count +=1;
            if(currentNode != root){
                System.out.println("Sub Arvore: " + currentNode.getKey());
            }
            getSubTrees(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            if(count == 0){
                System.out.println("Sub Arvore: " + currentNode.getKey());
            }
            getSubTrees(currentNode.getRight());
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
