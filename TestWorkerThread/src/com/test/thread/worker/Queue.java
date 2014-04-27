package com.test.thread.worker;

public interface Queue {
	void put(RunnableTask task);
	RunnableTask take();
}
