package main.lesson07;

import main.lesson01.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {

	static class EvilTask implements Runnable {

		private final Lock lock;

		public EvilTask(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {

			lock.lock();
			while (true) {


			}

		}

	}

	public static void main(String[] args) {

		System.out.println("start");

		Lock lock = new ReentrantLock();

		new Thread(new EvilTask(lock)).start();

		Utils.pause(500);

		System.out.println("lock interruptibly");

		Thread thread = new Thread(() -> {
			System.out.println("locker started");

			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				System.out.println("interrupted!");
				return;
			}

			System.out.println("got it!");

		});
		thread.start();

		Utils.pause(3000);

		thread.interrupt();



	}

}
