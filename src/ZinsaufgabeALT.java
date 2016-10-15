public class ZinsaufgabeALT {
	public static void loop(int min, int top) {
		System.out.print("\"");
		if (min > top - 1)
			System.out.printf("\"%n");
		else if (min == top - 1)
			System.out.printf("%s.\"%n", min);
		else {
			for (; min < top - 2; min = min + 1)
				System.out.print(min + ", ");
			System.out.printf("%s und %s.\"%n", min, min + 1);
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

	}
}
