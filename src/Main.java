import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        BinaryTree B = new BinaryTree();
        BinaryTree MyBinaryTree = B.createBinaryTree(43);

        System.out.println("Unbalanced: ");
        MyBinaryTree.printBinaryTree(MyBinaryTree.root, 0);

        int Depth1 = MyBinaryTree.maxDepth(MyBinaryTree.root);
        MyBinaryTree.BalanceTree(MyBinaryTree.root);

        System.out.println("Balanced: ");
        TreePrinter.print(MyBinaryTree.root);

        Object NodeFind = MyBinaryTree.FindNode(MyBinaryTree.root, 8);
        System.out.println("Path to the requested value (0 means that value is not present): " + NodeFind);

        Object SB = MyBinaryTree.SmallestBiggest(MyBinaryTree.root);
        System.out.println("Biggest and smallest value: " + SB);

        int Depth2 = MyBinaryTree.maxDepth(MyBinaryTree.root);
        System.out.println("Depth of the tree before and after balancing: " + Depth1 + " ---> " + Depth2);
        
        System.out.println("Pre-order search: ");
        MyBinaryTree.Pre_order(MyBinaryTree.root);

    }
}
