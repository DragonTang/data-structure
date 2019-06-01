import array.Array;
import stack.ArrayStack;

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
    Array<Student> arr = new Array<>(3);
    arr.addLast(new Student("Alice", 100));
    arr.addLast(new Student("Bob", 96));
    arr.addLast(new Student("Charlie", 98));
    System.out.println(arr.toString());
    arr.addLast(new Student("Marry", 89));
    System.out.println(arr.toString());
    arr.removeLast();
    System.out.println(arr.toString());
    arr.addLast(new Student("Marry", 89));
    System.out.println(arr.toString());

    ArrayStack<Integer> stack = new ArrayStack<>();

    for(int i = 0; i < 10; i++) {
      stack.push(i);
      System.out.println(stack);
    }

    stack.pop();
    System.out.println(stack);
  }
}
