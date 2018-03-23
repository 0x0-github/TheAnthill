package fr.imie.theanthill;

public class MaleAnt extends Ant {
	public static int LIFE_LENGTH = 20;
	
	public Ant reachAge() {
		this.age++;
		if (this.age >= MaleAnt.LIFE_LENGTH) {
			return null;
		} else {
			return this;
		}
	}
	
	public AntLarvae lay(Anthill home) {
		return null;
	}
}
