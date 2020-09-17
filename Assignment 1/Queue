public class Queue {
    public Node head;
    public Node tail;
 
    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }
    public void enqueue(String elem) {
        /*Enqueue(Q,x)
        * Q[Q.tail] = x
        * if Q.tail == Q.length
        *   Q.tail = 1
        * else Q.tail = Q.tail + 1 */

        Node n = new Node();
        n.item = elem;
    
        Node prevBack = this.tail;
        this.tail = n;
        //n.next = this.tail; <- this ONE line ruined everything and left me puzzled for hours
        
        if(isEmpty()) {
            this.head = this.tail;
        }else {
            prevBack.next = tail;
        }
    }
    Node dequeue() {
        /*Dequeue(Q)
        * x = Q[Q.head]
        * if Q.head == Q.length
        *   Q.head = 1
        * else Q.head = Q.head + 1
        * return x */

        if (this.isEmpty()) {
            System.out.print("Queue is empty.");
            return null;
        }else {
            Node retVal = this.head;
            this.head = this.head.next;
            return retVal;
        }
    }
}
