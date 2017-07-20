package main.lesson03.part01;

public class RunThreadTwice {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread();

		thread.start();
		System.out.println(thread.getState());

		thread.join();

		thread.start();

	}

}
