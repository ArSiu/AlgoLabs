public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(21);
        tree.print();
        tree.insert(19);
        tree.print();
        tree.insert(18);
        tree.print();
        tree.insert(17);
        tree.print();
        tree.insert(16);
        tree.print();
        Node<Integer> a = tree.search(17);
        System.out.println(a.data+"l"+a.left.data+"r"+a.right.data+"p"+a.parent.data);
        tree.delete(17);
        tree.print();
        tree.insert(32);
        tree.insert(23);
        tree.insert(46);
        tree.insert(10);
        tree.insert(15);
        tree.insert(21);
        tree.print();
        a = tree.min();
        System.out.println(a.data);
        a = tree.max();
        System.out.println(a.data);

    }
}