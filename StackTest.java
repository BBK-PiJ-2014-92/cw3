import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
	private Stack stackA;
	private Stack stackL;
	private ImprovedStack improvedStack;
	private List array;
	private List linked;
	
	public StackTest() {
		array = new FunctionalArrayList();
		linked = new FunctionalLinkedList();
		stackA = new StackImpl(array);
		stackL = new StackImpl(linked);
		improvedStack = new ImprovedStackImpl();
	}
	
	@Before
	public void buildUp() {
		stackA.push(0);
		stackA.push(1);
		stackA.push(2);
		stackA.push(3);
		stackA.push(4);
		
		stackL.push(0);
		stackL.push(1);
		stackL.push(2);
		stackL.push(3);
		stackL.push(4);
		
		improvedStack.push(0);
		improvedStack.push(1);
		improvedStack.push(2);
		improvedStack.push(3);
		improvedStack.push(4);
	}
	
	@After
	public void cleanUp() {
		stackA = null;
		improvedStack = null;
		stackL = null;
	}
	
	@Test
	public void emptyTest() {
		boolean actual = stackA.isEmpty();
		assertFalse(actual); //works
		
		actual = stackL.isEmpty();
		assertFalse(actual); //works
		
		actual = improvedStack.isEmpty();
		assertFalse(actual); //works
		
		stackA.pop();
		stackA.pop();
		stackA.pop();
		stackA.pop();
		
		actual = stackA.isEmpty();
		assertFalse(actual); //works
		
		stackA.pop();
		actual = stackA.isEmpty();
		assertTrue(actual); //works
		
		stackL.pop();
		stackL.pop();
		stackL.pop();
		stackL.pop();
		
		actual = stackL.isEmpty();
		assertFalse(actual); //works
		
		stackL.pop();
		actual = stackL.isEmpty();
		assertTrue(actual); //works
		
		improvedStack.pop();
		improvedStack.pop();
		improvedStack.pop();
		improvedStack.pop();
		
		actual = improvedStack.isEmpty();
		assertFalse(actual); //works
		
		improvedStack.pop();
		
		actual = improvedStack.isEmpty();
		assertTrue(actual); //works
		
		stackA.pop();
		improvedStack.pop();
		
		actual = stackA.isEmpty();
		assertTrue(actual); //works
		
		stackL.pop();
		
		actual = stackL.isEmpty();
		assertTrue(actual); //works
		
		actual = improvedStack.isEmpty();
		assertTrue(actual); //works
	}
	
	@Test
	public void sizeTest() {
		int actual = stackA.size();
		int expected = 5;
		assertEquals(actual, expected); //works
		
		actual = stackL.size();
		expected = 5;
		assertEquals(actual, expected); //works
		
		actual = improvedStack.size();
		assertEquals(actual, expected); //works
		
		stackA.pop();
		actual = stackA.size();
		expected = 4;
		assertEquals(actual, expected); //works
		
		stackA.pop(); // 3
		stackA.pop(); // 2
		stackA.pop(); // 1
		stackA.pop(); // 0
		stackA.pop(); // 0
		actual = stackA.size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		stackL.pop();
		actual = stackL.size();
		expected = 4;
		assertEquals(actual, expected); //works
		
		stackL.pop(); // 3
		stackL.pop(); // 2
		stackL.pop(); // 1
		stackL.pop(); // 0
		stackL.pop(); // 0
		actual = stackL.size();
		expected = 0;
		assertEquals(actual, expected); //works
		
		improvedStack.pop(); // 4
		improvedStack.pop(); // 3
		improvedStack.pop(); // 2
		improvedStack.pop(); // 1
		improvedStack.pop(); // 0
		actual = improvedStack.size();
		assertEquals(actual, expected); //works
	}
	
	@Test
	public void topTest() {
		Object actual = stackA.top().getReturnValue();
		Object expected = 4;
		assertEquals(actual, expected); //works
		
		actual = stackL.top().getReturnValue();
		expected = 4;
		assertEquals(actual, expected); //works
		
		actual = improvedStack.top().getReturnValue();
		assertEquals(actual, expected); //works
		
		stackA.pop(); // 4
		stackA.pop(); // 3
		stackA.pop(); // 2
		stackA.pop(); // 1
		stackA.pop(); // 0
		actual = stackA.top().getReturnValue();
		assertNull(actual); //works
		
		stackL.pop(); // 4
		stackL.pop(); // 3
		stackL.pop(); // 2
		stackL.pop(); // 1
		stackL.pop(); // 0
		actual = stackL.top().getReturnValue();
		assertNull(actual); //works
		
		improvedStack.pop(); // 4
		improvedStack.pop(); // 3
		improvedStack.pop(); // 2
		improvedStack.pop(); // 1
		improvedStack.pop(); // 0
		actual = improvedStack.top().getReturnValue();
		assertNull(actual); //works
	}
	
	@Test
	public void reverseTest() {
		ImprovedStack reverse = improvedStack.reverse();
		Object actual = reverse.top().getReturnValue();
		Object expected = 0;
		assertEquals(actual, expected); //works
		
		improvedStack.pop();
		improvedStack.pop();
		improvedStack.pop();
		improvedStack.pop();
		improvedStack.pop();
		reverse = improvedStack.reverse();
		actual = reverse.top().getReturnValue();
		assertNull(actual); //works
	}
	
	@Test
	public void removeTest() {
		improvedStack.push(4);
		improvedStack.push(4);
		
		improvedStack.remove(4);
		
		Object actual = improvedStack.size();
		Object expected = 4;
		assertEquals(actual, expected); //works
		
		improvedStack.push(0);
		improvedStack.push(1);
		improvedStack.remove(1);
		improvedStack.remove(0);
		
		actual = improvedStack.size();
		expected = 2;
		assertEquals(actual, expected); //works
	}
}