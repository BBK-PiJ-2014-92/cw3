import org.junit.*;
import static org.junit.Assert.*;

public class ReturnObjectTest {
	private Object words;
	private ReturnObjectImpl test;
	private ErrorMessage noError = ErrorMessage.NO_ERROR;
	private ErrorMessage empty = ErrorMessage.EMPTY_STRUCTURE;
	private ErrorMessage oob = ErrorMessage.INDEX_OUT_OF_BOUNDS;
	private ErrorMessage invalid = ErrorMessage.INVALID_ARGUMENT;

	public ReturnObjectTest() {
		words = "Test";
	}

	@Before
	public void buildUp() {
		test = new ReturnObjectImpl(words);
		words = "Test";
	}

	@After
	public void cleanUp() {
		test = null;
		words = null;
	}

	@Test
	public void testNoError() {
		ErrorMessage actual = test.getError();
		assertEquals(actual, noError); //works

	}

	@Test
	public void testEmpty() {
		test.setEmpty(true);
		Object actual = test.getError();
		assertEquals(actual, empty); //works
		
		actual = test.getReturnValue();
		assertNull(actual); //works
	}

	@Test
	public void testOOB() {
		int size = 11;
		int index = 12;
		test.setOOB(size, index);
		Object actual = test.getError();
		assertEquals(actual, oob); //works

		actual = test.getReturnValue();
		assertNull(actual); //works
	}

	@Test
	public void testInv() {
		test.setInvalid(null);
		Object actual = test.getError();
		assertEquals(actual, invalid); //works

		words = null;
		test.setInvalid(words);
		assertEquals(actual, invalid); //works
		
		actual = test.getReturnValue();
		assertNull(actual); //works
	}

	@Test
	public void testGetReturnValue() {
		Object actual = test.getReturnValue();
		Object expected = "Test";
		assertEquals(actual, expected); //works

		testEmpty();
		actual = test.getReturnValue();
		expected = null;
		assertEquals(actual, expected); //works
	}
}