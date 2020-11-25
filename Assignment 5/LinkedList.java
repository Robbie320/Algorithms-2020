public class LinkedList {
    public Node head = null;

    public Node search(int k) {
        /*List-Search(L,k)
        *   x = L.head
        *   while x != NIL and x.key != k
        *       x = x.next
        *   return x */
        Node currentNode = this.head;
        while(currentNode != null && currentNode.id != k) {
            currentNode = currentNode.next;
        }//end while
        return currentNode;
    }//end search
    public Node colorSearch(String k) {
        /*List-Search(L,k)
         *   x = L.head
         *   while x != NIL and x.key != k
         *       x = x.next
         *   return x */
        Node currentNode = this.head;
        while(currentNode != null && !currentNode.color.equals(k)) {
            currentNode = currentNode.next;
        }//end while
        return currentNode;
    }//end search
    public void insert(Node n) {
        /*List-Insert(L,x)
        *   x.next = L.head
        *   if L.head != NIL
        *       L.head.prev = x
        *   L.head = x
        *   x.prev = NIL */
        
        n.next = this.head;
        if(this.head != null) {
            this.head.prev = n;
        }//end if
        this.head = n;
        n.prev = null;
    }//end insert
    public void delete(Node n) {
        /*List-Delete(L,x)
         *  if x.prev != NIL
         *      x.prev.next = x.next
         *  else L.head = x.next
         *  if x.next != NIL
         *      x.next.prev = x.prev */
        
        if(n.prev != null) {
            n.prev.next = n.next;
        } else {
            this.head = n.next;
        }//end if
        if(n.next != null) {
            n.next.prev = n.prev;
        }//end if
    }//end delete
}//end class LinkedList
