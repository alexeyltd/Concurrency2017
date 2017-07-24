package main.lesson06.part1;

import main.lesson01.Utils;

public class SuspendResumeExamples {

	public static void main(String[] args) {

		System.out.println("start");

		Object lock = new Object();

		Thread thread = new Thread(() -> {

			synchronized (lock) {

				Utils.pause(10000);

				System.out.println("Woke up");

			}

		});
		thread.start();

		Utils.pause(1000);



	}

}
