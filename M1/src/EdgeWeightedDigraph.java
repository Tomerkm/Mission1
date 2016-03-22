import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class EdgeWeightedDigraph{


	private final int V;                // number of vertices in this digraph
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

		adj = (Vector<DirectedEdge>[]) new Vector[V];
		for (int v = 0; v < V; v++)
		{
			adj[v] = new Vector<DirectedEdge>();
		
		}
		
	}

    public EdgeWeightedDigraph(Scanner Reader) {
    	
        this(Reader.nextInt());
        int E = Reader.nextInt();

        for (int i = 0; i < E; i++) {
            int v = Reader.nextInt();
            int w = Reader.nextInt();
            if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
            if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
            double weight = Reader.nextDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
        Reader.close();
    }



	/**
	 * Returns the number of vertices in this edge-weighted digraph.
	 *
	 * @return the number of vertices in this edge-weighted digraph
	 */
	public int V() {
		return V;
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
			if(adj(v)!=null)
			for (DirectedEdge e : adj(v)) {
				list.add(e);
			}
		}
		return list;
	} 

	
	/**


    The Function Create Black List in The Graph of vertex that we send - Delete Them.
    we cannot pass in the black ways.

	 */
	
	public void Black_List(int arr[],Stack<DirectedEdge> Stk) {

		for(int i=0;i<arr.length;i++)
		{
			validateVertex(arr[i]);

			
			
			for (DirectedEdge e : adj(arr[i])) {
				
				Stk.push(e);
			}
			
			adj[arr[i]]=null;

			
			for (int v = 0; v < V; v++) {
				
				int index =0;
				if(adj(v)!=null)
				for (DirectedEdge e : adj(v)) {
				
					
					int Dest = e.to();
					int Source = e.from();
					if(Dest==arr[i])
					{
						Stk.push(e);
						adj[Source].remove(index);
					    break;
					}
					index++;
					
				}
			}
		}

	} 

	
	
	/**


    The Function Return All The Vertexes who They was in the black list and Get Back There Real Value (Weight)

	 */
	public void Reset(Stack<DirectedEdge> Stk)
	{
		while(!Stk.isEmpty())
		{
			DirectedEdge e= Stk.pop();
			
			int Source = e.from();
			if(adj[Source]==null)
			{
				adj[Source] = new Vector<DirectedEdge>();
			}
			
			adj[Source].add(e);
			
		}
		
	}

	





	/**
	 * Unit tests the <tt>EdgeWeightedDigraph</tt> data type.
	 */
	public static void main(String[] args) {


	}

}