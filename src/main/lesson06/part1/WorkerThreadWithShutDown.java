package main.lesson06.part1;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerThreadWithShutDown {

	private Queue<Runnable> tasks = new LinkedList<>();
	private final Thread thread;

	public WorkerThreadWithShutDown() {
		thread = new Thread(this::process);
		thread.start();
	}

	public void shutDown() {

		thread.interrupt();

	}

	private void process() {

		OUTER: while (true) {

			Runnable task = null;

			synchronized (tasks) {

				while (tasks.isEmpty()) {

					try {
						tasks.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						break OUTER;
					}

				}

				task = tasks.poll();

			}

			task.run();

		}

	}

	public void submit(Runnable task) {

		synchronized (tasks) {

			tasks.add(task);
			tasks.notify();

		}

	}


}
