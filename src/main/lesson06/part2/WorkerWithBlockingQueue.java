package main.lesson06.part2;

import main.lesson06.part2.BlockingQueue;


public class WorkerWithBlockingQueue {

	private final BlockingQueue<Runnable> tasks;
	private final Thread thread;
	private volatile boolean mayAcceptTasks;

	private final Runnable POISON_PILL = () -> {};

	public WorkerWithBlockingQueue() {
		synchronized (POISON_PILL) {
			tasks = new BlockingQueue<>();
			thread = new Thread(this::process);
			thread.start();
			mayAcceptTasks = true;
		}
	}

	public void shutDown() {
		submit(POISON_PILL);
	}

	private void process() {
		while (true) {
			Runnable task = tasks.get();
			if (task == POISON_PILL) {
				break;
			}
			task.run();
		}
	}

	public boolean submit(Runnable task) {
		synchronized (POISON_PILL) {
			if (!mayAcceptTasks) {
				return false;
			}
			if (tasks == POISON_PILL) {
				mayAcceptTasks = false;
			}
			tasks.put(task);
			return true;
		}
	}
}
