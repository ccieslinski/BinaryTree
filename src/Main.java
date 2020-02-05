import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        BinaryTree B = new BinaryTree();

        Scanner print = new Scanner(System.in);
        System.out.println("Welcome to your Binary Tree Creator!");
        System.out.println();
        System.out.print("How many nodes would you like to include: ");
        int n = print.nextInt();

        BinaryTree MyBinaryTree = B.createBinaryTree(n);
        System.out.println();

        System.out.println("Unbalanced: ");
        MyBinaryTree.printBinaryTree(MyBinaryTree.root, 0);

        int Depth1 = MyBinaryTree.maxDepth(MyBinaryTree.root);
        MyBinaryTree.BalanceTree(MyBinaryTree.root);

        System.out.println("Balanced: ");
        TreePrinter.print(MyBinaryTree.root);

        System.out.println();
        System.out.print("What value would you like to find in your tree: ");
        int m = print.nextInt();
        Object NodeFind = MyBinaryTree.FindNode(MyBinaryTree.root, m);
        System.out.println();
        System.out.println("Path to the value " + m + " (0 means that value is not present): " + NodeFind);

        Object SB = MyBinaryTree.SmallestBiggest(MyBinaryTree.root);
        System.out.println();
        System.out.println("Biggest and smallest value: " + SB);

        int Depth2 = MyBinaryTree.maxDepth(MyBinaryTree.root);
        System.out.println();
        System.out.println("Depth of the tree before and after balancing: " + Depth1 + " ---> " + Depth2);

        System.out.println();
        System.out.println("Pre-order search: ");
        MyBinaryTree.Pre_order(MyBinaryTree.root);
        System.out.println();

    }
}
