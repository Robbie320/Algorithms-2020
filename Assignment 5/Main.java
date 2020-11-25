import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Initialize Classes
		SelectionSort selectionSort = new SelectionSort();
		SingleSourceShortestPath sssp = new SingleSourceShortestPath();
		
		//Initialize scanner to scan through graphs2.txt file
		Scanner graphInput = new Scanner(new File("src/graphs2.txt"));
		final int graphFileSize = 88;
		//Initialize array to hold the graph commands
		String[] graphCommandList = new String[graphFileSize];
		String graphCommand;
		
		//Add each line to a command list
		for(int g = 0; graphInput.hasNextLine(); g++) {
			graphCommand = graphInput.nextLine();
			graphCommandList[g] = graphCommand; //add next line to array
			//System.out.println(graphCommand);
		}//end for g
		
		//Initialize scanner to scan through spice.txt file
		Scanner spiceInput = new Scanner(new File("src/spice.txt"));
		final int spiceFileSize = 14;
		//Initialize array to hold the spice commands
		String[] spiceCommandList = new String[spiceFileSize];
		String spiceCommand;
		
		//Add each item in spice commands to the array
		for(int i = 0; spiceInput.hasNextLine(); i++) {
			spiceCommand = spiceInput.nextLine();
			spiceCommandList[i] = spiceCommand; //add next line to array
			//System.out.println(spiceCommand);
		}//end for i
		
		
		//GRAPHING//
		//Initialize variables
		LinkedList graphLinkedList = new LinkedList();
		int vertexIDNum = 0;
		
		int firstVertex = 0;
		boolean first = true;
		
		int vertexCount = 0;
		int edgeCount = 0;
		
		int sourceNum = 0;
		int destinationNum = 0;
		//Using commands in the list to set up the graphs
		for(int c = 0; c < graphFileSize; c++) {
			if(graphCommandList[c].contains("--")) {
				//Then this is a comment, so do nothing
			} else if(graphCommandList[c].contains("new graph")) {
				//Create Linked List
				graphLinkedList = new LinkedList();
				//Initialize variables
				vertexIDNum = 0;
				firstVertex = 0;
				first = true;
				vertexCount = 0;
				edgeCount = 0;;
				sourceNum = 0;
				destinationNum = 0;
			} else if(graphCommandList[c].contains("add vertex")) { //Add Vertex
				Node n = new Node();
				String vertexIDStr = graphCommandList[c].replaceAll("[^\\d-]", "");
				vertexIDNum = Integer.parseInt(vertexIDStr);
				//If this is the first vertex
				if(first) {
					firstVertex = vertexIDNum;
					first = false;
					if(firstVertex == 1) {
						vertexCount++;
					}
				}//end if
				
				//Add vertex node
				n.id = vertexIDNum;
				//n.hasBeenProcessed = false;
				//n.markedForProcessing = false;
				
				//Add to Linked List
				graphLinkedList.insert(n);
				
				//Increment number of Vertices
				vertexCount++;
				
			} else if(graphCommandList[c].contains("add edge")) { //Add Edge
				//Initialize
				String[] vertexStrOne;
				String[] vertexStrTwo;
				vertexStrOne = graphCommandList[c].replaceAll("[^\\d-]", "").split("-", 2);
				vertexStrTwo = vertexStrOne[1].split("",2);
				
				sourceNum = Integer.parseInt(vertexStrOne[0]);
				destinationNum = Integer.parseInt(vertexStrTwo[0]);
				int weight = Integer.parseInt(vertexStrTwo[1]);
				
				//Add the vertices to neighbors int Arraylist
				Node sourceNode = graphLinkedList.search(sourceNum);
				Node destinationNode = graphLinkedList.search(destinationNum);
				
				//Add the edge with the weight
				Edge edgeObj = new Edge(destinationNode, weight);
				sourceNode.neighbors.add(edgeObj);
				
				//increment to go to the next line
				/*if(c < graphFileSize - 1) {
					c++;
				} else {
					break;
				}*/
				if(graphCommandList[c+1].isBlank()) {
					Node firstVertexNode = graphLinkedList.search(firstVertex);
					
					//Single Source Shortest Path (SSSP)
					sssp.bellmanFord(graphLinkedList, firstVertexNode, vertexCount, edgeCount);
					System.out.println();
				}
			} else if(graphCommandList[c].isBlank()) {
				//System.out.println("This is a blank.");
				//System.out.println("\n");
			} else {
				System.out.println("Invalid graph command.");
				break;
			}//end if
		}//end for c
		
		
		//KNAPSACK - SPICE//
		//Using commands in the list to set up the graphs
		//Create Linked List
		LinkedList spiceLinkedList = new LinkedList();
		Node nodeHead = new Node();
		Node newNodeHead = new Node();
		for(int s = 0; s < spiceFileSize; s++) {
			if(spiceCommandList[s].contains("--")) {
				//Then this is a comment, so do nothing
			} else if(spiceCommandList[s].contains("spice")) {
				Node spice = new Node();
				
				String[] firstSplit;
				String[] colorNameSplit;
				String[] totalPriceSplit;
				String[] quantitySplit;
				
				String colorName;
				int totalPrice;
				int quantity;
				
				firstSplit = spiceCommandList[s].replaceAll("\\s","").split(";");
				//color
				colorNameSplit = firstSplit[0].split("=");
				colorName = colorNameSplit[1];
				spice.color = colorName;
				//total price
				totalPriceSplit = firstSplit[1].split("=");
				totalPrice = (int)Double.parseDouble(totalPriceSplit[1]);
				spice.total_price = totalPrice;
				//quantity
				quantitySplit = firstSplit[2].split("=");
				quantity = Integer.parseInt(quantitySplit[1]);
				spice.quantity = quantity;
				//unit price
				spice.unit_price = totalPrice/quantity;
				//Add to Linked List
				spiceLinkedList.insert(spice);
				
				if(spiceCommandList[s+1].isBlank()) { //if next command is knapsack capacity command
					//then sort list with Selection sort
					nodeHead = selectionSort.selectionSort(spice);
				}//end if
				//nodeHead = spiceLinkedList.head;
			} else if(spiceCommandList[s].contains("knapsack")) {
				nodeHead = spiceLinkedList.head;
				newNodeHead = nodeHead;
				int scoops;
				int totalScoops = 0;
				int quatloos = 0;
				int maxCapacity;
				
				int capacity = Integer.parseInt(spiceCommandList[s].replaceAll("[^0-9]",""));
				int tempCapacity = capacity;
				
				while(nodeHead != null && tempCapacity > 0) {
					maxCapacity = nodeHead.quantity;
					if(nodeHead.quantity > capacity) {
						maxCapacity = tempCapacity;
					}//end if
					for(int i = 0; i < maxCapacity; i++) {
						tempCapacity--;
					}
					quatloos += (nodeHead.unit_price)*maxCapacity;
					nodeHead = nodeHead.next;
				}
				
				System.out.print("Knapsack of capacity " + capacity + " is worth " + quatloos + " quatloos and contains ");
				tempCapacity = capacity;
				while(newNodeHead != null && tempCapacity > 0) {
					maxCapacity = newNodeHead.quantity;
					if(newNodeHead.quantity > capacity) {
						maxCapacity = tempCapacity;
					}
					for(scoops = 0; scoops < maxCapacity; scoops++) {
						totalScoops++;
						tempCapacity--;
					}
					
					if(scoops == 1) {
						System.out.print(scoops + " scoop of " + newNodeHead.color);
					} else if (scoops > 1) {
						System.out.print(scoops + " scoops of " + newNodeHead.color);
					}
					newNodeHead = newNodeHead.next;
					if(tempCapacity != 0 && newNodeHead != null) {
						System.out.print(", ");
					}
				}
				System.out.print(".");
				System.out.println();
				
			} else if(spiceCommandList[s].isBlank()) {
				//System.out.println("This is a blank.");
				//System.out.println("\n");
			} else {
				System.out.println("Invalid spice command.");
				break;
			}//end if
		}//end for s
		
	}//end main
}//end Main Class
