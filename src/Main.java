import array.Array;
import stack.ArrayStack;
import queue.ArrayQueue;
import list.LinkList;

class Student {
  private String name;
  private int score;

  public Student(String studentName, int studentScore) {
    name = studentName;
    score = studentScore;
  }

  @Override
  public String toString() {
    return String.format("Student(name: %s, score: %d)", name, score);
  }
}

public class Main {
  public static void main(String[] argv) {
    // Array<Student> arr = new Array<>(3);
    // arr.addLast(new Student("Alice", 100));
    // arr.addLast(new Student("Bob", 96));
    // arr.addLast(new Student("Charlie", 98));
    // System.out.println(arr.toString());
    // arr.addLast(new Student("Marry", 89));
    // System.out.println(arr.toString());
    // arr.removeLast();
    // System.out.println(arr.toString());
    // arr.addLast(new Student("Marry", 89));
    // System.out.println(arr.toString());
    //
    // ArrayStack<Integer> stack = new ArrayStack<>();
    //
    // for(int i = 0; i < 10; i++) {
    //   stack.push(i);
    //   System.out.println(stack);
    // }
    //
    // stack.pop();
    // System.out.println(stack);
    //
    // ArrayQueue<Integer> queue = new ArrayQueue<>();
    //
    // for(int i = 0; i < 10; i++) {
    //   queue.enqueue(i);
    //   System.out.println(queue);
    //
    //   if(i % 3 == 2) {
    //     queue.dequeue();
    //     System.out.println(queue);
    //   }
    // }

    LinkList<Object> list = new LinkList<>();
    System.out.println(list.toString());
    list.addFirst(123);
    System.out.println(list.toString());
    list.addFirst(111);
    System.out.println(list.toString());
    list.add(199, 1);
    list.addLast(10000);
    list.add(199, 1);
    list.addLast("abcdefg");
    System.out.println(list.toString());
    list.update("ssh", 2);
    System.out.println(list.toString());
    list.remove(1);
    System.out.println(list.toString());
    System.out.println(list.contains("ssh"));
    System.out.println(list.contains("abcdefg"));
    list.remove(1);
    System.out.println(list.toString());
    list.update("oop", 3);
    System.out.println(list.toString());
  }
}
