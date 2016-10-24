import java.util.ArrayList;
import java.util.List;

public class Uhrzeiten {
	public List<String> assembleAllValidTimes() {
		List<String> times = new ArrayList<>();
		int stunden;
		int minuten;
		for (stunden = 0; stunden < 24; stunden++) {
			for (minuten = 0; minuten < 60; minuten++) {
				String assembledString = stunden + ".";
				if (minuten < 10)
					assembledString = assembledString + 0;
				assembledString = assembledString + minuten;
				times.add(assembledString);
			}
		}
		return times;
	}
}
