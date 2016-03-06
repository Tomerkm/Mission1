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

	
	
	
	
	static final double INF = Double.POSITIVE_INFINITY;
	
	
	public static double[][] Create_Graph(String Input,String Output) 
	{

		

		    double mat[][]=null;
	
			Scanner scf=null;
			FileWriter fileWriter=null;
			try
			{
				
		
			File file = new File(Output);
			FileWriter Writer = new FileWriter(file,false);
			

				
			 FileInputStream fis = new FileInputStream(Input);
			 scf = new Scanner(fis);
			 
			 int kodkod=scf.nextInt();
			 int Slahot=scf.nextInt();
			
		
			
			 
			 Writer.write(( kodkod +""));
			 Writer.write("\r\n");
				
			
			
			 Writer.write(Slahot +"");
			 Writer.write("\r\n");
			 
				
			mat =  new double[kodkod][kodkod];

			int arr_Left_Kod[] = new int[Slahot];
			int arr_Right_Kod[] = new int[Slahot];
			int index=0;
			int size=0;
			while (size<Slahot) {
				
				int i = scf.nextInt();
				int j = scf.nextInt();
				
	
				arr_Left_Kod[index] = i;
				arr_Right_Kod[index] = j;
				
				
				mat[i][j] = scf.nextDouble();
				
				
				
				
				System.out.println( i +" , " + j +  " , " + mat[i][j]);
				
				
				index++;
				size++;
			
			}
		
			
			for(int i=0;i<kodkod;i++)
			{
				for(int j=0;j<kodkod;j++)
				{
					if(mat[i][j]==0 && i!=j)
					{
						mat[i][j] = Double.POSITIVE_INFINITY;
					}
					
				}
			}
			
			
			for(int i=0;i<Slahot;i++)
			{
				double arr[] =  Graph_algo.SmallPath(arr_Left_Kod[i],arr_Right_Kod[i],mat);
			
				 Writer.write(arr_Left_Kod[i] +" ");
				 Writer.write(arr_Right_Kod[i] +" ");
				 Writer.write(arr[0] +" ");// Shortest Race
				 Writer.write(arr[1] +""); // num slahot
			
				 if(i+1!=Slahot)
				 Writer.write("\r\n");
				
			}
			
			
			fis.close();
			scf.close();
			Writer.close();
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
			return mat;
			
			
		
	}
	
	public static double[][] Create_Graph(String Input) 
	{


		    double mat[][]=null;
		    Scanner scf=null;
			try
			{
				
				
			 FileInputStream fis = new FileInputStream(Input);
			 scf = new Scanner(fis);
			 
			 int kodkod=scf.nextInt();
			 int Slahot=scf.nextInt();
				
			mat =  new double[kodkod][kodkod];

			int arr_Left_Kod[] = new int[Slahot];
			int arr_Right_Kod[] = new int[Slahot];
			int index=0;
			int size=0;
			while (size<Slahot) {
				
				int i = scf.nextInt();
				int j = scf.nextInt();
				
	
				arr_Left_Kod[index] = i;
				arr_Right_Kod[index] = j;
				
				
				mat[i][j] = scf.nextDouble();

				System.out.println( i +" , " + j +  " , " + mat[i][j]);
				
				
				index++;
				size++;
			
			}
		
			
			for(int i=0;i<kodkod;i++)
			{
				for(int j=0;j<kodkod;j++)
				{
					if(mat[i][j]==0 && i!=j)
					{
						mat[i][j] = Double.POSITIVE_INFINITY;
					}
					
				}
			}
			
			
			
			
			fis.close();
			scf.close();
		
			
			
			}
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
			return mat;
			
			
		
	}
	

	public static boolean CMP_FILES(String OutPut,String Comp) throws Exception
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
		 return false;
		 
		 
		 
	}
    
    
	public static void main(String[] args)  {
		
		Create_Graph("C:\\Res\\tinyEWG.txt","C:\\Res\\Out.txt");

		
	}

}
