package de.javabasics;

import java.util.List;

public class RunUhrzeiten extends Uhrzeiten {
	private static Uhrzeiten uhrzeiten = new Uhrzeiten();

	public static void main(String[] args) {
		List<String> times = uhrzeiten.assembleAllValidTimes();
		System.out.println(times);
	}
}
