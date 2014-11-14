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
		assertEquals(actual, noError);

	}

	@Test
	public void testEmpty() {
		test.setErrorList(true, 10, 5, words);
		ErrorMessage actual = test.getError();
		assertEquals(actual, empty);

		test.setErrorList(true, 10, 5);
		actual = test.getError();
		assertEquals(actual, empty);

		test.setErrorList(true, 10, words);
		assertEquals(actual, empty);
	}

	@Test
	public void testOOB() {
		test.setErrorList(false, 5, 10);
		ErrorMessage actual = test.getError();
		assertEquals(actual, oob);

		test.setErrorList(false, 5, 10, words);
		actual = test.getError();
		assertEquals(actual, oob);
	}

	@Test
	public void testInv() {
		test.setErrorList(false, 10, 5, null);
		ErrorMessage actual = test.getError();
		assertEquals(actual, invalid);

		words = null;
		test.setErrorList(false, 10, words);
		assertEquals(actual, invalid);
	}

	@Test
	public void testGetReturnValue() {
		Object actual = test.getReturnValue();
		Object expected = "Test";
		assertEquals(actual, expected);

		testEmpty();
		actual = test.getReturnValue();
		expected = null;
		assertEquals(actual, expected);
	}
}