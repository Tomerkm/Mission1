import static org.junit.Assert.*;


public class Test {

	@org.junit.Test
	//test1
	public void test(){
	
		Graph G = new Graph("C:\\Res\\tinyEWG.txt","C:\\Res\\Out.txt");
		
	
		
		boolean check = Graph.CMP_FILES("C:\\Res\\Out.txt","C:\\Res\\Out.txt");
		
		assertTrue(check);
	}

}
