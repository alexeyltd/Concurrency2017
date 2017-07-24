package main.lesson05;

import main.lesson01.Utils;

public class WaitNotifyExamples {

	static class Task implements Runnable {

		private final Object pager;

		public Task(Object pager) {

			this.pager = pager;

		}

		@Override
		public void run() {

			synchronized (pager) {

				try {
					pager.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(this);

			}

		}


		public static void main(String[] args) {

			System.out.println("start");

			Object pager = new Object();

			new Thread(new Task(pager)).start();

			Utils.pause(3000);

			synchronized (pager) {

				pager.notify();

			}

		}

	}

}
