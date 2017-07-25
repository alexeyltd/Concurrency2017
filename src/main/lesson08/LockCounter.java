package main.lesson08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

	int count;

	Lock lock = new ReentrantLock();

	public int get() {
		lock.lock(); //synchronize(lock) {
		try {
			return count;
		} finally {
			lock.unlock(); // }
		}
	}

	public void inc() {
		lock.lock(); //synchronize(lock) {
		try {
			count++;
		} finally {
			lock.unlock(); // }
		}
	}

}
