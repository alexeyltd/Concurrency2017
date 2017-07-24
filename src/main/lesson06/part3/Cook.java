package main.lesson06.part3;

import main.lesson01.Utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

class Cook implements Runnable {

	private final BlockingQueue<String> window;

	public Cook(BlockingQueue<String> window) {
		this.window = window;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("start cooking");
			Utils.pause(1000 + SyncQueueExample.random.nextInt(3000));
			System.out.println("dish is ready, waiting for waiter");
			try {
				window.put("dish");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
