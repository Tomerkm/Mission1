import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class Graph {

	
	
	
	
	public static final double INF = Double.POSITIVE_INFINITY;
	private static Graph_algo Algo_Graph;
	private boolean[][] mat_graph=null;
	private EdgeWeightedDigraph Graph=null;
	
	/**

   The Rest of Vertexes will be INFINITY Weight
  
	 */
	private void update_Graph(int length, EdgeWeightedDigraph Graph)
	{
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
	
				if(!mat_graph[i][j] && i!=j)
				{
				 Graph.addEdge(new DirectedEdge(i,j,Double.POSITIVE_INFINITY));
				 
				}
				
				
			}
			Graph.addEdge(new DirectedEdge(i,i,0));
			mat_graph[i][i]=false;
		}
	}
	
	
	
	/**


      Read the InputFile and create Matrix And Graph. 
      Save The Result of The Shortest Weight and Count Rib of every way Between A and B
      in The Output File.

	 */
	public Graph(String Input,String Output) 
	{
	
			Scanner Reader=null;
			FileWriter fileWriter=null;
			try
			{
				
		
			File file = new File(Output);
			FileWriter Writer = new FileWriter(file,false);
			

				
			 FileInputStream fis = new FileInputStream(Input);
			 Reader = new Scanner(fis);
			 
			 int Vertex=Reader.nextInt();
			 int Rib=Reader.nextInt();
			
		
			  Graph = new EdgeWeightedDigraph(Vertex,Rib);
			
			 
			 Writer.write(( Vertex +""));
			 Writer.write("\r\n");
				
			
			
			 Writer.write(Rib +"");
			 Writer.write("\r\n");
			 
				
			mat_graph = new boolean[Vertex][Vertex];

			int arr_Left_Vertex[] = new int[Rib];
			int arr_Right_Vertex[] = new int[Rib];
			int index=0;
			int size=0;
			
			
		
			
			
			while (size<Rib) {
				
				int i = Reader.nextInt();
				int j = Reader.nextInt();
				
				arr_Left_Vertex[index] = i;
				arr_Right_Vertex[index] = j;

				
				Graph.addEdge(new DirectedEdge(i,j,Reader.nextDouble()));
				mat_graph[i][j]=true;
			
				
				index++;
				size++;
			
			}
		
			
			update_Graph(Vertex,Graph);
			Algo_Graph = new Graph_algo(Graph,Vertex);
			for(int i=0;i<Rib;i++)
			{
			
				System.out.println(arr_Left_Vertex[i] + " - > " + arr_Right_Vertex[i]);
				
				double Weight =  Algo_Graph.Shortest_Path_Weigth(Graph, arr_Left_Vertex[i], arr_Right_Vertex[i]);
			    int count_Rip =  Algo_Graph.Shortest_Path_Count_Rip(Graph, arr_Left_Vertex[i], arr_Right_Vertex[i]);
				
			    
				
				 Writer.write(arr_Left_Vertex[i] +" ");
				 Writer.write(arr_Right_Vertex[i] +" ");
				
				 if(Weight!=Double.POSITIVE_INFINITY)
				 {
				 Writer.write(Weight +" ");// Shortest Race
				 Writer.write(count_Rip +""); // num Rib
				 }
				 else
				 {
					 Writer.write("inf"); 
				 }
				 if(i+1!=Rib)
				 Writer.write("\r\n");
				
				
			}
			
		
			
			fis.close();
			Reader.close();
			Writer.close();
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
			
			
			
		
	}
	
	/**

      Read the Inputfile and Create Matrix And Graph.
       

	 */
	public Graph(String Input) 
	{


		
		    Scanner Reader=null;
			try
			{
				
				
			 FileInputStream fis = new FileInputStream(Input);
			 Reader = new Scanner(fis);
			 
			 int Vertex=Reader.nextInt();
			 int Rib=Reader.nextInt();
				
			mat_graph =  new boolean[Vertex][Vertex];

			 Graph = new EdgeWeightedDigraph(Vertex,Rib);
			
			int arr_Left_Vertex[] = new int[Rib];
			int arr_Right_Vertex[] = new int[Rib];
			int index=0;
			int size=0;
			while (size<Rib) {
				
				int i = Reader.nextInt();
				int j = Reader.nextInt();
				
	
				arr_Left_Vertex[index] = i;
				arr_Right_Vertex[index] = j;
				
				mat_graph[i][j]=true;
			
				double weighter = Reader.nextDouble();

				Graph.addEdge(new DirectedEdge(i,j,weighter));
				
				
				
				
				index++;
				size++;
			
			}
		
			
            update_Graph(Vertex,Graph);
			
			fis.close();
			Reader.close();
		
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		
			
			
		
	}
	
	
	/**


     Read the InputFile and create Matrix Boolean, Graph and Query.     
      we saving The Result of Shortest Path in the OutPut file  
      
      **and of course the ways dont Pass in the Black Vertex


	 */
	public Graph(String Input,String Query,String Output)
	{
		Graph Inputer = new Graph(Input);
	
		
		
		this.Graph = Inputer.Graph;
		
		
		Scanner Reader=null;
		FileWriter fileWriter=null;
		try
		{
			
	
		File file = new File(Output);
		FileWriter Writer = new FileWriter(file,false);
		

			
		 FileInputStream fis = new FileInputStream(Query);
		 Reader = new Scanner(fis);
		 
		 
		 int num_of_query = Reader.nextInt();
		 
		 Writer.write(num_of_query +"");
		 Writer.write("\r\n");
		 
		 int i=0;
		 double[][] Graph_Cover=null;
		 while(i<num_of_query)
		 {
			 int left_vertex = Reader.nextInt(); 
			 int right_vertex = Reader.nextInt(); 
		     Writer.write(left_vertex +" ");	
		     Writer.write(right_vertex +" ");	
		     
		     int count_Black_Code = Reader.nextInt();
		     Writer.write(count_Black_Code +" ");
		     
		
		     EdgeWeightedDigraph Cover = new EdgeWeightedDigraph(Graph);
		     
		     
		     if(count_Black_Code!=0)
		     {
		    	 int arr[] = new int[count_Black_Code];
		    	 
		    	 for(int k=0;k<arr.length;k++)
		    	 {
		    	 
		    		 arr[k] = Reader.nextInt();
		    		 Writer.write(arr[k] +" ");
		    		 
		    	 }
		    	   Black_List(arr,Cover.V(), Cover);
		     }
		 
		     Algo_Graph = new Graph_algo(Cover,Inputer.mat_graph.length);
		     
		     double Weight =  Algo_Graph.Shortest_Path_Weigth(Cover, left_vertex,right_vertex);

		     if(Weight!=Double.POSITIVE_INFINITY)
		     {
		     Writer.write(Weight +"");
		     }
		     else
		     {
		    	 Writer.write("inf"); 
		     }
		     if(i+1!=num_of_query)
		     {
			 Writer.write("\r\n");
		     }
		     
		    
		 
		     
			 i++;
		 }
		 
		 fis.close();
		 Reader.close();
		 Writer.close();
		
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	
	
	

	/**


     The Function Create Black List in The Array of vertex that we send.
     we cannot pass in the black ways.

	 */
    private void Black_List(int arr[],int size,EdgeWeightedDigraph Graph)
    {
    
    	for(int i=0;i<arr.length;i++)
    	{
    		
    	
    		for(int j=0;j<size;j++)
    		{
    			
    			if(j!=arr[i])
    			{
    				Graph.Update(new DirectedEdge(arr[i],j,Double.POSITIVE_INFINITY));
    				Graph.Update(new DirectedEdge(j,arr[i],Double.POSITIVE_INFINITY));
    			
    			}
    			
    		}
    		
    		
    		
    	}
    	
    
    	
    	
    	
    }
    

	/**
     Compare between 2 Files and return true and false. 
     this function helping us with the testers.
	 */
	public static boolean CMP_FILES(String OutPut,String Comp) 
	{
		
		try
		{
		FileReader fr_Output = new FileReader(OutPut);
		BufferedReader br_Output = new BufferedReader(fr_Output);
		
		FileReader fr_Comp = new FileReader(Comp);
		BufferedReader br_Comp = new BufferedReader(fr_Comp);
		
		 
		 
		 String Outputer = br_Output.readLine();
		 String Comper = br_Comp.readLine();
		 
		 while(Outputer!=null && Comper!=null)
		 {
			 if(Outputer.compareTo(Comper)!=0)
			 {
				 fr_Output.close();
				 br_Output.close();
				 fr_Comp.close();
				 br_Comp.close();
				 return false;
			 }
			 Outputer = br_Output.readLine();
			  Comper = br_Comp.readLine();
		 }
		 fr_Output.close();
		 br_Output.close();
		 fr_Comp.close();
		 br_Comp.close();
		 if(Outputer==null && Comper==null)
		 {
			 return true;
		 }
	
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		return false;
		 
		 
	}
  
	
	public static void main(String[] args)  {
		
		


		
	 //new Graph("C:\\Res\\mediumEWD.txt","C:\\Res\\Out.txt");	

		new Graph("C:\\Res\\mediumEWD.txt","C:\\Res\\test1.txt","C:\\Res\\Out.txt");
		
	}

}
