import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Initialize Classes
		BinarySearchTree bst = new BinarySearchTree();
		Random random = new Random();
		Traversal traversal = new Traversal();
		
		//Initialize scanner to scan through magicitems.txt file
		Scanner input = new Scanner(new File("src/magicitems.txt"));
		final int magicitemsFileSize = 666;
		//Initialize array to hold the magicitems
		String[] magicitemsList = new String[magicitemsFileSize];
		String item;
		
		//Add each item in magicitems to the array
		for(int i = 0; input.hasNextLine(); i++) {
			item = input.nextLine().toUpperCase();
			magicitemsList[i] = item; //add next line to array
			//System.out.println(item);
		}//end for i
		
		//Initialize scanner to scan through graphs1.txt file
		Scanner graphInput = new Scanner(new File("src/graphs1.txt"));
		final int graphFileSize = 375;
		//Initialize array to hold the graph commands
		String[] graphCommandList = new String[graphFileSize];
		String command;
		
		//Add each line to a command list
		for(int g = 0; graphInput.hasNextLine(); g++) {
			command = graphInput.nextLine();
			graphCommandList[g] = command;
			//System.out.println(command);
		}//end for g
		
		//GRAPHING//
		//Using commands in the list to set up the graphs
		for(int c = 0; c < graphFileSize; c++) {
			if(graphCommandList[c].contains("--")) {
				//Then this is a comment, so do nothing
			} else if(graphCommandList[c].contains("new graph")) {
				//Create Linked List
				LinkedList linkedList = new LinkedList();
				//Initialize variables
				int vertexIDNum = 0;
				
				int firstVertex = 0;
				boolean first = true;
				int vertexCount = 0;
				
				int vertexNum1 = 0;
				int vertexNum2 = 0;
				//increment to go to the next line
				c++;
				
				//Add Vertex
				while(graphCommandList[c].contains("add vertex")) {
					Node n = new Node();
					String vertexIDStr = graphCommandList[c].replaceAll("[^\\d-]", "");
					vertexIDNum = Integer.parseInt(vertexIDStr);
					//If this is the first vertex
					if(first) {
						firstVertex = vertexIDNum;
						first = false;
					}//end if
					
					//Add vertex node
					n.id = vertexIDNum;
					n.hasBeenProcessed = false;
					n.markedForProcessing = false;
					//Add to Linked List
					linkedList.insert(n);
					//Increment number of Vertices
					vertexCount++;
					//increment to go to the next line
					c++;
				}//end while
				
				if(firstVertex == 1) {
					vertexCount++;
				}//end if
				
				//Create a Matrix
				//ArrayList<Integer> matrix = new ArrayList<Integer>();
				String matrix[][] = new String[vertexCount][vertexCount];
				//Initialize matrix
				for(int i = firstVertex; i < vertexCount; i++) {
					for(int n = firstVertex; n < vertexCount; n++) {
						matrix[i][n] = ".";
						//Check Matrix
						//System.out.print("  " + matrix[i][n] + "  ");
					}//end for n
					//System.out.println();
				}//end for i
				
				//Create adjacency list
				//ArrayList<Integer> adjacencyList = new ArrayList<Integer>();
				ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(vertexCount);
				//Initialize adjacency list
				for(int i = 0; i < vertexCount; i++) {
					adjacencyList.add(new ArrayList());
				}//end for i
				
				//Add Edge
				while(graphCommandList[c].contains("add edge")) {
					//Initialize
					String[] vertexStr;
					vertexStr = graphCommandList[c].replaceAll("[^\\d-]", "").split("-");
					vertexNum1 = Integer.parseInt(vertexStr[0]);
					vertexNum2 = Integer.parseInt(vertexStr[1]);
					
					//Add the vertices to neighbors int Arraylist
					Node vertexNode1 = linkedList.search(vertexNum1);
					Node vertexNode2 = linkedList.search(vertexNum2);
					vertexNode1.neighbors.add(vertexNode2);
					vertexNode2.neighbors.add(vertexNode1);
					
					//Populate matrix with edges
					matrix[vertexNum1][vertexNum2] = "1";
					matrix[vertexNum2][vertexNum1] = "1";
					
					//Populate adjacency list
					adjacencyList.get(vertexNum1).add(vertexNum2);
					adjacencyList.get(vertexNum2).add(vertexNum1);
					
					
					//increment to go to the next line
					if(c < graphFileSize - 1) {
						c++;
					} else {
						break;
					}
				}//end while
				//Print matrix
				for(int m = firstVertex; m < vertexCount; m++) {
					for(int a = firstVertex; a < vertexCount; a++) {
						System.out.print(" " + matrix[m][a] + " ");
					}//end for a
					System.out.println();
				}//end for m
				
				//Print adjacency list
				for(int a = firstVertex; a < vertexCount; a++) {
					int edgeCount = adjacencyList.get(a).size();
					System.out.print("[" + (a) + "] ");
					for(int d = 0; d < edgeCount; d++) {
						Integer x = adjacencyList.get(a).get(d);
						System.out.print(x + " ");
					}//end for d
					System.out.println();
				}//end for a
				//System.out.println(Arrays.toString(adjacencyList.toArray()));
				System.out.println();
				
				Node vertexNode = linkedList.search(firstVertex);
				System.out.print("DFS: ");
				traversal.dfs(vertexNode);
				System.out.println("\n");
				System.out.print("BFS: ");
				traversal.bfs(vertexNode);
				System.out.println("\n");
				
			}else if(graphCommandList[c] == "") {
				System.out.println("\n");
			} else {
				System.out.println("Invalid command.");
				break;
			}//end if
		}//end for c
		
		//BINARY SEARCH TREE//
		//Make root
		/*Node root = new Node();
		root.key = magicitemsList[0];
		root.parent = null;*/
		
		//Insert Nodes into the BST
		for(int b = 0; b < magicitemsFileSize; b++) {
			//Build the Tree
			bst.treeInsert(magicitemsList[b]);
		}//end for b
		
		//Search the BST
		String target = "";
		String[] targetList = new String[42];
		int avgComparisons = 0;
		//List of 42 Random Magic Items to Insert
		for(var t = 0; t < targetList.length; t++) {
			int randInt = random.nextInt(magicitemsList.length);
			target = magicitemsList[randInt];
			targetList[t] = target;
			//Search for the 42 Random Magic Items
			bst.treeSearch(bst.root, target);
		}//end for t
		avgComparisons = bst.comparisons/42;
		
		System.out.println("Binary Search Tree:");
		System.out.println("Number of Search Comparisons = " + (bst.comparisons));
		System.out.println("Average Number of Search Comparisons = " + (avgComparisons));
	}//end main
}//end Main Class
