package main.lesson01;

import com.github.rjeschke.txtmark.Run;

public class ExampleTwo {

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("hello");
		}

	}

	public static void main(String[] args) {

		Task task = new Task();

		Thread t = new Thread(task);

		t.start();

		new Thread(() -> System.out.println("hello2")).start();


	}

}
