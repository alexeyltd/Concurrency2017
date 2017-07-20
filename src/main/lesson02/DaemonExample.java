package main.lesson02;

import main.lesson01.Utils;

public class DaemonExample {

	static class Counter implements Runnable {

		@Override
		public void run() {
			int count = 0;

			while (true) {
				Utils.pause(1000);
				System.out.println(++count);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new Counter());
		thread.setDaemon(true);
		thread.start();

//		thread.join();

	}

}
