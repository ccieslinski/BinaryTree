class Node implements TreePrinter.PrintableNode {
    int value;
    Node left;
    Node right;
    Node parent;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
        parent = null;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        String text = Integer.toString(value);
        return text;
    }
}