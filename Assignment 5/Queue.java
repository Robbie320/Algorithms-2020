public class Queue {
    public Node head;
    public Node tail;
 
    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        } else {
            return false;
        }//end if
    }//end isEmpty
    public void enqueue(Node n) {
        /*Enqueue(Q,x)
        * Q[Q.tail] = x
        * if Q.tail == Q.length
        *   Q.tail = 1
        * else Q.tail = Q.tail + 1 */

        /*Node n = new Node();
        n.item = elem;*/
        
        Node prevTail = this.tail;
        this.tail = n;
    
        if(this.isEmpty()) {
            this.head = this.tail;
        } else {
            prevTail.next = tail;
        }//end if
    }//end enqueue
    public Node dequeue() {
        /*Dequeue(Q)
        * x = Q[Q.head]
        * if Q.head == Q.length
        *   Q.head = 1
        * else Q.head = Q.head + 1
        * return x */
        
        Node retVal = this.head;
        if(this.head == null) {
            return this.head;
        }  else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }//end if
        return retVal;
    }//end dequeue
}//end class Queue
