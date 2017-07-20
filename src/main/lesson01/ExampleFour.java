package main.lesson01;


public class ExampleFour {

	public static void main(String[] args) {


		new Thread(() -> {

			int count = 0;

			while (true) {

				System.out.println(count++);

				Utils.pause(1000);

			}

		}, "Counter").start();

	}

}
