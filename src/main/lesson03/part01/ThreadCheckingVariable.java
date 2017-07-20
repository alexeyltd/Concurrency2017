package main.lesson03.part01;

import main.lesson01.Utils;

public class ThreadCheckingVariable {

	volatile static boolean RUNNING = true;

	static class Task implements Runnable {

		@Override
		public void run() {

			long count = 0;

			while (RUNNING) {
				count++;

			}

			System.out.println(count);

		}

	}

	public static void main(String[] args) {

		Thread thread = new Thread(new Task());

		thread.start();

		Utils.pause(3000);

		RUNNING = false;

	}

}
