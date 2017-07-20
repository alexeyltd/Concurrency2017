package main.lesson01;

public class ExampleThree {

	static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("hello");
		}

	}

	public static void main(String[] args) {

		new MyThread().start();

	}

}
