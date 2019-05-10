public class Main {
  public static void main(String[] argv) {
    Array arr = new Array();
    arr.addLast(123);
    System.out.println(arr.toString());
    arr.addFirst(111);
    System.out.println(arr.toString());
    arr.addLast(333);
    System.out.println(arr.toString());
    arr.add(2, 222);
    System.out.println(arr.toString());
  }
}
