public class ArrayToHeap {

  public static void main(String[] args) {
    int inputArr[] = new int[] {2, 5, 8, 30, 20, 7, 9, 6, 25};
    TreeNode rootNode = new TreeNode(inputArr[0]);
    TreeNode parentNode = rootNode;
    TreeNode currentNode = null;
    for (int i = 1; i < inputArr.length; i++) {
      currentNode = new TreeNode(inputArr[i]);
      heapify(currentNode, parentNode);
      bubbleUp(currentNode);
    }
    System.out.println("done");
  }

  private static void heapify(TreeNode currentNode, TreeNode parentNode) {
    if (parentNode.leftChild == null) {
      parentNode.leftChild = currentNode;
    } else if (parentNode.rightChild == null) {
        parentNode.rightChild = currentNode;
    } else {
        parentNode = parentNode.leftChild;
        heapify(currentNode, parentNode);
        return;
    }
    currentNode.parent = parentNode;
  }

  private static void bubbleUp(TreeNode lastNode) {
    if (null != lastNode.parent && lastNode.parent.currentValue < lastNode.currentValue) {
      swapValues(lastNode);
      bubbleUp(lastNode.parent);
    }
  }

  private static void swapValues(TreeNode lastNode) {
    int tmp = lastNode.parent.currentValue;
    lastNode.parent.currentValue = lastNode.currentValue;
    lastNode.currentValue = tmp;
  }

  static class TreeNode {
    int currentValue;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;

    TreeNode(int currentValue) {
      this.currentValue = currentValue;
    }
  }
}
