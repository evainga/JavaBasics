package main.java;

public class Zinsaufgabe {
	public static void loop(int min, int top) {
		if (min > top - 1)
			System.out.println();
		else if (min == top - 1)
			System.out.println(min);
		else {
			for (; min < top - 2; min++)
				System.out.print(min + ", ");
			System.out.printf("%d und %d%n", min, min + 1);
		}
	}

	public static void main(String[] args) {
		loop(4, 3);
		loop(4, 4);
		loop(4, 5);
		loop(4, 6);
		loop(4, 7);
		loop(4, 8);
		loop(4, 9);
		loop(-4, 9);
		loop(4, -9);

	}
}
