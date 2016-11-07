package de.javabasics2;

import java.util.List;

import de.javabasics.Uhrzeiten;

public class RunUhrzeiten {
	private static Uhrzeiten uhrzeiten = new Uhrzeiten(false);

	public static void main(String[] args) {
		uhrzeiten.isTwentyFourHourSystem = true;
		List<String> times = uhrzeiten.assembleAllValidTimes();
		System.out.println(times);
	}
}
