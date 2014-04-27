package com.test.thread.worker;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcreteQueue queue = new ConcreteQueue();
		
		TestTask2 task2 = new TestTask2();
		
		queue.put(task2);
		
		for (int i = 0; i < 10; i++) {
			TestTask1 task1 = new TestTask1(i);
			queue.put(task1);
		}
		
	}

}
