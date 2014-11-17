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
		assertEquals(actual, expected);
	}
}