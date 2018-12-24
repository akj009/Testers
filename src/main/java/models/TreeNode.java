package models;

public class TreeNode {
    protected String data;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(String data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static boolean hasLeft(TreeNode node) {
        return null != node && node.getLeft() != null;
    }

    public static boolean hasRight(TreeNode node) {
        return null != node && node.getRight() != null;
    }
}