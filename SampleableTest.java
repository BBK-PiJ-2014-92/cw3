import org.junit.*;
import static org.junit.Assert.*;

public class SampleableTest {
	private SampleableList array;
	private SampleableList linked;
	private List arrayList = new ArrayList();
	private List linkedList = new LinkedList();
	
	public SampleableTest() {
		array = new SampleableListImpl(arrayList);
		linked = new SampleableListImpl(linkedList);
	}
	
	@Before
	public void buildUp() {
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		
		linked.add(0);
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.add(4);
	}
	
	@After
	public void cleanUp() {
		array = null;
		linked = null;
	}
	
	@Test
	public void sampleTest() {
		Object actual = array.size();
		Object expected = 5;
		assertEquals(actual, expected); //works
		
		SampleableList sample;
		sample = array.sample();
		actual = sample.get(1).getReturnValue();
		expected = 2;
		assertEquals(actual, expected); //works
		
		sample = linked.sample();
		actual = sample.get(1).getReturnValue();
		assertEquals(actual, expected); //works
	}
}