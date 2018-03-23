package fr.imie.theanthill;

import java.util.Date;
import java.util.concurrent.Callable;


public class Launcher {
	
	public static void funcExecTime(Callable<Void> func) {
		Date date = new Date();
		Long start = date.getTime();
		System.out.println(start);
		Long tps;
		try {
			func.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
		date = new Date();
		tps = date.getTime() - start;
		System.out.println(tps);
		System.out.println("Execution time : " + tps.toString() + " seconds.");
	}
	
	public Callable<Void> launch() {
		Anthill antH = new Anthill(5, 5, 1, 15);
		antH.initField();
		while (antH.getDay() < 80) {
			antH.showPopInfos();
			antH.jump();
			antH.setPop();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Launcher lnch = new Launcher();
		Launcher.funcExecTime(lnch.launch());
	}
}
