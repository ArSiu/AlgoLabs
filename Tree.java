import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
    Node root;
    int size;
    ArrayList<String> a = new ArrayList<>();


    public void search(int value) {
        Node currentNode = search(value,root);
        if(currentNode == null) {
            System.out.println("no such element");
        }else {
            System.out.println(currentNode.value);
        }
    }

    private Node search(int value, Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.value == value) {
            return currentNode;
        }
        if(value < currentNode.value) {
            return search(value, currentNode.left);
        }
        return search(value, currentNode.right);


    }

    public void add(int value){
        if(root == null) {
            root = new Node(value);
        }
        add(value,root);
    }

    private void add(int value,Node currentNode) {
        if(value < currentNode.value) {
            if(currentNode.left != null) {
                add(value, currentNode.left);
            }else {
                currentNode.left = new Node(value);
                size++;
            }
        }else if(value > currentNode.value) {
            if(currentNode.right != null) {
                add(value, currentNode.right);
            }else {
                currentNode.right = new Node(value);
                size++;
            }
        }
    }

    public void deleteElem(int value){
        deleteRoot(value,root);
    }

    private Node deleteRoot(int value,Node leaf){
        if(leaf == null) {
            return leaf;
        } else {
            leaf.left = deleteRoot(value,leaf.left);
            leaf.right = deleteRoot(value,leaf.right);
        }

        if(leaf.value == value) {
            if(leaf.left == null) {
                Node temp = leaf.right;
                leaf = null;
                return temp;
            }else if(leaf.right == null){
                Node temp = leaf.left;
                leaf = null;
                return temp;
            }
            Node temp = minValueNode(leaf.right);
            leaf.value = temp.value;
            leaf.right = deleteRoot(temp.value,leaf.right);
        }
        return leaf;
    }

    private Node minValueNode(Node leaf) {
        Node current = leaf;
        while (current!=null && current.left !=null){
            current = current.left;
        }
        return current;
    }


    public void print() {
        print(root,size);
        printInorder(root);

    }

    void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.right);
        System.out.print(node.value);
        printInorder(node.left);


    }



    private void print(Node currentNode, int amountOfSpace) {
        if(currentNode == null){
            return;
        }
        int space = size + amountOfSpace+1;
        print(currentNode.right, space);
        printSpaces(space);
        System.out.println(currentNode.value);
        print(currentNode.left,space);

    }

    private void printSpaces(int amountOfSpace){
        for (int i = 0; i < amountOfSpace; i++) {
            System.out.print(" ");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
