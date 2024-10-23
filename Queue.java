public class Queue<Type>{
    //Node varaiable
    private Node first, last;
    
    /**
     * Creates an instance of a node class.
     */
    private class Node{ Type item; Node next; }
    
    /**
     * Checks if the queue is empty
     */
    public boolean isEmpty() { return (first == null); }
    
    /**
     * Creates a node and places it at the end of the queue
     */
    public void enqueue(Type item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())  first = last;
        else            oldLast.next = last;
    }
    
    /**
     * Removes the first object in the queue and returns the value.
     */
    public Type dequeue() {
        Type item = first.item;
        first = first.next;
        if (isEmpty())  first = last;
        return item;
    }
    
    /**
     * Checks the first item in the queue.
     */
    public Type checkFirst()
    {
        return first.item;
    }
}
