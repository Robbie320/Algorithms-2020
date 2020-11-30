import java.util.ArrayList;

public class SingleSourceShortestPath {
	public void initSingleSource(LinkedList graphLinkedList, Node sourceVertex, int vertexCount) {
		/*Init-Single-Source(G,s)
		* 	for each v ∈ G.V
		* 		v.d = ∞		//estimate of shortest path distance
		* 		v.π = NIL	//predecessor vertex
		*	s.d = 0 */
		for(int i = 1; i < vertexCount; i++) {
			Node vertex = graphLinkedList.search(i);
			vertex.distance = Integer.MAX_VALUE;
			vertex.prevVertex = null;
		}//end for i
		sourceVertex.distance = 0;
	}//end initSingleSource
	public void bellmanFord(LinkedList graphLinkedList, Node sourceVertex, int vertexCount, int edgeCount) {
		/*Bellman-Ford(G,w,s)
		* 	Init-Single-Source(G,s)
		* 	for i = 1 to |G.V| - 1
		* 		for each edge(u,v) ∈ G.E
		* 			Relax(u,v,w)
		* 	for each edge(u,v) ∈ G.E
		* 		if v.d > u.d + w(u,v)
		* 			return FALSE
		* 	return TRUE */
		this.initSingleSource(graphLinkedList, sourceVertex, vertexCount);
		
		Node source = null;
		Node destination = null;
		String path = "";
		int cost = 0;
		boolean first = true;
		
		for(int i = 1 /*sourceVertex.id*/; i < (vertexCount-1); i++) {
			for(int t = 1; t < vertexCount; t++) {
				source = graphLinkedList.search(t);
				for (int j = 0; j < source.neighbors.size(); j++) {
					destination = source.neighbors.get(j).getDestination();
					int weight = source.neighbors.get(j).getWeight();
					this.relax(graphLinkedList, source, destination, weight);
				}//end for j
			}//end for t
		}//end for i
	}//end bellmanFord
	public boolean relax(LinkedList graphLinkedList, Node from, Node to, int weight) {
		/*Relax(u,v,w)
		* 	if v.d > u.d + w(u,v)
		* 		v.d = u.d + w(u,v)
		* 		v.π = u */
		if(to.distance > (from.distance + weight)) {
			to.distance = from.distance + weight;
			to.prevVertex = from;
			return false;
		}//end if
		return true;
	}//end relax
	public void printSSSPOutput(LinkedList graphLinkedList, Node sourceVertex, int vertexCount) {
		Node destination = null;
		int cost = 0;
		
		for(int d = (sourceVertex.id+1); d < vertexCount; d++) {
			destination = graphLinkedList.search(d);
			
			cost = destination.distance;
			System.out.print(sourceVertex.id + " -> " + (d) + " cost is " + cost + "; path is " + sourceVertex.id);
			
			Node tempDestination = destination;
			ArrayList<Node> tempArray = new ArrayList<>();
			while(tempDestination.prevVertex != null) {
				tempArray.add(tempDestination);
				tempDestination = tempDestination.prevVertex;
			}//end while
			
			for(int p = tempArray.size()-1; p > -1; p--) {
				System.out.print(" -> " + tempArray.get(p).id);
			}//end for p
			System.out.print(".");
			System.out.println();
		}//end for d
	}//end printOutput
}//end class SingleSourceShortestPath
