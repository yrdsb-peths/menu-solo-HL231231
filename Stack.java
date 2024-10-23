public class Stack<Type>{
    //Node variable
    private Node first = null;
    
    /**
     * Creates an instance of Node.
     */
    private class Node
    {
       private Type item;
       private Node next;
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty() 
    {
      return first == null;
    }

    /**
     * Checks if there is a second object int he stack.
     */
    public boolean isNextEmpty()
    {
      return first.next == null;
    }

    /**
     * Creates a node and places it at the top of the stack.
     */
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

    /**
     * Removes the first on the stack and returns the value.
     */
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
    
    /**
     * Checks the first item on the stack.
     */
    public Type peek() {
       return first.item;
    }
 }
 