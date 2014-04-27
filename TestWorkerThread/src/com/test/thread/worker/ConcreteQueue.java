package com.test.thread.worker;

import java.util.Vector;

public class ConcreteQueue implements Queue {
	
	private Vector <RunnableTask>tasks;
	private boolean isWaiting;
	private boolean isShutdown;
	
	public ConcreteQueue() {
		tasks = new Vector<RunnableTask>();
		new Thread(new Worker()).start();
	}
	
	@Override
	public RunnableTask take() {
		if (tasks.isEmpty()) {
			synchronized (this) {
				isWaiting = true;
				try {
					wait();
				} catch (InterruptedException e) {
					isWaiting = false;
					e.printStackTrace();
				}
			}
		}

		return tasks.remove(0);
	}

	@Override
	public void put(RunnableTask task) {
		tasks.add(task);
		
		if(isWaiting) {
			synchronized (this) {
				notifyAll();
			}
		}
	}
	
	private class Worker implements Runnable {

		@Override
		public void run() {
			while(!isShutdown) {
				RunnableTask task = take();
				task.execute();
			}
		}
	}
}
