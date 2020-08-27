package main;

public class RunLoop extends Thread {
	private static boolean running = true;
	private static boolean update = true;
	
	public void run() {
		while(running) {
			try {
				sleep(50);
				
				if(update) Main.update();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
