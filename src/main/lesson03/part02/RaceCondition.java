package main.lesson03.part02;

import main.lesson01.Utils;

public class RaceCondition {

	volatile static int count = 0;

	static class Task implements Runnable {

		@Override
		public void run() {

			while (true) {
				Utils.pause(3000);
				inc();
			}

		}

		private  void inc() {

			synchronized (this) {
				count++;
				System.out.println(count);
			}

		}

	}




	public static void main(String[] args) {

		Task task = new Task();

		Thread threadOne = new Thread(task);
		Thread threadTwo = new Thread(task);

		threadOne.start();
		threadTwo.start();

	}

}
