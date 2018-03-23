package fr.imie.theanthill;

import java.util.ArrayList;

public class Anthill {
	private int lNb;
	private int mNb;
	private int qNb;
	private int wNb;
	private int birth = 0;
	private int death = 0;
	private int day = 0;
	private ArrayList<Ant> field = new ArrayList<Ant>();
	
	public Anthill(int l, int m, int q, int w) {
		this.mNb = m;
		this.lNb = l;
		this.qNb = q;
		this.wNb = w;
	}
	
	public void initField() {
		for (int i = 0; i < this.qNb; i++) {
			this.field.add(new QueenAnt());
		} for (int i = 0; i < this.wNb; i++) {
			this.field.add(new WorkerAnt());
		} for (int i = 0; i < this.mNb; i++) {
			this.field.add(new MaleAnt());
		} for (int i = 0; i < this.lNb; i++) {
			this.field.add(new AntLarvae());
		}
	}
	
	public int getqNb() {
		return qNb;
	}
	
	public void setqNb(int qNb) {
		this.qNb = qNb;
	}
	
	public int getwNb() {
		return wNb;
	}
	
	public void setwNb(int wNb) {
		this.wNb = wNb;
	}
	
	public int getmNb() {
		return mNb;
	}
	
	public void setmNb(int mNb) {
		this.mNb = mNb;
	}
	
	public int getlNb() {
		return lNb;
	}
	
	public void setlNb(int lNb) {
		this.lNb = lNb;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public ArrayList<Ant> getField() {
		return field;
	}

	public void setField(ArrayList<Ant> field) {
		this.field = field;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public void jump() {
		this.day++;
		int j = 0;
		int birth = 0;
		int death = 0;
		Ant newGen;
		ArrayList<Ant> cpy = this.cloneField();
		for (Ant ant : cpy) {
			if (ant != null) {
				if (ant.getAntType().equals("QueenAnt")) {
					for (int i = 0; i < QueenAnt.EGGS_NB; i++) {
						this.field.add(ant.lay(this));
						birth++;
					}
				}
				newGen = ant.reachAge();
				death += (newGen == null) ? 1 : 0;
				this.field.set(j, newGen);
				j++;
			}
		}
		this.birth = birth;
		this.death = death;
	}
	
	public void setPop() {
		int nbQ = 0, nbL = 0, nbW = 0, nbM = 0;
		for (int i = 0; i < this.field.size(); i++) {
			if (this.field.get(i) != null) {
				switch (this.field.get(i).getAntType()) {
					case "MaleAnt":
						nbM++;
						break;
					case "AntLarvae":
						nbL++;
						break;
					case "WorkerAnt":
						nbW++;
						break;
					case "QueenAnt":
						nbQ++;
						break;
				}
			}
		}
		this.mNb = nbM;
		this.qNb = nbQ;
		this.lNb = nbL;
		this.wNb = nbW;
	}
	
	public int[] getPop() {
		int[] popList = new int[4];
		popList[0] = this.lNb;
		popList[1] = this.mNb;
		popList[2] = this.qNb;
		popList[3] = this.wNb;
		return popList;
	}
	
	public boolean lives() {
		if ((this.lNb + this.mNb + this.qNb + this.wNb) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public ArrayList<Ant> cloneField() {
		ArrayList<Ant> cpy = new ArrayList<Ant>();
		for (Ant ant : this.field) {
			cpy.add(ant);
		}
		return cpy;
	}
	
	public void showPopInfos() {
		System.out.println("Day " + this.getDay() + " - Larvae number " + this.getlNb() + " - Males number " + this.getmNb() + " - Queen number " + this.getqNb() + " - Workers number " + this.getwNb() + " - Birth " + this.getBirth() + " - Death " + this.getDeath());
	}
}
