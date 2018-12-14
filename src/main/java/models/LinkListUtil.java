package models;

import models.LinkNode;

public class LinkListUtil {

  static LinkedList reversed = new LinkedList();

  public static void reverseList(LinkNode prev, LinkNode next) {

    if(next.getNext() != null) {
      reverseList(next, next.getNext());
    } else {
      reversed.setHeadNode( next );
    }

    next.setNext(prev);
  }
}
