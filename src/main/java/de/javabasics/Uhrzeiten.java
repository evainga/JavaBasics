package de.javabasics;

import java.util.ArrayList;
import java.util.List;

public class Uhrzeiten {
	private static final String MINUTE_HOUR_SEPARATOR = ":";

	public List<String> assembleAllValidTimes() {
		List<String> times = new ArrayList<>();
		int stunden;
		int minuten;
		for (stunden = 0; stunden < 24; stunden++) {
			for (minuten = 0; minuten < 60; minuten++) {
				String assembledString = stunden + MINUTE_HOUR_SEPARATOR;
				if (minuten < 10)
					assembledString = assembledString + 0;
				assembledString = assembledString + minuten + " Uhr";
				times.add(assembledString);
			}
		}
		return times;
	}
}
