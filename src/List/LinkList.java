package list;
import list.List;

public class LinkList<E> implements List<E> {
  private class Node {
    private E e;
    private Node next;

    Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    Node(E e) {
      this(e, null);
    }
  }

  private int size;
  private Node dummyHead;

  public LinkList() {
    dummyHead = new Node(null, null);
    size = 0;
  }

  public boolean addFirst(E e) {
    return add(e, 0);
  }

  public boolean add(E e, int index) {
    if (index < 0 || index > size) {
      throw new  RuntimeException("参数不合法");
    }
    Node preNext = dummyHead;
    for(int i = 0; i < index; i++) {
      preNext = preNext.next;
    }

    preNext.next = new Node(e, preNext.next);
    size++;
    return true;
  }

  public boolean addLast(E e) {
    return add(e, getSize());
  }

  public boolean update(E e, int index) {
    if (index < 0 || index > getSize() || getSize() == 0) {
      throw new RuntimeException("参数不合法");
    }
    Node preNext = dummyHead.next;
    for (int i = 0; i < index; i++) {
      preNext = preNext.next;
    }
    preNext.e = e;
    return true;
  }

  public E remove(int index) {
    if (index < 0 || index >= getSize() || getSize() == 0) {
      throw new RuntimeException("参数异常");
    }
    Node preNext = dummyHead;
    E res;

    for (int i = 0; i < index; i++) {
      preNext = preNext.next;
    }
    res = preNext.next.e;
    preNext.next = preNext.next.next;
    size--;
    return res;
  }

  public int contains(E e) {
    Node preNext = dummyHead;
    for (int i = 0; i < getSize(); i++) {
      preNext = preNext.next;
      if (preNext.e.equals(e)) {
        return i;
      }
    }
    return -1;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("dummyHead.next ---> ");
    Node preNext = dummyHead;
    for (int i = 0; i < getSize(); i++) {
      preNext = preNext.next;
      res.append(preNext.e);
      res.append(" ----> ");
    }

    res.append("NULL");
    return res.toString();
  }
};
