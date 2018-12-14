package models;

public class LinkedList {

  private LinkNode headNode;

  public LinkNode getHeadNode() {
    return headNode;
  }

  public void setHeadNode(LinkNode headNode) {
    this.headNode = headNode;
  }

  public boolean addNodeToEnd(int data) {
    LinkNode tmp = headNode, prev = headNode;
    if(tmp == null) {
      headNode = new LinkNode();
      headNode.setData(data);
      return true;
    }
    while(null != tmp && null != tmp.getNext()) {
      prev = tmp;
      tmp = tmp.getNext();
    }

    LinkNode newNode = new LinkNode();
    newNode.setData(data);

    tmp.setNext(newNode);
    return true;
  }

  public void printList() {
    LinkNode tmp = headNode;
    while(null != tmp) {
      System.out.print(" " + tmp.getData() + " -> ");
      tmp = tmp.getNext();
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addNodeToEnd(1);
    ll.addNodeToEnd(2);
    ll.addNodeToEnd(3);
//    ll.addNodeToEnd(4);
//    ll.addNodeToEnd(5);

    ll.printList();

    LinkListUtil.reverseList(null, ll.headNode);

    LinkListUtil.reversed.printList();
  }
}
