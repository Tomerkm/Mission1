import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;



public class Graph_algo {

	


	
	
	// A Dynamic programming based function to find the shortest path
    // from u to v with exactly k edges.
	// COMPLEXITY:O(V^3*K)
	
	
	/**

    מחזיר את אורך המסלולים הקצרים ביותר בין כל קודקוד ובתא השלישי הוא שומר את מס' הצעלות


	 */
	private double[][][] shortestPath(double graph[][],int kodkod)
    {
        // Table to be filled up using DP. The value sp[i][j][e] will
        // store weight of the shortest path from i to j with exactly
        // k edges
        double sp[][][] = new double[kodkod][kodkod][kodkod+1];
 
        // Loop for number of edges from 0 to k
        for (int e = 0; e <= kodkod; e++)
        {
            for (int i = 0; i < kodkod; i++)  // for source
            {
                for (int j = 0; j < kodkod; j++) // for destination
                {
                    // initialize value
                    sp[i][j][e] = Graph.INF;
 
                    // from base cases
                    if (e == 0 && i == j)
                        sp[i][j][e] = 0;
                    if (e == 1 && graph[i][j] != Graph.INF)
                        sp[i][j][e] = graph[i][j];
 
                    // go to adjacent only when number of edges is
                    // more than 1
                    if (e > 1)
                    {
                        for (int a = 0; a < kodkod; a++)
                        {
                            // There should be an edge from i to a and
                            // a should not be same as either i or j
                            if (graph[i][a] != Graph.INF && i != a &&
                                    j!= a && sp[a][j][e-1] != Graph.INF)
                                sp[i][j][e] = Math.min(sp[i][j][e],
                                          graph[i][a] + sp[a][j][e-1]);
                        }
                    }
                }
            }
        }
        return sp;
    }
	
	

	/**

    מחזיר את אורך המסלול הקצר ביותר ואת מס' המסלולים בין הקודקודים 


	 */
    public double[] SmallPath(int p1,int p2,double[][] Graphs)
    {
    
    	double arr[] = new double[2];// first place is Smallest Path  and Second is Rib Length 
    	double min_path= Graph.INF;
    	int min_rib=Graphs.length;
    	
    	
    	double[][][] Smallest_Path = shortestPath(Graphs,Graphs.length);
    	
    	
    	for(int k=1;k<Graphs.length;k++)
    	{
    		
    		if(min_path>Smallest_Path[p1][p2][k])
    		{
    	    min_path= Smallest_Path[p1][p2][k];
    		min_rib=k;
    		}

    	}
    	arr[0] = min_path;
    	arr[1] = min_rib;
    	return arr;
    
    }
    
	/**

    פונקצייה שמסמנת את הקודקודים שנשלחו כרשימה שחורה שאי אפשר לעבור דרכם ולא לצאת מהם


	 */
    public double[][] Black_List(int arr[],double[][] Graphs)
    {
    
    	for(int i=0;i<arr.length;i++)
    	{
    		
    		for(int j=0;j<Graphs.length;j++)
    		{
    			
    			Graphs[j][arr[i]]=Graph.INF;
    			Graphs[arr[i]][j]=Graph.INF;
    			
			
    		}
    		Graphs[arr[i]][arr[i]]=0;
    		
    	}
    	
    	return Graphs;
    	
    	
    	
    	
    }
    
    
    
    
    
	public static void main(String[] args) {
		
		
		System.out.println("TK");
		
	}
	
}
