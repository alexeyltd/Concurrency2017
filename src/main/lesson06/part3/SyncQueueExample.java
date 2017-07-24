package main.lesson06.part3;

import main.lesson01.Utils;

import java.util.Random;
import java.util.concurrent.*;

public class SyncQueueExample {

	static final Random random = new Random();

	public static void main(String[] args) {

		BlockingQueue<String> window = new LinkedBlockingQueue<>();

		Cook cook = new Cook(window);

		Waiter waiter = new Waiter(window);

		ExecutorService service = Executors.newCachedThreadPool();

		service.execute(cook);
		service.execute(waiter);

		service.execute(() -> {

			while (true) {
				Utils.pause(1000);
				System.out.println(window.size());

				if (window.size() > 2) {
					service.execute(new Waiter(window));
				}
			}

		});

	}

}
