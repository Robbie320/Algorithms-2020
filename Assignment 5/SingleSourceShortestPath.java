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
		for(int i = 0; i < vertexCount; i++) {
			Node vertex = graphLinkedList.search(i);
			vertex.distance = Integer.MAX_VALUE;
			vertex.prevVertex = null;
		}
		sourceVertex.distance = 0;
	}
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
		for(int i = sourceVertex.id; i < (vertexCount-1); i++) {
			Node source = graphLinkedList.search(i);
			for(int j = 0; j < edgeCount; j++) {
				this.relax(source, source.neighbors);
			}
		}
		for(int j = 0; j < edgeCount; j++) {
			/*if() {
				return false;
			}*/
		}
	}
	public void relax(Node source, Node destination) {
		/*Relax(u,v,w)
		* 	if v.d > u.d + w(u,v)
		* 		v.d = u.d + w(u,v)
		* 		v.π = u */
		/*if() {
		
		}*/
	}
	public void printGraphOutput() {
	
	}
}
