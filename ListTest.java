import org.junit.*;
import static org.junit.Assert.*;

public class ListTest{
	private List arrayTest;
	//private List linkedTest;

	public ListTest() {
		arrayTest = new ArrayList();
		//linkedTest = new LinkedList(); 
	}
	
	//@Before
	//public void buildUp() {
		
		//linkedTest.add("1");
		//linkedTest.add("2");
		//linkedTest.add("3");
		//linkedTest.add("4");
		//linkedTest.add("5");
	//}
	
	@After
	public void cleanUp() {
		arrayTest = null;
		//linkedTest = null;
	}

	@Test
	public void addTest1() {
		arrayTest.add(1);
		Object actual = arrayTest.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		arrayTest.add(null);
		actual = arrayTest.get(1).getReturnValue();
		expected = null;
		assertEquals(actual, expected); //works
		
		arrayTest.add(2);
		actual = arrayTest.get(1).getReturnValue();
		expected = 2;
		assertEquals(actual, expected); //works
		
		arrayTest.add("test");
		actual = arrayTest.get(2).getReturnValue();
		expected = "test";
		assertEquals(actual, expected); //works
	}
	
	@Test
	public void addTest2() {
		arrayTest.add(0, 1);
		Object actual = arrayTest.get(0).getReturnValue();
		assertNull(actual); //works
		
		arrayTest.add(0);
		arrayTest.add(0, "head");
		actual = arrayTest.get(0).getReturnValue();
		Object expected = "head";
		assertEquals(actual, expected); //works
		
		actual = arrayTest.get(1).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		arrayTest.add(1, null);
		actual = arrayTest.get(1).getReturnValue();
		assertNotNull(actual); //works
		
		arrayTest.add(5, "OutOfBounds");
		actual = arrayTest.get(5).getReturnValue();
		assertNull(actual); //works
		
		arrayTest.add(1, "second");
		actual = arrayTest.get(2).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		arrayTest.add(4); //stored in 3
		arrayTest.add(5); //stored in 4
		arrayTest.add(6); //stored in 5
		arrayTest.add(7); //stored in 6
		arrayTest.add(8); //stored in 7
		arrayTest.add(9); //stored in 8
		arrayTest.add(10); //store in 9
		
		arrayTest.add("Is this full yet?");
		actual = arrayTest.get(10).getReturnValue();
		expected = "Is this full yet?";
		assertEquals(actual, expected); //works
		
		arrayTest.add(10, "How about now?");
		actual = arrayTest.get(11).getReturnValue();
		assertEquals(actual, expected); //works
		
		actual = arrayTest.add("give me null or give me death").getReturnValue();
		assertNull(actual); //works
		
		actual = arrayTest.add(10, "another null test").getReturnValue();
		assertNull(actual); //works
	}
	@Test
	public void emptyTest() {
		boolean actual = arrayTest.isEmpty();
		assertTrue(actual); //works
		
		arrayTest.add("Not empty");
		actual = arrayTest.isEmpty();
		assertFalse(actual); //works
		
		arrayTest.remove(0);
		actual = arrayTest.isEmpty();
		assertTrue(actual); //works
		
		//actual = linkedTest.isEmpty();
		//assertTrue(actual);
	}

	@Test
	public void sizeTest() {
		int actual = arrayTest.size();
		int expected = 0;
		assertEquals(actual, expected); //works
		
		arrayTest.add("size 1");
		actual = arrayTest.size();
		expected = 1;
		assertEquals(actual, expected); //works
		
		arrayTest.remove(0);
		actual = arrayTest.size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		arrayTest.remove(0);
		actual = arrayTest.size();
		assertEquals(actual, expected); //works
		
		//actual = linkedTest.size();
		//assertEquals(actual, expected);
	}
	
	@Test
	public void removeTest() {
		arrayTest.add(0);
		arrayTest.add(1);
		arrayTest.add(2);
		arrayTest.add(3);
		arrayTest.remove(3);
		Object actual = arrayTest.get(3).getReturnValue();
		assertNull(actual); //works
		
		arrayTest.remove(0);
		actual = arrayTest.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		actual = arrayTest.remove(2).getReturnValue();
		assertNull(actual); //works
		
		
		
	}

}