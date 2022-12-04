package agh.ics.oop;

public class OptionParser {
	public MoveDirection[] parse(String[] md) {
		if (md.length == 0) return new MoveDirection[]{};

		MoveDirection[] res = new MoveDirection[md.length];

		int i = 0;
		for (String s : md) {
			switch (s) {
				case "f", "forward" -> {
					res[i] = MoveDirection.FORWARD;
					i++;
				}
				case "b", "backward" -> {
					res[i] = MoveDirection.BACKWARD;
					i++;
				}
				case "l", "left" -> {
					res[i] = MoveDirection.LEFT;
					i++;
				}
				case "r", "right" -> {
					res[i] = MoveDirection.RIGHT;
					i++;
				}
				default -> throw new IllegalArgumentException(s + " is not legal move specification");
			}
		}
		return res;
	}
}
