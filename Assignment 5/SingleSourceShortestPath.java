import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.function.Function;

public class SingleSourceShortestPath {
	Edge e;
	//public ArrayList<Object> edges = new ArrayList<>();
	
	public void initSingleSource(LinkedList graphLinkedList, Node sourceVertex, int vertexCount) {
		/*Init-Single-Source(G,s)
		* 	for each v ∈ G.V
		* 		v.d = ∞		//estimate of shortest path distance
		* 		v.π = NIL	//predecessor vertex
		*	s.d = 0 */
		for(int i = 1; i < vertexCount; i++) {
			Node vertex = graphLinkedList.search(i);
			vertex.distance = Double.POSITIVE_INFINITY;
			vertex.prevVertex = null;
		}//end for i
		sourceVertex.distance = 0.0;
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
		boolean relax;
		for(int i = 1 /*sourceVertex.id*/; i < (vertexCount-1); i++) {
			for(int t = 1; t < vertexCount; t++) {
				source = graphLinkedList.search(t);
				for (int j = 0; j < source.neighbors.size(); j++) {
					Node destination = source.neighbors.get(j).getDestination();
					int weight = source.neighbors.get(j).getWeight();
					relax = this.relax(graphLinkedList, source, destination, weight);
				}//end for j
			}//end t = 0
		}//end for i
	}//end bellmanFord
	public boolean relax(LinkedList graphLinkedList, Node source, Node destination, int weight) {
		/*Relax(u,v,w)
		* 	if v.d > u.d + w(u,v)
		* 		v.d = u.d + w(u,v)
		* 		v.π = u */
		if(destination.distance > (source.distance + weight)) {
			destination.distance = source.distance + weight;
			destination.prevVertex = source;
			return false;
		}//end if
		return true;
	}//end
	public void printGraphOutput() {
	
	}//end printGraphOutput
}//end class SingleSourceShortestPath
