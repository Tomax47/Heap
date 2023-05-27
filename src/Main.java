public class Main {
    public static void main(String[] args) {
        TreeNode rootF = new TreeNode("F");
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("BB");
        TreeNode c = new TreeNode("CCC");
        TreeNode d = new TreeNode("DDDD");
        TreeNode e = new TreeNode("EE");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("HHH");
        TreeNode i = new TreeNode("IIII");

        d.setLeftChild(c);
        d.setRightChild(e);

        b.setLeftChild(a);
        b.setRightChild(d);

        i.setLeftChild(h);

        g.setRightChild(i);

        rootF.setLeftChild(b);
        rootF.setRightChild(g);

        System.out.println("Printing Tree Nodes in Preorder:");
        rootF.preorder(node -> System.out.print(node.getData()+" "));

        System.out.println("\n\nPrinting Tree Nodes in Preorder with Custom Logic:");
        rootF.preorder(node -> {
            for (int j = 0; j < 10; j++) {
                System.out.print(node.getData()+" ");
            }
        });

        int totalLength = rootF.preorderFun(node -> node.getData().length());
        System.out.println("\n\nTotal length of all node data: " + totalLength);
    }
}