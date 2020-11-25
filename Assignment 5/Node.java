import java.util.ArrayList;

public class Node {
    //For Linked List
    public Node head;
    public Node next;
    public Node prev;
    //public String item;
    
    //For Graph Linked Objects
    public int id;
    //public boolean hasBeenProcessed;
    //public boolean markedForProcessing;
    public ArrayList<Edge> neighbors = new ArrayList<>();
    
    //For Single Source Shortest Path (SSSP)
    public ArrayList<Node> vertices = new ArrayList<>();
    //public ArrayList<Object> directedEdges = new ArrayList<>();
    //Node source
    //Node destination
    //int weight
    int distance;
    Node prevVertex;
    
    //Knapsack - Spice
    public String color;
    public int total_price;
    public int quantity;
    public int unit_price;
}//end class Node
