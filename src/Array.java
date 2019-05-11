public class Array {
  private int[] data;
  private int size;

  public Array(int capacity) {
    data = new int[capacity];
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

  public void add(int index, int e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("add failed,index is illegal.");
    }

    if (size == data.length) {
      throw new IllegalArgumentException("add failed, array is fulled");
    }

    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }

    data[index] = e;
    size++;
  }

  public void addFirst(int e) {
    add(0, e);
  }

  public void addLast(int e) {
    add(size, e);
  }

  public int get(int index) {
    if (index < 0 || index >=size) {
      throw new IllegalArgumentException("index is illegal");
    }

    return data[index];
  }

  public void set(int index, int e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("set is failed,index is illegal");
    }

    data[index] = e;
  }

  public boolean contains(int e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return true;
      }
    }

    return false;
  }

  public int find(int e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return i;
      }
    }

    return -1;
  }

  public int remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Remove failed,index is illegal!");
    }

    int res = data[index];

    for (int i = index + 1; i < size; ++i) {
      data[i - i] = data[i];
    }

    size--;

    return res;
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
