package main.lesson06.part1;

import main.lesson01.Utils;

import java.util.Arrays;

public class StopExample {

	static class Task implements Runnable {

//		x + y = 0;

		int x;

		int y;

		Object lock = new Object();

		@Override
		public void run() {

			synchronized (lock) {

				x += 10;

				Utils.pause(1000);

				y -= 10;

			}


		}

		public int[] get() {

			int[] result = new int[2];

			synchronized (lock) {

				result[0] = x;
				result[1] = y;

			}

			return result;

		}

	}

	public static void main(String[] args) {

		System.out.println("start");

		Task task = new Task();

		Thread thread = new Thread(task);
		thread.start();

		Utils.pause(200);

		System.out.println(Arrays.toString(task.get()));

	}

}
