package main.lesson05;

import main.lesson01.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExamples {

	public static void main(String[] args) {

		Executor service = Executors.newSingleThreadExecutor();

		service.execute(() -> {

			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");

		});


		service.execute(() -> {

			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");

		});


		service.execute(() -> {

			System.out.println("start");
			Utils.pause(2000);
			System.out.println("stop");

		});
	}

}
