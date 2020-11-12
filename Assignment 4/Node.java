import java.util.ArrayList;

public class Node {
    //For Linked List
    public Node head;
    public Node next;
    public Node prev;
    //public String item;
    
    //For Graph Linked Objects
    public int id;
    //public boolean processed;
    public boolean hasBeenProcessed;
    public boolean markedForProcessing;
    public ArrayList<Node> neighbors = new ArrayList<Node>();
    
    //For BST
    public String key;
    public Node parent;
    public Node leftChild;
    public Node rightChild;
}//end class Node
