package main.lesson06.part2;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

	private Queue<T> tasks = new LinkedList<>();

	public void put(T item) {
		synchronized (tasks) {
			tasks.add(item);
			tasks.notify();
		}
	}

	public T get() {
		synchronized (tasks) {
			while (tasks.isEmpty()) {
				try {
					tasks.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return tasks.poll();
		}
	}
}
