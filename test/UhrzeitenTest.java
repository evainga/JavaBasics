import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class UhrzeitenTest {

	@Test
	public void assembleAllValidTimes() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times.size(), is(1440));
		assertThat(times.get(2), is("0.02"));
		assertThat(times.size(), not(2000));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(-1);
	}

	@Test
	public void testIndexOutOfBoundsExceptionAnotherTry() {
		try {
			Uhrzeiten uhrzeiten = new Uhrzeiten();
			List<String> times = uhrzeiten.assembleAllValidTimes();
			times.get(2000);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
			assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 2000, Size: 1440"));
		}

	}
}
