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

	
	
	
	
	private static Graph_algo Algo_Graph;

	private EdgeWeightedDigraph Graph=null;
	
	

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

		    	Graph = new EdgeWeightedDigraph(Reader);

		    	fis.close();
		    	Reader.close();
		
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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

			Graph = new Graph(Input).Graph;
			
			try
			{
				
		
			File file = new File(Output);
			FileWriter Writer = new FileWriter(file,false);
			

				
			 FileInputStream fis = new FileInputStream(Input);
			 Reader = new Scanner(fis);
			 
			 int Vertex=Reader.nextInt();
			 int Rib=Reader.nextInt();
			
		
			 
			 Writer.write(( Vertex +""));
			 Writer.write("\r\n");
				
			
			
			 Writer.write(Rib +"");
			 Writer.write("\r\n");
			 
				
			int size=0;
			
			Algo_Graph = new Graph_algo(Graph.V());
			
			while (size<Rib) {
				
				int i = Reader.nextInt();
				int j = Reader.nextInt();
				
			
				double Weight =  Algo_Graph.Shortest_Path_Weigth(Graph,i,j);
			    int count_Rip =  Algo_Graph.Shortest_Path_Count_Rip(Graph,i,j);
				
			    
				
				 Writer.write(i +" ");
				 Writer.write(j +" ");
				
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
				 
				 Weight = Reader.nextDouble();
			
				 
			
				size++;
			
				
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


     Read the InputFile and create Matrix Boolean, Graph and Query.     
      we saving The Result of Shortest Path in the OutPut file  
      
      **and of course the ways dont Pass in the Black Vertex


	 */
	public Graph(String Input,String Query,String Output)
	{
		
		
		Graph Inputer = new Graph(Input);
	
		this.Graph = Inputer.Graph;
		
		
		Scanner Reader=null;

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
	
		  Algo_Graph = new Graph_algo(Graph.V());
		 
		 while(i<num_of_query)
		 {
			 int left_vertex = Reader.nextInt(); 
			 int right_vertex = Reader.nextInt(); 
		     Writer.write(left_vertex +" ");	
		     Writer.write(right_vertex +" ");	
		     
		     int count_Black_Code = Reader.nextInt();
		     Writer.write(count_Black_Code +" ");
		     
		
		     
		     
		     Stack<DirectedEdge> Stk = new Stack<DirectedEdge>(); 
		     if(count_Black_Code!=0)
		     {
		    	 int arr[] = new int[count_Black_Code];
		    	 
		    	 for(int k=0;k<arr.length;k++)
		    	 {
		    	 
		    		 arr[k] = Reader.nextInt();
		    		 Writer.write(arr[k] +" ");
		    		 
		    	 }
		    	 Graph.Black_List(arr,Stk);
		     }
		 
		    
		   
		     
		     double Weight =  Algo_Graph.Shortest_Path_Weigth(Graph, left_vertex,right_vertex);

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
		     
		     Graph.Reset(Stk);
		 
		     
		     
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
		
		
		
	if(args.length!=0)
	{
		if(args.length==1)
		{
			new Graph(args[0],"Out.txt");	
		}
		else
		{
			new Graph(args[0],args[1],"Out.txt");	
		}
		
	}
	else
	{	
	new Graph("C:\\Res\\mediumEWD.txt","C:\\Res\\test3.txt","Out.txt");	
	}
	

		
	}

}
