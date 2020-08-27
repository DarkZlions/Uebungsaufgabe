package main;

import gui.WindowHandler;
import lib.CustomerList;

public class Main {
	
	public static void main(String[] args) {
		CustomerList.loadList();
		WindowHandler.HOME_WINDOW.setVisible(true);
	}
	
	public static void initRun() {
		RunLoop run = new RunLoop();
		run.run();
	}
	
	public static void update() {
		
	}
	
	public static void exit() {
		System.exit(0);
	}
}
