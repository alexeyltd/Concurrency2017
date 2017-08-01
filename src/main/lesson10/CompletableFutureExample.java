package main.lesson10;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

	public static void main(String[] args) {

		CompletableFuture<Void> helloworld = CompletableFuture.runAsync(() -> {
			System.out.println("hello");
		}).thenRun(() -> {
			System.out.println("world");
		});

		helloworld.join();


		CompletableFuture<Void> hey = CompletableFuture.runAsync(() -> {
			System.out.println("hey");
		});


	}

}
