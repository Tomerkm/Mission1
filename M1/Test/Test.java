import static org.junit.Assert.*;


public class Test {

	@org.junit.Test
	//test1
	public void test(){
	
		Graph G = new Graph("C:\\Res\\mediumEWD.txt","C:\\Res\\test3.txt","C:\\Res\\Out.txt");
		
	
		
		boolean check = Graph.CMP_FILES("C:\\Res\\Solution_test3.txt_mediumEWD.txt_1458310286550_.txt","C:\\Res\\Out.txt");
		
		assertTrue(check);
	}

}
