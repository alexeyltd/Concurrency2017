package main.lesson07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockSeparateExample {

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();

		lock.lock(); // synchronized(lock)
		System.out.println(lock.getHoldCount());

		lock.lock(); // synchronized(lock)
		System.out.println(lock.getHoldCount());

		new Thread(() -> {

			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			} else {
				System.out.println("i can't do it!");
			}

		}).start();

	}

}
