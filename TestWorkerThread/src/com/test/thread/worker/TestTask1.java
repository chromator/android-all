package com.test.thread.worker;

public class TestTask1 implements RunnableTask {

	private int num;
	
	public TestTask1(int num) {
		this.num = num;
	}
	
	@Override
	public void execute() {
		System.out.println("This is sample execution "+num);
	}

}
