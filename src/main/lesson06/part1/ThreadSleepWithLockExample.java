package main.lesson06.part1;

import main.lesson01.Utils;

public class ThreadSleepWithLockExample {

	public static void main(String[] args) {

		System.out.println("start");

		Object lock = new Object();

		Thread thread = new Thread(() -> {

			synchronized (lock) {

				try {
					lock.wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Woke up");

			}

		});
		thread.start();

		Utils.pause(1000);

		synchronized (lock) {

			System.out.println("hello");

		}

	}

}
