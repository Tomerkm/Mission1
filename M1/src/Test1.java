import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Test1 {

	
	public Test1(String Input,String Query,String Output)
	{
		double Graphs[][] = Graph.Create_Graph(Input);
	
		Scanner scf=null;
		FileWriter fileWriter=null;
		try
		{
			
	
		File file = new File(Output);
		FileWriter Writer = new FileWriter(file,false);
		

			
		 FileInputStream fis = new FileInputStream(Query);
		 scf = new Scanner(fis);
		 
		 
		 int num_of_query = scf.nextInt();
		 
		 Writer.write(num_of_query +"");
		 Writer.write("\r\n");
		 
		 int i=0;
		 while(i<num_of_query)
		 {
			 int left_kokod = scf.nextInt(); 
			 int right_kokod = scf.nextInt(); 
		     Writer.write(left_kokod +" ");	
		     Writer.write(right_kokod +" ");	
		     
		     int count_Black_Code = scf.nextInt();
		     Writer.write(count_Black_Code +" ");
		     if(count_Black_Code!=0)
		     {
		    	 int arr[] = new int[count_Black_Code];
		    	 
		    	 for(int k=0;k<arr.length;k++)
		    	 {
		    	 
		    		 arr[k] = scf.nextInt();
		    		 Writer.write(arr[k] +" ");
		    		 
		    	 }
		    	 Graphs = Graph_algo.BLACK_KODKOD(arr, Graphs);
		     }
		     
		     double Smallest_Race = Graph_algo.SmallPath(left_kokod,right_kokod,Graphs)[0];
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
		 scf.close();
		 Writer.close();
		
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		try
		{
		new Test1("C:\\Res\\tinyEWG.txt","C:\\Res\\test1.txt","C:\\Res\\Out.txt");
			
		
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}

}
