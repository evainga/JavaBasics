import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.testng.annotations.Test;

public class UhrzeitenTest {

	@Test
	public void assembleAllValidTimes() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times.size(), is(1440));
		assertThat(times.get(2), is("0.02"));
		assertThat(times.size(), not(2000));
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(-1);
	}
}
