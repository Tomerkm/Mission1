import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;



public class Graph_algo {

	

	public static final double INF = Double.POSITIVE_INFINITY;
	
	
	// A Dynamic programming based function to find the shortest path
    // from u to v with exactly k edges.
	// COMPLEXITY:O(V^3*K)
	private double shortestPath(double graph[][], int u, int v, int k,int kodkod)
    {
        // Table to be filled up using DP. The value sp[i][j][e] will
        // store weight of the shortest path from i to j with exactly
        // k edges
        double sp[][][] = new double[kodkod][kodkod][k+1];
 
        // Loop for number of edges from 0 to k
        for (int e = 0; e <= k; e++)
        {
            for (int i = 0; i < kodkod; i++)  // for source
            {
                for (int j = 0; j < kodkod; j++) // for destination
                {
                    // initialize value
                    sp[i][j][e] = INF;
 
                    // from base cases
                    if (e == 0 && i == j)
                        sp[i][j][e] = 0;
                    if (e == 1 && graph[i][j] != INF)
                        sp[i][j][e] = graph[i][j];
 
                    // go to adjacent only when number of edges is
                    // more than 1
                    if (e > 1)
                    {
                        for (int a = 0; a < kodkod; a++)
                        {
                            // There should be an edge from i to a and
                            // a should not be same as either i or j
                            if (graph[i][a] != INF && i != a &&
                                    j!= a && sp[a][j][e-1] != INF)
                                sp[i][j][e] = Math.min(sp[i][j][e],
                                          graph[i][a] + sp[a][j][e-1]);
                        }
                    }
                }
            }
        }
        return sp[u][v][k];
    }
	
	

  //a&&b
    public double[] SmallPath(int p1,int p2,double[][] Graph)
    {
    
    	double arr[] = new double[2];// first place is Smallest Path  and Second is Length Slahot 
    	double min=INF;
    	int kout=Graph.length;
    	for(int k=1;k<Graph.length;k++)
    	{
    		double Smallest_Path = shortestPath(Graph,p1,p2,k,Graph.length);
    		
    		if(min>Smallest_Path){
 	       min= Smallest_Path;
    		kout=k;
    		}

    	}
    	arr[0] = min;
    	arr[1] = kout;
    	return arr;
    
    }
    
    
    public double[][] BLACK_KODKOD(int arr[],double[][] Graph)
    {
    
    	for(int i=0;i<arr.length;i++)
    	{
    		
    		for(int j=0;j<Graph.length;j++)
    		{
    			
    			
				if(j!=arr[i])
				{
					Graph[j][arr[i]]=INF;
				}
    			
    			for(int q=0;q<Graph.length;q++)
    			{
    			
    				if(q!=arr[i])
    				{
    					Graph[arr[i]][q]=INF;
    				}

    				
    			}
    		}
    		
    	}
    	return Graph;
    	
    	
    	
    	
    }
    
    
    
    
    
	public static void main(String[] args) {
		
		
	}
	
}
