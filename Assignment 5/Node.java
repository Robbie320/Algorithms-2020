import java.util.ArrayList;

public class Node {
    //For Linked List
    public Node head;
    public Node next;
    public Node prev;
    //public String item;
    
    //For Graph Linked Objects / For Single Source Shortest Path (SSSP)
    public int id;
    public ArrayList<Edge> neighbors = new ArrayList<>();
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
