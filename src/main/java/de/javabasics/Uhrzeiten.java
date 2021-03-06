package de.javabasics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Uhrzeiten {
	private static final String MINUTE_HOUR_SEPARATOR = ":";
	private static final String UHR_STRING = " Uhr";

	/*
	 * public Uhrzeiten() { } > default Constructor (konstruiert das Objekt)
	 * wird implizit generiert
	 */

	public boolean isTwentyFourHourSystem;

	public Uhrzeiten(boolean isTwentyFourHourSystem) {
		// this. zeigt dass es die Objektvariable nimmt und nicht den Parameter
		this.isTwentyFourHourSystem = isTwentyFourHourSystem;
	}

	public List<String> assembleAllValidTimes() {
		System.out.println(isTwentyFourHourSystem);
		List<String> times = new ArrayList<>();
		int stunden;
		int minuten;
		for (stunden = 0; stunden < 24; stunden++) {
			for (minuten = 0; minuten < 60; minuten++) {
				String assembledString = stunden + MINUTE_HOUR_SEPARATOR;
				if (minuten < 10)
					assembledString = assembledString + 0;
				assembledString = assembledString + minuten + UHR_STRING;
				times.add(assembledString);
			}
		}
		return times;
	}

	public List<String> assembleAllValidTimesWithStreams() {
		return IntStream.rangeClosed(0, 23).boxed().flatMap(hour -> iterateMinutes(hour)).collect(Collectors.toList());
	}

	private Stream<String> iterateMinutes(int hour) {
		return IntStream.rangeClosed(0, 59).boxed()
				.map(minute -> String.format("%d%s%02d%s", hour, MINUTE_HOUR_SEPARATOR, minute, UHR_STRING));
	}
}
