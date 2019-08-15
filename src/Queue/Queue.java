package queue;

public interface Queue<E> {
  public int getSize();
  public int getCapacity();
  public boolean isEmpty();
  public void enqueue(E e);
  public E dequeue() throws Exception;
  public E getFront();
}
