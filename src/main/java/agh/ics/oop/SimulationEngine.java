package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, IPositionChangeObserver, Runnable {
	private final ArrayList<Animal> animals = new ArrayList<>();
	private MoveDirection[] md;
	private App app = null;
	int moveDelay = 300;

	public SimulationEngine(MoveDirection[] md, IWorldMap map, Vector2d[] initialPositions) {
		this.md = md;
		Animal animal;
		for (Vector2d initPos : initialPositions) {
			animal = new Animal(map, initPos);
			animals.add(animal);
			animal.addObserver(this);
		}
	}

	public SimulationEngine(IWorldMap map, Vector2d[] initialPositions) {
		this(new MoveDirection[]{}, map, initialPositions);
	}

	@Override
	public void run() {
		int i = 0;
		while (i < md.length) {
			animals.get(i % animals.size()).move(md[i]);
			i++;
			try {
				Thread.sleep(this.moveDelay);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public Animal getAnimal(int index) {
		return animals.get(index);
	}

	public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
		app.updateGrid();
	}

	public void setApplication(App app) {
		this.app = app;
	}

	public void setMoveDelay(int moveDelay) { this.moveDelay = moveDelay; }

	public void setMd(MoveDirection[] md) { this.md = md; }
}
