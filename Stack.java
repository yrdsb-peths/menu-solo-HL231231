public class Stack<Type>{
    private Node first;

    private class Node
    {
       private Type item;
       private Node next;
    }

    public boolean isEmpty() 
    {
      return first == null;
    }

    public void push(Type item) {
      if(first != null)
      {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
      }
      else
      {
         first = new Node();
         first.item = item;
      }
    }

    public Type pop() {
      if(first.next != null && first != null)
      {
        Type item = first.item;
        first = first.next;
        return item;
      }
      else if(first != null)
      {
         Type item = first.item;
         first = null;
         return item;
      }
      else
      {
         return null;
      }
    }
    
    public Type peek() {
       return first.item;
    }
 }
 