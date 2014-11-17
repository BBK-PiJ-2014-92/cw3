import org.junit.*;
import static org.junit.Assert.*;

public class ListTest{
	private List testBoth;

	public ListTest() {
		testBoth = new ArrayList();
	}
	
	
	@After
	public void cleanUp() {
		testBoth = null;
	}

	@Test
	public void addTest1() {
		testBoth.add(1);
		Object actual = testBoth.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		testBoth.add(null);
		actual = testBoth.get(1).getReturnValue();
		expected = null;
		assertEquals(actual, expected); //works
		
		testBoth.add(2);
		actual = testBoth.get(1).getReturnValue();
		expected = 2;
		assertEquals(actual, expected); //works
		
		testBoth.add("test");
		actual = testBoth.get(2).getReturnValue();
		expected = "test";
		assertEquals(actual, expected); //works

	}
	
	@Test
	public void addTest2() {
		testBoth.add(0, 1);
		Object actual = testBoth.get(0).getReturnValue();
		assertNull(actual); //works
		
		testBoth.add(0);
		testBoth.add(0, "head");
		actual = testBoth.get(0).getReturnValue();
		Object expected = "head";
		assertEquals(actual, expected); //works
		
		actual = testBoth.get(1).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		testBoth.add(1, null);
		actual = testBoth.get(1).getReturnValue();
		assertNotNull(actual); //works
		
		testBoth.add(5, "OutOfBounds");
		actual = testBoth.get(5).getReturnValue();
		assertNull(actual); //works
		
		testBoth.add(1, "second");
		actual = testBoth.get(2).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		testBoth.add(4); //stored in 3
		testBoth.add(5); //stored in 4
		testBoth.add(6); //stored in 5
		testBoth.add(7); //stored in 6
		testBoth.add(8); //stored in 7
		testBoth.add(9); //stored in 8
		testBoth.add(10); //store in 9
		
		testBoth.add("Is this full yet?");
		actual = testBoth.get(10).getReturnValue();
		expected = "Is this full yet?";
		assertEquals(actual, expected); //works
		
		testBoth.add(10, "How about now?");
		actual = testBoth.get(11).getReturnValue();
		assertEquals(actual, expected); //works
		
		actual = testBoth.add("give me null or give me death").getReturnValue();
		assertNull(actual); //works
		
		actual = testBoth.add(10, "another null test").getReturnValue();
		assertNull(actual); //works
	}
	@Test
	public void emptyTest() {
		boolean actual = testBoth.isEmpty();
		assertTrue(actual); //works
		
		testBoth.add("Not empty");
		actual = testBoth.isEmpty();
		assertFalse(actual); //works
		
		testBoth.remove(0);
		actual = testBoth.isEmpty();
		assertTrue(actual); //works
		
		//actual = linkedTest.isEmpty();
		//assertTrue(actual);
	}

	@Test
	public void sizeTest() {
		int actual = testBoth.size();
		int expected = 0;
		assertEquals(actual, expected); //works
		
		testBoth.add("size 1");
		actual = testBoth.size();
		expected = 1;
		assertEquals(actual, expected); //works
		
		testBoth.remove(0);
		actual = testBoth.size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		testBoth.remove(0);
		actual = testBoth.size();
		assertEquals(actual, expected); //works
		
		//actual = linkedTest.size();
		//assertEquals(actual, expected);
	}
	
	@Test
	public void removeTest() {
		testBoth.add(0);
		testBoth.add(1);
		testBoth.add(2);
		testBoth.add(3);
		testBoth.remove(3);
		Object actual = testBoth.get(3).getReturnValue();
		assertNull(actual); //works
		
		testBoth.remove(0);
		actual = testBoth.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		actual = testBoth.remove(2).getReturnValue();
		assertNull(actual); //works
		
		
		
	}

}