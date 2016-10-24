import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;

public class UhrzeitenTest {

	@Test
	public void assembleAllValidTimes() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times, hasSize(1440));
		assertThat(times.get(2), is("0.02"));
		assertThat(times, not(hasSize(1440)));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testLowerBounds() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testUpperBounds() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(2000);
	}

}
