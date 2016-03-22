import static org.junit.Assert.*;


public class Test {

	@org.junit.Test
	//test1
	public void test1(){
		Graph G = new Graph("C:\\testers\\test1\\graph1.txt","C:\\testers\\test1\\black1.txt","C:\\testers\\test1\\Out1.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test1\\cmp1.txt","C:\\testers\\test1\\Out1.txt");
		assertTrue(check);
	}
	@org.junit.Test
	public void test2(){
		Graph G = new Graph("C:\\testers\\test2\\graph2.txt","C:\\testers\\test2\\black2.txt","C:\\testers\\test2\\Out2.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test2\\cmp2.txt","C:\\testers\\test2\\Out2.txt");
		assertTrue(check);
	}

	@org.junit.Test
	public void test3(){
		Graph G = new Graph("C:\\testers\\test3\\graph3.txt","C:\\testers\\test3\\black3.txt","C:\\testers\\test3\\Out3.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test3\\cmp3.txt","C:\\testers\\test3\\Out3.txt");
		assertTrue(check);
	}

	@org.junit.Test
	public void test4(){
		Graph G = new Graph("C:\\testers\\test4\\graph4.txt","C:\\testers\\test4\\black4.txt","C:\\testers\\test4\\Out4.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test4\\cmp4.txt","C:\\testers\\test4\\Out4.txt");
		assertTrue(check);
	}

	@org.junit.Test
	public void test5(){
		Graph G = new Graph("C:\\testers\\test5\\graph5.txt","C:\\testers\\test5\\black5.txt","C:\\testers\\test5\\Out5.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test5\\cmp5.txt","C:\\testers\\test5\\Out5.txt");
		assertTrue(check);
	}

	@org.junit.Test
	public void test6(){
		Graph G = new Graph("C:\\testers\\test6\\graph6.txt","C:\\testers\\test6\\black6.txt","C:\\testers\\test6\\Out6.txt");
		boolean check = Graph.CMP_FILES("C:\\testers\\test6\\cmp6.txt","C:\\testers\\test6\\Out6.txt");
		assertTrue(check);
	}
	
	
	
}

