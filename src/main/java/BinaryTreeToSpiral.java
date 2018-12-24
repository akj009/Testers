import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import models.TreeNode;

public class BinaryTreeToSpiral {

    public static void printSpiral(TreeNode binaryTreeRootNode) {
        List<String> levelNodeList;
        int levelCount = 0;
         do {
            levelNodeList = new ArrayList<>();
            getChildAtLevel(binaryTreeRootNode, levelCount++, 0, levelNodeList);
            if(levelNodeList.size() == 0) {
                continue;
            }
            if(levelCount%2 == 0) {
                Collections.reverse(levelNodeList);
                System.out.print(levelNodeList);
            } else {
                System.out.print(levelNodeList);
            }
         } while (levelNodeList.size() > 0);
    }

    public static void getChildAtLevel(TreeNode node, int level, int currentLevel, List<String> levelNodeList) {
        if(node == null) {
            return;
        }

        if(currentLevel == level) {
            levelNodeList.add(node.getData());
            return;
        }

        getChildAtLevel(node.getLeft(), level, currentLevel + 1, levelNodeList);
        getChildAtLevel(node.getRight(), level, currentLevel + 1, levelNodeList);
    }

    public static void main(String[] args) {
        TreeNode binaryTreeRootNode = new TreeNode("10");
        TreeNode binaryTreeLeftNode = new TreeNode("20");
        TreeNode binaryTreeRightNode = new TreeNode("30");
        TreeNode node1 = new TreeNode("40");
        TreeNode node2 = new TreeNode("50");
        TreeNode node3 = new TreeNode("60");

        binaryTreeRootNode.setLeft(binaryTreeLeftNode);
        binaryTreeRootNode.setRight(binaryTreeRightNode);
        binaryTreeLeftNode.setLeft(node1);
        binaryTreeLeftNode.setRight(node2);
        binaryTreeRightNode.setLeft(node3);

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

        printSpiral(binaryTreeRootNode);
    }
} 