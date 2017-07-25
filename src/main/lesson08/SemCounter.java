package main.lesson08;

import java.util.concurrent.Semaphore;

public class SemCounter {

	int count;

	Semaphore sem = new Semaphore(1);

	public int get() {
		sem.acquireUninterruptibly(); // synchronize(sem) {
		try {
			return count;
		} finally {
			sem.release(); // }
		}
	}

	public void inc() {
		sem.acquireUninterruptibly(); // synchronized(sem) {
		try {
			count++;
		} finally {
			sem.release(); // }
		}
	}

}
