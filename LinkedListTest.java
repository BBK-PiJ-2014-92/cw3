import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListTest{
	private List linked;

	public LinkedListTest() {
		linked = new LinkedList();
	}
	
	@After
	public void cleanUp() {
		linked = null;
	}

	@Test
	public void addTest1() {
		Object actual = linked.add(1).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		linked.add(null);
		actual = linked.get(1).getReturnValue();
		expected = null;
		assertEquals(actual, expected); //works
		
		linked.add(2);
		actual = linked.get(1).getReturnValue();
		expected = 2;
		assertEquals(actual, expected); //works
		
		linked.add("test");
		actual = linked.get(2).getReturnValue();
		expected = "test";
		assertEquals(actual, expected); //works
		
		linked.add(10, "out of bounds");
		actual = linked.get(10).getReturnValue();
		assertNull(actual); //works

	}
	
	@Test
	public void addTest2() {
		linked.add(0);
		linked.add(0, "head");
		Object actual = linked.get(0).getReturnValue();
		Object expected = "head";
		assertEquals(actual, expected); //works
		
		actual = linked.get(1).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		linked.add(1, null);
		actual = linked.get(1).getReturnValue();
		assertNotNull(actual); //works
		
		linked.add(5, "OutOfBounds");
		actual = linked.get(5).getReturnValue();
		assertNull(actual); //works
		
		linked.add(1, "second");
		actual = linked.get(2).getReturnValue();
		expected = 0;
		assertEquals(actual, expected); //works
		
		linked.add(4); //stored in 3
		linked.add(5); //stored in 4
		linked.add(6); //stored in 5
		linked.add(7); //stored in 6
		linked.add(8); //stored in 7
		linked.add(9); //stored in 8
		linked.add(10); //store in 9
		
		linked.add("Is this full yet?");
		actual = linked.get(10).getReturnValue();
		expected = "Is this full yet?";
		assertEquals(actual, expected); //works
		
		linked.add(10, "How about now?");
		actual = linked.get(11).getReturnValue();
		assertEquals(actual, expected); //works
		
		actual = linked.add("give me null or give me death").getReturnValue();
		assertNull(actual); //works
		
		actual = linked.add(10, "another null test").getReturnValue();
		assertNull(actual); //works
	}
	
	@Test
	public void addTest3() {
		linked.add(0, 1);
		Object actual = linked.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
	}
	@Test
	public void emptyTest() {
		boolean actual = linked.isEmpty();
		assertTrue(actual); //works
		
		linked.add("Not empty");
		actual = linked.isEmpty();
		assertFalse(actual); //works
		
		linked.remove(0);
		actual = linked.isEmpty();
		assertTrue(actual); //works

	}

	@Test
	public void sizeTest() {
		int actual = linked.size();
		int expected = 0;
		assertEquals(actual, expected); //works
		
		linked.add("size 1");
		actual = linked.size();
		expected = 1;
		assertEquals(actual, expected); //works
		
		linked.remove(0);
		actual = linked.size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		linked.remove(0);
		actual = linked.size();
		assertEquals(actual, expected); //works
		
	}
	
	@Test
	public void removeTest() {
		linked.add(0);
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.remove(3);
		Object actual = linked.get(3).getReturnValue();
		assertNull(actual); //works
		
		linked.remove(0);
		actual = linked.get(0).getReturnValue();
		Object expected = 1;
		assertEquals(actual, expected); //works
		
		actual = linked.remove(2).getReturnValue();
		assertNull(actual); //works
		
		
		actual = linked.remove(-1).getError();
		expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(actual, expected); //works
		
	}
	
	@Test
	public void removeTest2() {
		linked.remove(0);
		boolean actual = linked.isEmpty();
		assertTrue(actual); //works
		
		linked.add(0);
		
		Object error = linked.remove(10).getError();
		Object expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(error, expected); //works
	}

}