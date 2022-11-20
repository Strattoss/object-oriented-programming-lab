package agh.ics.oop;

public class World {
	public static void main(String[] args) {
		MoveDirection[] directions = new OptionParser().parse(args);
		IWorldMap map = new GrassField(10);
		Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
		IEngine engine = new SimulationEngine(directions, map, positions);
		engine.run();
		System.out.println(map);


		/*directions = new OptionParser().parse(args);
		map = new GrassField(10);
		Animal cow = new Animal(map, new Vector2d(2, 2));

		for (MoveDirection direction : directions) {
			cow.move(direction);
			System.out.println(map);
		}*/
	}
}
