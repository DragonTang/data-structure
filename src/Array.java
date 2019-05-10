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

  public void add(int index, int e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("exception: index illegal!");
    }

    if (size == data.length) {
      throw new IllegalArgumentException("exception: array is full!");
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
