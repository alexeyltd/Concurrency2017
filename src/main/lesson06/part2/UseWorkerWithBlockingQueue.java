package main.lesson06.part2;

import main.lesson01.Utils;

public class UseWorkerWithBlockingQueue {

	static class Task implements Runnable {

		private final int number;

		public Task(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			System.out.println("start " + number);
			Utils.pause(2000);
			System.out.println("stop " + number);
		}
	}


	public static void main(String[] args) {

		WorkerWithBlockingQueue poisonPill = new WorkerWithBlockingQueue();

		poisonPill.submit(new Task(1));
		poisonPill.submit(new Task(2));
		poisonPill.submit(new Task(3));

		poisonPill.shutDown();

		System.out.println("finish tasks planning");

	}

}
