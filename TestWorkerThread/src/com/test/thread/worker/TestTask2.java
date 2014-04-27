package com.test.thread.worker;

public class TestTask2 implements RunnableTask {

	@Override
	public void execute() {
		System.out.println("This is sample execution 2");
	}

}
