package main.lesson09;

import main.lesson01.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {

	static AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();

		Runnable runnable = () -> {
			while (true) {
				int c = count.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + " " + c);
				Utils.pause(1000);
			}

		};

		service.execute(runnable);

		service.execute(runnable);

	}


}
