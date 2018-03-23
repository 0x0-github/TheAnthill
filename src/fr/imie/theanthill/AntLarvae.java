package fr.imie.theanthill;

public class AntLarvae extends Ant {
	public static int LIFE_LENGTH = 10;
	
	private Ant future;
	
	public AntLarvae() {
		this.id = Ant.currId++;
		this.age = 0;
		int rdmNb = (int) (Math.random()*100%20);
		if (rdmNb == 1) {
			this.future = new QueenAnt();
		} else if (rdmNb == 2 || rdmNb == 3) {
			this.future = new MaleAnt();
		} else {
			this.future = new WorkerAnt();
		}
		
	}
	
	public Ant reachAge() {
		this.age++;
		if (this.age >= AntLarvae.LIFE_LENGTH) {
			return this.future;
		} else {
			return this;
		}
	}
	
	public AntLarvae lay(Anthill home) {
		return null;
	}
}
