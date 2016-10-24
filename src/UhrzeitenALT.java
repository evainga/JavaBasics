
public final class UhrzeitenALT {
	public static void main(final java.lang.String[] args) {
		int stunden;
		int minuten;
		for (stunden = 0; stunden < 24; stunden++) {
			for (minuten = 0; minuten < 60; minuten++) {
				System.out.print(stunden + ".");
				if (minuten < 10) {
					System.out.print("0");
				}
				System.out.println(minuten);
			}
		}
	}
}
