public class Node<T extends Comparable<T>>{
    public T data;
    public char color;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;


    public Node() {
        this.data = null;
        this.color = ' ';
        this.left = this;
        this.right = this;
        this.parent = this;
    }

    Node(T data){
        this.data = data;
        this.color = 'R';
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
