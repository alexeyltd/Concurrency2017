package main.lesson02;

import main.lesson01.Utils;

public class JoinExample {

	static class Task implements Runnable {

		@Override
		public void run() {

			System.out.println("start");

			Utils.pause(3000);

			System.out.println("finish");
		}

	}

	public static void main(String[] args) {

		Thread thread = new Thread(new Task());

		thread.start();
		System.out.println("thread started");

		try {
			thread.join(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("main ended");

		Utils.pause(10000);

	}

}
