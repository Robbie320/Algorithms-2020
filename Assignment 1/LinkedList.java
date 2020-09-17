public class LinkedList {
    private Node head = null;
    private String name;
    private int listCount = 0;

    /*public Node search(String k) {
        /*List-Search(L,k)
        * x = L.head
        * while x != NIL and x.key != k
        *   x = x.next
        * return x */

      /*  while(this.head != null && !this.head.equals(k)) {
            this.head = this.head.next;
        }
        return this.head;
    }
    public void insert(String data) {*/
        /*List-Insert(L,x)
        * x.next = L.head
        * if L.head != NIL
        *   L.head.prev = x
        * L.head = x
        * x.prev = NIL */

        /*Node n = new Node();
        n.item = data;
        head.next = this.head;
        if(this.head != null) {
            this.head.prev = this.head;
        }
        head.prev = null;
    }
    public void delete(String data) {*/
        /*List-Delete(L,x)
         * if x.prev != NIL
         *   x.prev.next = x.next
         * else L.head = x.next
         * if x.next != NIL
         *   x.next.prev = x.prev */

        /*Node n = new Node();
        n.item = data;
        if(head.prev != null) {
            head.prev.next = head.next;
        }else {
            this.head = head.next;
        }
        if(head.next != null) {
            head.next.prev = head.prev;
        }
    }*/
}
