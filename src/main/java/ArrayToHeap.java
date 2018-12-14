public class ArrayToHeap {

  public static void main(String[] args) {
    int inputArr[] = new int[] {2, 5, 8, 30, 20, 7, 9, 6, 25};
    TreeNode rootNode = new TreeNode(inputArr[0], null, null, null);
    for (int i = 0; i < inputArr.length; i++) {

    }
  }

  static class TreeNode {
    int currentValue;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;

    TreeNode(int currentValue, TreeNode leftChild, TreeNode rightChild, TreeNode parent) {
      this.currentValue = currentValue;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
      this.parent = parent;
    }
  }
}
