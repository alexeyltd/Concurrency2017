package main.lesson07;

public class SyncLock {

	public static void main(String[] args) {

		Object o1 = new Object();
		Object o2 = new Object();

		synchronized (o1) {
			synchronized (o2) {

			}
		}

	}

}
