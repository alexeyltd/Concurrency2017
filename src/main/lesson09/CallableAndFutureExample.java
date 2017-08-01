package main.lesson09;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureExample {

	static class Task implements Callable<Double> {

		@Override
		public Double call() throws Exception {

			double result = 0;

			for (int i = 0; i < 100000000; i++) {

				Random random = new Random();
				result += Math.pow(Math.PI, random.nextDouble());
			}

			return result;
		}

	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();

		Future<Double> future = service.submit(new Task());

		try {
			Double result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
