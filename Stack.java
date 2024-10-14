public class Stack<Type>{
    private Node first;
    private class Node {
       private Type item;
       private Node next;
    }
    public boolean isEmpty() {
       return first == null;
    }
    public void push(Type item) {
       Node second = first;
       first = new Node();
       first.item = item;
       first.next = second;
    }
    public Type pop() {
       Type item = first.item;
       first = first.next;
       return item;
    }
    public Type peek() {
       return first.item;
    }
 }
 