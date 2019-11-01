package list;

public interface List<E> {
  public boolean addFirst(E e);
  public boolean add(E e, int index);
  public boolean addLast(E e);
  public boolean update(E e, int index);
  public E remove(int index);
  public int contains(E e);
  public int getSize();
  public boolean isEmpty();
}
