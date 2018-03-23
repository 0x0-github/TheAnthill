package fr.imie.theanthill;

public abstract class Ant {
	//Incremented each time an ant birth
	public static int currId = 0;
	
	protected int id;
	protected int age;
	
	public Ant() {
		this.id = Ant.currId++;
		this.age = 0;
	}
	
	public abstract Ant reachAge();
	
	public abstract AntLarvae lay(Anthill home);
	
	public String getAntType() {
		return this.getClass().getSimpleName();
	}
	
	public static int getCurrId() {
		return currId;
	}
	
	public static void setCurrId(int currId) {
		Ant.currId = currId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
