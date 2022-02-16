public class main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(10);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(30);
        Node<Integer> node6 = new Node<>(20);
        Node<Integer> node7 = new Node<>(12);
        Node<Integer> node8 = new Node<>(33);

        tree.setRoot(
                tree.insert(tree.getRoot(), node1, "right"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node2, "left"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node3, "left"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node4, "right"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node5, "right"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node6, "right"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node7, "left"));
        tree.setRoot(
                tree.insert(tree.getRoot(), node8, "left"));

        System.out.println(tree.toString());
    }
}
