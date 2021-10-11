public class RedBlackTree<T extends Comparable<T>>{
    private Node nil = new Node();
    private Node root = nil;
    private int size = 4;

    public void print() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        print(root,size);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void print(Node<T> currentNode, int amountOfSpace) {
        if(currentNode == nil){
            return;
        }
        int space = size + amountOfSpace+1;
        print(currentNode.right, space);
        printSpaces(space);
        System.out.println(currentNode.data+":"+currentNode.color);
        print(currentNode.left,space);
    }

    private void printSpaces(int amountOfSpace){
        for (int i = 0; i < amountOfSpace; i++) {
            System.out.print(" ");
        }
    }

    private void leftRotation(Node<T> x) {
        Node<T> y = x.right;
        x.right = y.left;

        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotation(Node<T> x) {
        Node<T> y = x.left;
        x.left = y.right;

        if (y.right != nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(T data) {
        Node<T> previous = nil;
        Node<T> current = root;
        Node<T> nodeToInsert = new Node(data);

        while (current != nil){
            previous = current;
            if (nodeToInsert.data.compareTo(current.data) < 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        nodeToInsert.parent = previous;

        if(previous == nil){
            root = nodeToInsert;
        }else if(nodeToInsert.data.compareTo(previous.data) < 0){
            previous.left = nodeToInsert;
        }else {
            previous.right = nodeToInsert;
        }
        nodeToInsert.right = nil;
        nodeToInsert.left = nil;
        insertFixUp(nodeToInsert);
    }

    private void insertFixUp(Node<T> z) {
        if(z.parent == nil) {
            root = z;
            z.color = 'B';
            return;
        }
        while (z.parent.color == 'R') {

            if (z.parent == z.parent.parent.left) {
                boolean isRightNil = false;
                boolean isParentNil = false;
                Node<T> y = z.parent.parent.right;
                if(y == nil){
                    isRightNil = true;
                }
                if(z.parent == nil){
                    isParentNil = true;
                }
                if(!isRightNil){
                    if (y.color == 'R') {
                        z.parent.color = 'B';
                        y.color = 'B';
                        z.parent.parent.color = 'R';
                        z = z.parent.parent;
                    }
                }else if(!isParentNil){
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotation(z);
                    } else {
                        z.parent.color = 'B';
                        z.parent.parent.color = 'R';
                        rightRotation(z.parent.parent);
                    }
                }
            } else {
                boolean isLeftNil = false;
                boolean isParentNil = false;
                Node<T> y = z.parent.parent.left;
                if(y == nil){
                    isLeftNil = true;
                }
                if(z.parent == nil){
                    isParentNil = true;
                }
                if(!isLeftNil){
                    if (y.color == 'R') {
                        z.parent.color = 'B';
                        y.color = 'B';
                        z.parent.parent.color = 'R';
                        z = z.parent.parent;
                    }
                }else if(!isParentNil){
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotation(z);
                    } else {
                        z.parent.color = 'B';
                        z.parent.parent.color = 'R';
                        leftRotation(z.parent.parent);
                    }
                }
            }
            if(z.parent == nil){
                root.color = 'B';
                return;
            }
        }
    }

    public void delete(T data){
        Node<T> z = nil;
        Node<T> current = root;
        Node<T> nodeToInsert = new Node(data);

        while (current != nil){
            z = current.parent;
            if (nodeToInsert.data.compareTo(current.data) < 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }

        Node<T> y = z;
        Node<T> x;
        char yOriginColor = y.color;
        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimumForDel(z.right);
            yOriginColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginColor == 'B') {
            deleteFixUp(x);
        }
    }

    private void transplant(Node<T> u, Node<T> v) {
        if (u.parent == nil) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
            v.parent = u.parent;
        }
    }

    private void deleteFixUp(Node<T> x) {
        while (x != root && x.color == 'B') {
            if (x == x.parent.left) {
                Node<T> w = x.parent.right;
                if (w.color == 'R') {
                    w.color = 'B';
                    x.parent.color = 'R';
                    leftRotation(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == 'B' && w.right.color == 'B') {
                    w.color = 'R';
                    x = x.parent;
                } else if (w.right.color == 'B') {
                    w.left.color = 'B';
                    w.color = 'R';
                    rightRotation(w);
                    w = x.parent.right;
                }
                w.color = x.parent.color;
                x.parent.color = 'B';
                w.right.color = 'B';
                leftRotation(x.parent);
                x = root;
            } else {
                Node<T> w = x.parent.left;
                if (w.color == 'R') {
                    w.color = 'B';
                    x.parent.color = 'R';
                    rightRotation(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == 'B' && w.left.color == 'B') {
                    w.color = 'R';
                    x = x.parent;
                } else if (w.left.color == 'B') {
                    w.right.color = 'B';
                    w.color = 'R';
                    leftRotation(w);
                    w = x.parent.left;
                }
                w.color = x.parent.color;
                x.parent.color = 'B';
                w.left.color = 'B';
                rightRotation(x.parent);
                x = root;
            }
            if(x == nil){
                root.color = 'B';
                return;
            }
        }
    }

    private Node<T> minimumForDel(Node<T> t) {
        Node<T> p = nil;
        while (t != nil) {
            p = t;
            t = t.left;
        }
        return p;
    }

    public Node<T> search(T data) {
        Node<T> previous = nil;
        Node<T> current = root;
        Node<T> nodeToInsert = new Node(data);

        while (current != nil){
            previous = current.parent;
            if (nodeToInsert.data.compareTo(current.data) < 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return previous;
    }

    public Node<T> min() {
        Node<T> current = root;
        Node<T> p = nil;
        while (current != nil) {
            p = current;
            current = current.left;
        }
        return p;
    }

    public Node<T> max() {
        Node<T> current = root;
        Node<T> p = nil;
        while (current != nil) {
            p = current;
            current = current.right;
        }
        return p;
    }

}