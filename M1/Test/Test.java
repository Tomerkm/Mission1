import static org.junit.Assert.*;


public class Test {

	@org.junit.Test
	public void test(){
		
		
		Graph G = new Graph();
		
		G.Create_Graph("C:\\Res\\tinyEWG.txt","C:\\Res\\Out.txt");
		
		boolean check = Graph.CMP_FILES("C:\\Res\\CMP.txt","C:\\Res\\Out.txt");
		
		assertTrue(check);
		
		
		
	}

}
