package main.lesson01;

public class ExampleFive {

	static class Task implements Runnable {

		private final String name;

		public Task(String name) {

			this.name = name;

		}

		@Override
		public void run() {
			Thread.currentThread().setName(name);
			int count = 0;

			while (true) {
				Utils.pause(1000);
				System.out.println(count++);
			}

		}

	}

	public static void main(String[] args) {

		new Thread(new Task("counter")).start();
		new Thread(new Task("counter2")).start();


	}

}
