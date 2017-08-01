package main.lesson09;

import main.lesson01.Utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExamples {

	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();

		Future<?> one = service.submit(() -> {
			System.out.println("one");
			Utils.pause(1000);
		});

		Future<?> two = service.submit(() -> {
			System.out.println("two");
			Utils.pause(1000);
		});

		Future<?> three = service.submit(() -> {
			System.out.println("three");
			Utils.pause(1000);
		});

		two.cancel(false);

		List<Runnable> tasks = service.shutdownNow();

	}

}
