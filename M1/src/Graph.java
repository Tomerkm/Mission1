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
import java.util.Vector;


public class Graph {

	
	
	
	
	public static final double INF = Double.POSITIVE_INFINITY;
	private static final Graph_algo Algo_Graph= new Graph_algo();
	public double[][] mat_graph=null;

	
	/**

    פונקציית עזר לעדכון הקודקודים שאינם מצביעים לאף מקום 


	 */
	private void update_Graph(int length)
	{
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(mat_graph[i][j]==0)
				{
				 mat_graph[i][j] = Double.POSITIVE_INFINITY;
				}
				
			}
			mat_graph[i][i]=0;
		}
	}
	
	
	
	/**

    בנאי שממיר מקובץ לגרף קודקודים 
בנוסף יש קובץ פלט ששומר את הנתונים שבקובץ פלט אך גם שומר את אורך המסלול הקצר ביותר ומס' צלעות


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
			
		
			
			 
			 Writer.write(( Vertex +""));
			 Writer.write("\r\n");
				
			
			
			 Writer.write(Rib +"");
			 Writer.write("\r\n");
			 
				
			mat_graph =  new double[Vertex][Vertex];

			int arr_Left_Vertex[] = new int[Rib];
			int arr_Right_Vertex[] = new int[Rib];
			int index=0;
			int size=0;
			while (size<Rib) {
				
				int i = Reader.nextInt();
				int j = Reader.nextInt();
				
	
				arr_Left_Vertex[index] = i;
				arr_Right_Vertex[index] = j;
				
				
				mat_graph[i][j] = Reader.nextDouble();
				
				
				
				
				System.out.println( i +" , " + j +  " , " + mat_graph[i][j]);
				
				
				index++;
				size++;
			
			}
		
			
			update_Graph(Vertex);
			
			for(int i=0;i<Rib;i++)
			{
				double arr[] =  Algo_Graph.SmallPath(arr_Left_Vertex[i],arr_Right_Vertex[i],mat_graph);
			
				 Writer.write(arr_Left_Vertex[i] +" ");
				 Writer.write(arr_Right_Vertex[i] +" ");
				 Writer.write(arr[0] +" ");// Shortest Race
				 Writer.write(arr[1] +""); // num Rib
			
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

    בנאי שממיר מקובץ לגרף קודקודים 


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
				
			mat_graph =  new double[Vertex][Vertex];

			int arr_Left_Vertex[] = new int[Rib];
			int arr_Right_Vertex[] = new int[Rib];
			int index=0;
			int size=0;
			while (size<Rib) {
				
				int i = Reader.nextInt();
				int j = Reader.nextInt();
				
	
				arr_Left_Vertex[index] = i;
				arr_Right_Vertex[index] = j;
				
				
				mat_graph[i][j] = Reader.nextDouble();

				System.out.println( i +" , " + j +  " , " + mat_graph[i][j]);
				
				
				index++;
				size++;
			
			}
		
			
			update_Graph(Vertex);
			
			
			
			
			fis.close();
			Reader.close();
		
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		
			
			
		
	}
	
	
	/**

    בנאי שממיר מקובץ לגרף קודקודים 
ושולף נתונים מקובץ שאילתא ושומר לקובץ קלט תמסלול הקצר ביותר בלי לעבור ברשימה השחורה

	 */
	public Graph(String Input,String Query,String Output)
	{
		mat_graph = new Graph(Input).mat_graph;
	
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
		     if(count_Black_Code!=0)
		     {
		    	 int arr[] = new int[count_Black_Code];
		    	 
		    	 for(int k=0;k<arr.length;k++)
		    	 {
		    	 
		    		 arr[k] = Reader.nextInt();
		    		 Writer.write(arr[k] +" ");
		    		 
		    	 }
		    	 Graph_Cover = Algo_Graph.Black_List(arr, mat_graph);
		     }
		     
		     double Smallest_Race = Algo_Graph.SmallPath(left_vertex,right_vertex,Graph_Cover)[0];
		     if(Smallest_Race!=Double.POSITIVE_INFINITY)
		     {
		     Writer.write(Smallest_Race +"");
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

    פונקצייה שמשווה בין קבצים


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
		
	
	new Graph("C:\\Res\\tinyEWG.txt","C:\\Res\\Out.txt");	

		
	}

}
