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
        Node<Integer> node9 = new Node<>(65);
        Node<Integer> node10 = new Node<>(99);
        Node<Integer> node11 = new Node<>(57);

        tree.setRoot(
                tree.insert(tree.getRoot(), node1));
        tree.setRoot(
                tree.insert(tree.getRoot(), node2));
        tree.setRoot(
                tree.insert(tree.getRoot(), node3));
        tree.setRoot(
                tree.insert(tree.getRoot(), node4));
        tree.setRoot(
                tree.insert(tree.getRoot(), node5));
        tree.setRoot(
                tree.insert(tree.getRoot(), node6));
        tree.setRoot(
                tree.insert(tree.getRoot(), node7));
        tree.setRoot(
                tree.insert(tree.getRoot(), node8));
        tree.setRoot(
                tree.insert(tree.getRoot(), node9));
        tree.setRoot(
                tree.insert(tree.getRoot(), node10));
        tree.setRoot(
                tree.insert(tree.getRoot(), node11));

//        tree.setRoot(
//                tree.insertNode(tree.getRoot(), node1, PositionEnum.RIGHT));
//        tree.setRoot(
//                tree.insertNode(tree.getRoot(), node2, PositionEnum.LEFT));
//        tree.setRoot(
//                tree.insertNode(tree.getRoot(), node3, PositionEnum.LEFT));
//        tree.setRoot(
//                tree.insertNode(tree.getRoot(), node4, PositionEnum.RIGHT));
//        tree.setRoot(
//                tree.insertNode(tree.getRoot(), node5, PositionEnum.RIGHT));
//        tree.setRoot(
//                tree.insert(tree.getRoot(), node6, PositionEnum.RIGHT));
//        tree.setRoot(
//                tree.insert(tree.getRoot(), node7, PositionEnum.LEFT));
//        tree.setRoot(
//                tree.insert(tree.getRoot(), node8, PositionEnum.LEFT));

        System.out.println();
        System.out.println();
        System.out.println(tree.toString());

        tree.getExternalsNodes(tree.getRoot());
        tree.getSubarvores(tree.getRoot());

//        System.out.println(tree.foundNode(tree.getRoot(), node8.getKey()));
    }
}