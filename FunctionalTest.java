import org.junit.*;
import static org.junit.Assert.*;

public class FunctionalTest {
	private FunctionalList linked;
	private FunctionalList array;
	
	public FunctionalTest() {
		linked = new FunctionalLinkedList();
		array = new FunctionalArrayList();
	}
	
	@Before
	public void buildUp() {
		linked.add(0);
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.add(4);
		
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
	}
	
	@After
	public void cleanUo() {
		linked = null;
		array = null;
	}
	
	@Test
	public void testHead() {
		Object actual = linked.head().getReturnValue();
		Object expected = 0;
		assertEquals(actual, expected); //works
		
		actual = array.head().getReturnValue();
		assertEquals(actual, expected); //works
	}
	
	@Test
	public void testRest() {
		Object actual = array.rest().size();
		Object expected = 4;
		assertEquals(actual, expected); //works
		
		actual = linked.rest().size();
		assertEquals(actual, expected); //works
		
		array.remove(0);
		array.remove(0);
		array.remove(0);
		array.remove(0);
		array.remove(0);
		
		actual = array.rest().size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		linked.remove(0);
		linked.remove(0);
		linked.remove(0);
		linked.remove(0);
		linked.remove(0);
		
		actual = linked.rest().size();
		assertEquals(actual, expected); //works
	}
}