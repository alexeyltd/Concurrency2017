package main.lesson03.part01;

import main.lesson01.Utils;

public class ThreadCommunication {

	static final int NOP = -1;
	static final int STOP = 0;
	static final int STATE = 1;

	static int command = NOP;

	static class Task implements Runnable {

		@Override
		public void run() {

			long count = 0;

			OUTER: while (true) {

				if (Thread.interrupted()) {
					switch (command) {
						case NOP:
							break;
						case STOP:
							break OUTER;
						case STATE:
							System.out.println(count);
							break;
					}
				}

				count++;

			}

			System.out.println(count);

		}

	}

	public static void main(String[] args) {

		Thread thread = new Thread(new Task());

		thread.start();

		Utils.pause(3000);

		System.out.println("interrupt 1");

		thread.interrupt();

		Utils.pause(3000);

		command = STATE;

		System.out.println("interrupt 2");

		thread.interrupt();

		Utils.pause(3000);

		command = STOP;

		System.out.println("interrupt 3");

		thread.interrupt();


	}

}
