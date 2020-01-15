import java.util.ArrayList;
import java.lang.Math;

class BinaryTree {

    Node root;

    Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
            current.left.parent = current;
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
            current.right.parent = current;
        } else {
            // value already exists
            return current;
        }

        return current;
    } //recursively inserts nodes to the tree, method by Marcos Lopez Gonzalez found at https://www.baeldung.com/java-binary-tree

    void add(int value) {
        root = addRecursive(root, value);
    } //starts adding values starting from the root, method by Marcos Lopez Gonzalez found at https://www.baeldung.com/java-binary-tree

    BinaryTree createBinaryTree(int num) {
        BinaryTree bt = new BinaryTree();

        Generator g = new Generator();
        ArrayList<Integer> numbers = g.CreateList(num);

        for (int i = 0; i < num; i++)
            bt.add(numbers.get(i));

        return bt;
    } //creates binary tree of num integers, method by Marcos Lopez Gonzalez found at https://www.baeldung.com/java-binary-tree

    void printBinaryTree(Node node, int space) {

        if (node == null)
            return;
        space += 10;
        printBinaryTree(node.right, space);
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.println(node.value);
        printBinaryTree(node.left, space);
    } //prints the binary tree; node parameter should be the root and space should be equal to 0

    void RotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    } //Method from Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein

    void RotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
    } //Method from Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein

    Node FindRoot(Node x) {
        Node current = x;
        while (current != null) {
            if (current.parent == null) break;
            current = current.parent;
        }
        return current;
    } //My own code

    public static double log2(double d) {
        return Math.log(d) / Math.log(2.0);
    }

    int CountNodes(Node root) {
        if (root == null) return 0;
        else return 1 + CountNodes(root.left) + CountNodes(root.right);
    } //My own code

    void ListFromTree(Node root) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.right != null) {
                RotateLeft(tmp);
                tmp = tmp.parent;
            } else tmp = tmp.left;
        }
    } //based on https://pl.wikipedia.org/wiki/Algorytm_DSW

    void BalanceTree(Node root) {
        int n = CountNodes(root);
        Node tmp = root;
        ListFromTree(tmp);
        tmp = FindRoot(tmp);
        int m = (int) (Math.pow(2, Math.floor(log2(n + 1)))) - 1;
        int k = n - m;
        if (k > 0) {
            for (int i = k; i > 0; i--) {
                RotateRight(tmp);
                if (i != 1) tmp = tmp.parent.left;
            }
            tmp = FindRoot(tmp);
        }
        while (m > 1) {
            m = (int) Math.floor(m / 2);
            for (int i = m; i > 0; i--) {
                RotateRight(tmp);
                if (i != 1) tmp = tmp.parent.left;
            }
            tmp = FindRoot(tmp);
        }
    } //given the root, it balances binary tree, based on https://pl.wikipedia.org/wiki/Algorytm_DSW

    Object FindNode(Node root, int x) {
        Node cur = root;
        ArrayList<Integer> path = new ArrayList<>();
        while (cur != null) {
            if (x > cur.value) {
                path.add(cur.value);
                cur = cur.right;
            } else if (x < cur.value) {
                path.add(cur.value);
                cur = cur.left;
            } else {
                path.add(cur.value);
                return path;
            }
        }
        return 0;
    } //given the root and value of a node searched, it returns either 0, if the value is not present in the tree, or the path to a given value, my own code

    Object SmallestBiggest(Node root) {
        ArrayList<Integer> Num = new ArrayList<>();
        Node s = root;
        while (s.right != null) s = s.right;
        Num.add(s.value);
        Node b = root;
        while (b.left != null) b = b.left;
        Num.add(b.value);
        return Num;

    } //My own code

    int maxDepth(Node node) {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    } //Method from https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/

    void Pre_order(Node cur) {
        System.out.print(cur.value + ", ");
        if (cur.left != null) Pre_order(cur.left);
        if (cur.right != null) Pre_order(cur.right);
    } //based on https://pl.wikipedia.org/wiki/Przechodzenie_drzewa

}
