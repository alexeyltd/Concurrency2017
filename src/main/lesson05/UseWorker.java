package main.lesson05;

public class UseWorker {

	public static void main(String[] args) {

		SimpleWorker simpleWorker = new SimpleWorker();

		simpleWorker.process(() -> {

			System.out.println("you did it!");

		});

		simpleWorker.process(() -> {

			System.out.println("you did it!");

		});

		simpleWorker.process(() -> {

			System.out.println("you did it!");

		});



	}

}
