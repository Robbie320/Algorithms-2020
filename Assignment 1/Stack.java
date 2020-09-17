public class Stack {
    public Node top;

    boolean isEmpty() {
        /*Stack-Empty(S)
        * if S.top == 0
        *   return TRUE
        * else return FALSE */

        if (top == null) {
            return true;
        } else {
            return false;
        }
    }
    void push(String elem) {
        /*Push(S,x)
        * S.top = S.top + 1
        * S[S.top] = x */

        Node n = new Node();
        n.item = elem;

        Node prevTop = this.top;
        this.top = n;
        n.next = prevTop;
    }
    Node pop() {
        /*Pop(S)
        * if Stack-Empty(S)
        *   error "underflow"
        * else S.top = S.top - 1
        *   return S[S.top + 1] */

        if (this.isEmpty()) {
            System.out.print("Stack is empty.");
            return null;
        }else {
            Node retVal = this.top;
            this.top = this.top.next;
            return retVal;
        }
    }
}
