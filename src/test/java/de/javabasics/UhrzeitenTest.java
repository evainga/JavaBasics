package de.javabasics;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class UhrzeitenTest {
	private Uhrzeiten uhrzeiten = new Uhrzeiten();

	@Test
	public void assembleAllValidTimes() {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		
		assertThat(times, hasSize(1440));
		assertThat(times.get(2), is("0:02 Uhr"));
		assertThat(times, not(hasSize(1220)));
		assertThat(times.size(), both(lessThan(2000)).and(greaterThan(1000)));
	}
	
	@Test
	public void assembleAllValidTimesWithStreams() {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		List<String> timesWithStreams = uhrzeiten.assembleAllValidTimesWithStreams();
		
		assertThat(times, equalTo(timesWithStreams));
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testLowerBounds() {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(-1);
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testUpperBounds() {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		times.get(2000);
	}

	@Test
	public void testStrings() {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		assertThat(times.get(3), containsString(":"));
		assertThat(times.get(3), startsWith("0:0"));
	}

	@Test
	public void precedingZerosWithLambda() {
		List<String> times = uhrzeiten.assembleAllValidTimes();

		int minutesWithPrecedingZeros = times.stream().filter(time -> isPrecedingZeroInMinutePart(time))
				.collect(Collectors.toList()).size();

		assertThat(minutesWithPrecedingZeros, is(10 * 24));
	}

	@Test
	public void precedingZerosWithForEachLoop() {
		List<String> times = uhrzeiten.assembleAllValidTimes();

		int minutesWithPrecedingZeros = 0;
		for (String time : times)
			if (isPrecedingZeroInMinutePart(time))
				minutesWithPrecedingZeros++;

		assertThat(minutesWithPrecedingZeros, is(10 * 24));
	}

	private boolean isPrecedingZeroInMinutePart(String time) {
		return time.split(":")[1].startsWith("0");
	}

	@Test
	public void allTimesHaveUhrSuffix() {
		List<String> times = uhrzeiten.assembleAllValidTimes();

		for (String time : times)
			assertThat(time, endsWith(" Uhr"));
	}
}
