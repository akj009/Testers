import models.TreeNode;

public class BreadthFirstTreeTraversal {

    public static int countTreeElements(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return (1 + countTreeElements(node.getLeft()) + countTreeElements(node.getRight()));
    }

    public static void main(String[] args) {
        TreeNode binaryTreeRootNode = new TreeNode("10");
        TreeNode binaryTreeLeftNode = new TreeNode("20");
        TreeNode binaryTreeRightNode = new TreeNode("30");
        TreeNode node1 = new TreeNode("40");
        TreeNode node2 = new TreeNode("50");
        TreeNode node3 = new TreeNode("60");

        TreeNode node1l = new TreeNode("70");
        TreeNode node1r = new TreeNode("80");
        TreeNode node2l = new TreeNode("90");
        TreeNode node2r = new TreeNode("100");
        TreeNode node3l = new TreeNode("110");
        TreeNode node3r = new TreeNode("120");

        node1.setLeft(node1l);
        node1.setRight(node1r);

        node2.setLeft(node2l);
        node2.setRight(node2r);

        node3.setLeft(node3l);
        node3.setRight(node3r);

        binaryTreeRootNode.setLeft(binaryTreeLeftNode);
        binaryTreeRootNode.setRight(binaryTreeRightNode);
        binaryTreeLeftNode.setLeft(node1);
        binaryTreeLeftNode.setRight(node2);
        binaryTreeRightNode.setLeft(node3);

        System.out.println("Total nodes: " + countTreeElements(binaryTreeRootNode));
        
        printChildAtLevel(binaryTreeRootNode, 0, 0);
        System.out.println("\n---------------");
        printChildAtLevel(binaryTreeRootNode, 1, 0);
        System.out.println("\n---------------");
        printChildAtLevel(binaryTreeRootNode, 2, 0);
        System.out.println("\n---------------");
        printChildAtLevel(binaryTreeRootNode, 3, 0);
        System.out.println("\n---------------");
        printChildAtLevel(binaryTreeRootNode, 4, 0);

    }

    public static void breadthFirstTraverse(TreeNode rootNode) {
        int totalNodes = countTreeElements(rootNode);
        int level = 1;
        String arr[] = new String[totalNodes];
        arr[0] = rootNode.getData();
        int currLvlCount = 0;
        while(totalNodes-- > 0) {
            int maxLevelNodes = getMaxLevelNodes(level);
            while(currLvlCount < maxLevelNodes) {

            }
        }
    }

    public static void printChild(TreeNode node) {
        if(node == null) {
            return;
        }

        if(!TreeNode.hasLeft(node) && !TreeNode.hasRight(node)) {
            System.out.print(node.getData() + " ");
        }

        printChild(node.getLeft());
        printChild(node.getRight());
    }

    public static void printChildAtLevel(TreeNode node, int level, int currentLevel) {
        if(node == null) {
            return;
        }

        if(node != null && currentLevel == level) {
            System.out.print(node.getData() + " ");
            return;
        }

        printChildAtLevel(node.getLeft(), level, currentLevel + 1);
        printChildAtLevel(node.getRight(), level, currentLevel + 1);
    }

    private static int getMaxLevelNodes(int level) {
        return (int) Math.pow(2, level);
    }
}