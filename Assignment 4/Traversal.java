public class Traversal {
	public void dfs(Node vertexNode) { //Depth First Search/Traversal
		/*DFS(G,v)
		* 	if(not v.hasBeenProcessed)
		* 		print(v.id)
		* 		v.hasBeenProcessed := true
		* 	for n in v.neighbors
		* 		if(not n.hasBeenProcessed)
		* 			DFS(G,n) */
		
		if(!vertexNode.hasBeenProcessed) {
			System.out.print(vertexNode.id + " ");
			vertexNode.hasBeenProcessed = true;
		}//end if
		for(Node neighbor : vertexNode.neighbors) {
			if(!neighbor.hasBeenProcessed) {
				dfs(neighbor);
			}//end if
		}//end for-each
	}//end dfs
	public void bfs(Node vertexNode) { //Breadth First Search/Traversal
		/*BFS(G,v)
		* 	v.markedForProcessing := true
		* 	Q = new Q() //empty queue
		* 	Q.enqueue(v)
		* 	while(not Q.empty)
		* 		cv = Q.dequeue
		* 		print(cv.id)
		* 		for n in cv.neighbors
		* 			if(not n.markedForProcessing)
		* 				Q.enqueue(n)
		* 				n.markedForProcessing := true */
		
		Queue queue = new Queue(); //empty queue
		queue.enqueue(vertexNode);
		vertexNode.markedForProcessing = true;
		while(!queue.isEmpty()) {
			Node currentVertexNode = queue.dequeue();
			System.out.print(currentVertexNode.id + " ");
			for(Node neighbor : currentVertexNode.neighbors) {
				if(!neighbor.markedForProcessing) {
					queue.enqueue(neighbor);
					neighbor.markedForProcessing = true;
				}//end if
			}//end for-each
		}//end while
	}//end bfs
}//end class Traversal
