package main.lesson03.part01;

public class ThreadStack {

	public static void main(String[] args) {
		a();
	}

	private static void a() {
		a();
	}

}
