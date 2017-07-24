package main.lesson05;

import main.lesson01.Utils;

public class UseWorkerThread {

	public static void main(String[] args) {

		WorkerThread workerThread = new WorkerThread();

		workerThread.submit(() -> {

			System.out.println("start " + Thread.currentThread().getName());
			Utils.pause(1000);
			System.out.println("stop ");

		});

		workerThread.submit(() -> {

			System.out.println("start " + Thread.currentThread().getName());
			Utils.pause(1000);
			System.out.println("stop ");

		});

		workerThread.submit(() -> {

			System.out.println("start " + Thread.currentThread().getName());
			Utils.pause(1000);
			System.out.println("stop ");

		});

	}

}
