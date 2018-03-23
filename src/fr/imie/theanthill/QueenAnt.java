package fr.imie.theanthill;

public class QueenAnt extends Ant {
	
	public static int LIFE_LENGTH = 50;
	public static int EGGS_NB = 10;
	
	public Ant reachAge() {
		this.age++;
		if (this.age >= QueenAnt.LIFE_LENGTH) {
			return null;
		} else {
			return this;
		}
	}
	
	public AntLarvae lay(Anthill home) {
		if (home.getmNb() > 0) {
			return new AntLarvae();
		} else {
			return null;
		}
	}
}
