package main.lesson06.part3;

import main.lesson01.Utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

class Waiter implements Runnable {

	private final BlockingQueue<String> window;

	public Waiter(BlockingQueue<String> window) {
		this.window = window;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("start waiting");
			try {
				String dish =  window.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("serving");
			Utils.pause(10000 + SyncQueueExample.random.nextInt(3000));
		}
	}
}
