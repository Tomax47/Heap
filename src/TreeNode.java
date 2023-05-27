import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;

public class TreeNode {
    private String data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(String data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void preorder(Consumer<TreeNode> action) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            action.accept(node);

            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
        }
    }

    public int preorderFun(Function<TreeNode, Integer> action) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);

        int total = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            total += action.apply(node);

            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
        }
        return total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "data='" + data;
    }
}