import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;



public class Graph_algo {

	


	private DijkstraSP Graph_Shortest_Path[]=null;
	
	
	/**

	   Create Array.size of array=num of the vertexes.  
	  the array save the shortest path between two vertexes.
	  ans save the num of ribs that he passed in this path.
		 */
	public Graph_algo(EdgeWeightedDigraph Graph,int vertex)
	{
		Graph_Shortest_Path = new DijkstraSP[vertex];
		
		for(int i=0;i<vertex;i++)
		{
			Graph_Shortest_Path[i] = new DijkstraSP(Graph,i);
		}
		
	}
	
	

	//return the number of ribs that he passed in this way.
	  public int Shortest_Path_Count_Rip(EdgeWeightedDigraph Graph,int from,int to)
	  {
		 Stack<DirectedEdge> SP = (Stack)(Graph_Shortest_Path[from].pathTo(to));
		 if(SP==null)
		 {
			 return 0;
		 }
		 return SP.size();
	  }
	  
	  //return the cheapest way from vertex A to vertex B.
	  
	  public double Shortest_Path_Weigth(EdgeWeightedDigraph Graph,int from,int to)
	  {
		 return Graph_Shortest_Path[from].distTo(to);
	  }
	  


    
    
	public static void main(String[] args) {
		
		
          
		
	}
	
}
