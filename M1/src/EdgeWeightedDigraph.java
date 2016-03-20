import java.util.Stack;
import java.util.Vector;


public class EdgeWeightedDigraph{

	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;                // number of vertices in this digraph
	private int E;                      // number of edges in this digraph
	private Vector<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v




	/**
	 * Initializes an empty edge-weighted digraph with <tt>V</tt> vertices and 0 edges.
	 *
	 * @param  V the number of vertices
	 * @throws IllegalArgumentException if <tt>V</tt> < 0
	 */
	public EdgeWeightedDigraph(int V) {

		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;

		adj = (Vector<DirectedEdge>[]) new Vector[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Vector<DirectedEdge>();
	}



	public EdgeWeightedDigraph(EdgeWeightedDigraph Other) {

		this(Other.V);
		if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
		this.E=Other.E;


		for (int v = 0; v < V; v++) {
			for (DirectedEdge e : Other.adj(v)) {
				this.addEdge(e);
			}
		}


	}


	/**
	 * Returns the number of vertices in this edge-weighted digraph.
	 *
	 * @return the number of vertices in this edge-weighted digraph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in this edge-weighted digraph.
	 *
	 * @return the number of edges in this edge-weighted digraph
	 */
	public int E() {
		return E;
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < V
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	}

	/**
	 * Adds the directed edge <tt>e</tt> to this edge-weighted digraph.
	 *
	 * @param  e the edge
	 * @throws IndexOutOfBoundsException unless endpoints of edge are between 0 and V-1
	 */
	public void addEdge(DirectedEdge e) {


		int v = e.from();
		int w = e.to();
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);


	}


	/**
	 * remove the directed edge <tt>e</tt> to this edge-weighted digraph.
	 * And Create new DirectEdege by change value of Weight
	 * @param  e the edge
	 * @throws IndexOutOfBoundsException unless endpoints of edge are between 0 and V-1
	 */


	public void Update(DirectedEdge e)
	{

		int v = e.from();
		int w = e.to();
		validateVertex(v);
		validateVertex(w);
		int index = index_Num(v,w);
		if(index!=-1)
		{
		adj[v].set(index, e);
		}
		else
		{
			adj[v].add(e);
		}
		
		
	}



	
	
	/**
	 * Send A Start Vertex And Return The Place of that Vertex Pointer to a destination 
	 */
	
	private int index_Num(int from,int to) {

		int index=0;
		for (DirectedEdge e : adj(from)) {

			int Dest = e.to();
			if(Dest==to)
			{
				return index;
			}
			index++;
		}


		return -1;
	} 


	

	
	
	/**
	 * Returns the directed edges incident from vertex <tt>v</tt>.
	 *
	 * @param  v the vertex
	 * @return the directed edges incident from vertex <tt>v</tt> as an Iterable
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Iterable<DirectedEdge> adj(int v) {
		validateVertex(v);
		return adj[v];
	}


	/**
	 * Returns all directed edges in this edge-weighted digraph.
	 * To iterate over the edges in this edge-weighted digraph, use foreach notation:
	 * <tt>for (DirectedEdge e : G.edges())</tt>.
	 *
	 * @return all edges in this edge-weighted digraph, as an iterable
	 */
	public Iterable<DirectedEdge> edges() {
		Vector<DirectedEdge> list = new Vector<DirectedEdge>();
		for (int v = 0; v < V; v++) {
			for (DirectedEdge e : adj(v)) {
				list.add(e);
			}
		}
		return list;
	} 

	

	
	/**
	 * Returns a string representation of this edge-weighted digraph.
	 *
	 * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
	 *         followed by the <em>V</em> adjacency lists of edges
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (DirectedEdge e : adj[v]) {
				s.append(e + "  ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}





	/**
	 * Unit tests the <tt>EdgeWeightedDigraph</tt> data type.
	 */
	public static void main(String[] args) {


	}

}