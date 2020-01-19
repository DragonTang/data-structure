import queue.Queue;
public class LoopQueue<E> implements Queue<E> {
  private E[] data;
  private int head;
  private int tail;
  private int size;

  LoopQueue(int capacity) {
    data = (E[])new Object[capacity + 1];
    head = 0;
    tail = 0;
    size = 0;
  }

  LoopQueue() {
    this(10);
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public int getCapacity() {
    return data.length - 1;
  }

  @Override
  public boolean isEmpty() {
    return head == tail;
  }

  @Override
  public E getFront() {
    return data[head];
  }

  private void resize(int newCapacity) {
    E[] newData = (E[])new Object[newCapacity + 1];

    for (int i = 0; i < size; i++) {
      newData[i] = data[head];
      head = (head + 1) % data.length;
    }


    head = 0;
    tail = size;
    data = newData;
  }

  @Override
  public void enqueue(E e) {
    if ((tail + 1) % data.length == head) {
      resize(getCapacity() * 2);
    }
    data[tail] = e;
    size++;
    tail = (tail + 1) % data.length;
  }

  @Override
  public E dequeue() {
    if(isEmpty()) {
      throw new RuntimeException("数组为空");
    }
    E res = data[head];
    head = (head + 1) % data.length;
    size--;

    if ((size == getCapacity() / 4) && getCapacity() != 1) {
      resize(getCapacity() / 2);
    }

    return res;
  }

  @Override
  public String toString() {
    StringBuilder build = new StringBuilder();
    build.append("LoopQueue:\n");
    build.append("head = " + head + "\n");
    build.append("tail = " + tail + "\n");
    build.append("size = " + size + "\n");
    build.append("head { ");
    for (int i = 0; i < data.length; i++) {
      build.append(data[i]);

      if (i != data.length - 1) {
        build.append(", ");
      }
    }

    build.append(" } tail");

    return build.toString();
  }
}
