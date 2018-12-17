public class ArrayToHeap {

    /**
     * 2, 5, 8, 30, 20, 7, 9, 6, 25
     * Max heap -
     *              30
     *         25       9
     *      20    8   5    7
     *   2    6
     *
     *   30, 25, 9, 20, 8, 5, 7, 2, 6
     */

  public static void main(String[] args) {
    int inputArr[] = new int[] {2, 5, 8, 30, 20, 7, 9, 6, 25};
    maxHeapWithLinkedNodes(inputArr); // TODO: Isn't working - not a complete tree
    maxHeapWithArrays(inputArr);
    System.out.println("done");
  }
    // TODO: Incomplete..... :-(
  private static void maxHeapWithArrays(int[] inputArr) {
    int[] heapAsArray = new int[inputArr.length];
    int root = inputArr[0];
    for (int i = 0; i < inputArr.length; i++) {
        int curr = inputArr[i];
        heapAsArray[i] = curr;

    }
  }

  private static int getParentIndex(int currentIdx) {
      return 0;
  }

  private static int getLeftChildIndex(int currentIdx) {
      return 2*currentIdx + 1;
  }

    private static int getRightChildIndex(int currentIdx) {
        return 2*currentIdx + 2;
    }

  private static void maxHeapWithLinkedNodes(int[] inputArr) {
    TreeNode rootNode = new TreeNode(inputArr[0]);
    TreeNode parentNode = rootNode;
    TreeNode currentNode = null;
    for (int i = 1; i < inputArr.length; i++) {
      currentNode = new TreeNode(inputArr[i]);
      heapify(currentNode, parentNode);
      bubbleUp(currentNode);
    }
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
