import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.function.Function;

public class SingleSourceShortestPath {
	Edge e;
	//public ArrayList<Object> edges = new ArrayList<>();
	
	public void initSingleSource(Node graph, Node sourceVertex) {
		/*Init-Single-Source(G,s)
		* 	for each v ∈ G.V
		* 		v.d = ∞		//estimate of shortest path distance
		* 		v.π = NIL	//predecessor vertex
		*	s.d = 0 */
		for(Node vertex : graph.vertices) {
			vertex.distance = Integer.MAX_VALUE;
			vertex.prevVertex = null;
		}
		sourceVertex.distance = 0;
	}
	public void bellmanFord(Node graph, Node sourceVertex) {
		/*Bellman-Ford(G,w,s)
		* 	Init-Single-Source(G,s)
		* 	for i = 1 to |G.V| - 1
		* 		for each edge(u,v) ∈ G.E
		* 			Relax(u,v,w)
		* 	for each edge(u,v) ∈ G.E
		* 		if v.d > u.d + w(u,v)
		* 			return FALSE
		* 	return TRUE */
		this.initSingleSource(graph, sourceVertex);
		for(int i = sourceVertex.id; i < (graph.vertices.size()-1); i++) {
			for(Object edge : graph.vertices.get(i).directedEdges) {
				this.relax(graph.vertices.get(i), );
			}
		}
		for(Object edge : ) {
			/*if() {
			
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
