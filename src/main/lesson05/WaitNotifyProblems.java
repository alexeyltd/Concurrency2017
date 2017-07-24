package main.lesson05;

import main.lesson01.Utils;

public class WaitNotifyProblems {

	public static void main(String[] args) {

		Object pager = new Object();

		new Thread(() -> {

			synchronized (pager) {

				try {
					pager.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			System.out.println("huurray!");

		}).start();

		Utils.pause(2000);

		synchronized (pager) {

			pager.notify();

			while (true) {}

		}

	}

}
