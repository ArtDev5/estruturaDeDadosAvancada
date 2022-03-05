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
        ArrayList<Integer> list;
        int count = 0;
        if (currentNode.getLeft() != null && currentNode.getRight() == null
                || currentNode.getLeft() != null && currentNode.getRight() != null) {
            count+=1;
            list = findDescendants(currentNode, 0, new ArrayList<>());
            System.out.print("Node " + currentNode.getKey() +" com altura " + list.get(0));
            System.out.println();
            walkThroughTree(currentNode.getLeft());
        }
        if (currentNode.getRight() != null){
            list = findDescendants(currentNode, 0, new ArrayList<>());
            if (count == 0) {
                System.out.print("Node " + currentNode.getKey() +" com altura " + list.get(0));
                System.out.println();
            }
            walkThroughTree(currentNode.getRight());
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            System.out.println("Node " + currentNode.getKey() + " com altura 0");
        }
    }

    public ArrayList<Integer> findDescendants(Node<T> currentNode, Integer number, ArrayList<Integer> list) {
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (list.isEmpty()) {
                list.add(number);
            } else {
                if (list.get(0) < number) {
                    list.remove(0);
                    list.add(number);
                }
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

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
