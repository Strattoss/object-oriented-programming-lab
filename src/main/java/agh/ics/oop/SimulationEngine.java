package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
	private final ArrayList<Animal> animals;
	private final MoveDirection[] md;

	public SimulationEngine(MoveDirection[] md, IWorldMap map, Vector2d[] initialPositions) {
		animals = new ArrayList<>();
		this.md = md;
		for (Vector2d initPos : initialPositions) {
			animals.add(new Animal(map, initPos));
		}
	}

	public void run() {
		int i = 0;
		while (i < md.length) {
			animals.get(i % animals.size()).move(md[i]);
			i++;
		}
	}

	public Animal getAnimal(int index) {
		return animals.get(index);
	}
}
