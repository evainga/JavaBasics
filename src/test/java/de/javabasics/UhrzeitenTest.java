package de.javabasics;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;

import org.testng.annotations.Test;

public class UhrzeitenTest {

	@Test
	public void assembleAllValidTimes() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times, hasSize(1440));
		assertThat(times.get(2), is("0.02"));
		assertThat(times, not(hasSize(1220)));
		assertThat(times.size(), both(lessThan(2000)).and(greaterThan(1000)));
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testLowerBounds() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(-1);
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testUpperBounds() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(2000);
	}

	@Test
	public void testStrings() {
		Uhrzeiten uhrzeiten = new Uhrzeiten();
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times.get(3), containsString("."));
		assertThat(times.get(3), startsWith("0.0"));
	}

}
