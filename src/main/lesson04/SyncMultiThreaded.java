package main.lesson04;

import main.lesson01.Utils;

public class SyncMultiThreaded {

	synchronized void change() {

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			Utils.pause(1000);
		}

	}

	public static void main(String[] args) {

		SyncMultiThreaded sync = new SyncMultiThreaded();

		new Thread(() -> {

			sync.change();

		}).start();
		new Thread(() -> {

			sync.change();

		}).start();
		new Thread(() -> {

			sync.change();

		}).start();

		sync.change();
	}

}
