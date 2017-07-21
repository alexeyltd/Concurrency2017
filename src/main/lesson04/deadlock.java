package main.lesson04;

import main.lesson01.Utils;

public class deadlock {

	public static void main(String[] args) {

		Object a = new Object();
		Object b = new Object();

		new Thread(() -> {

			synchronized (a) {

				System.out.println(Thread.currentThread() + " got " + a);

				Utils.pause(1000);

				synchronized (b) {
					System.out.println("Got it !");
				}

			}

		}).start();

		new Thread(() -> {

			synchronized (b) {

				System.out.println(Thread.currentThread() + " got " + a);


				Utils.pause(1000);

				synchronized (a) {
					System.out.println("Got it !");
				}

			}

		}).start();

	}

}
