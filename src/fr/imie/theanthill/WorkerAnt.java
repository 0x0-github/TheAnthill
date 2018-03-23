package fr.imie.theanthill;

public class WorkerAnt extends Ant {
	public static int LIFE_LENGTH = 50;
	
	public Ant reachAge() {
		this.age++;
		if (this.age >= WorkerAnt.LIFE_LENGTH) {
			return null;
		} else {
			return this;
		}
	}
	
	public AntLarvae lay(Anthill home) {
		return null;
	}
}
