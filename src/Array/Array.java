package array;

public class Array<E> {
  private E[] data;
  private int size;

  public Array(int capacity) {
    data = (E[])new Object[capacity];
    size = 0;
  }

  public Array() {
    this(10);
  }

  public int getSize() {
    return size;
  }

  public int getCapacity() {
    return data.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("add failed,index is illegal.");
    }

    if (size == data.length) {
      resize(data.length * 2);
    }

    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }

    data[index] = e;
    size++;
  }

  private void resize(int newCapacity) {
    E[] newDate = (E[])new Object[newCapacity];

    for (int i = 0; i < size; i++)
      newDate[i] = data[i];
    data = newDate;
  }

  public void addFirst(E e) {
    add(0, e);
  }

  public void addLast(E e) {
    add(size, e);
  }

  public E get(int index) {
    if (index < 0 || index >=size) {
      throw new IllegalArgumentException("index is illegal");
    }

    return data[index];
  }

  public E getLast() {
    return get(size - 1);
  }

  public E getFirst() {
    return get(0);
  }

  public void set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("set is failed,index is illegal");
    }

    data[index] = e;
  }

  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return true;
      }
    }

    return false;
  }

  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }

    return -1;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Remove failed,index is illegal!");
    }

    E res = data[index];

    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    size--;
    data[size] = null;

    int judge = data.length / 4;
    if (size ==  judge && (judge != 0))
      resize(data.length / 4);

    return res;
  }

  public E removeFirst() {
    return remove(0);
  }

  public E removeLast() {
    return remove(size - 1);
  }

  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("size = %d, capacity = %d\n", size, data.length));
    res.append("{ ");
    for (int i = 0; i < data.length; i++) {
      if (i != data.length - 1) {
        res.append(data[i] + ", ");
      } else {
        res.append(data[i] + " }");
      }
    }
    return res.toString();
  }
}