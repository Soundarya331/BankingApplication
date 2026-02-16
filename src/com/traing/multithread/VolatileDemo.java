package com.traing.multithread;

public class VolatileDemo {
	static volatile boolean flag = false;
	public static  void main(String[] args) {
		Thread t1 = new Thread(()->{
		while(!flag) {
			System.out.println("Its first execution runnning");
		}System.out.println("Flag value updated!!!");
		},"thread1");
		
		
		Thread t2 = new Thread( ()->
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			flag = true;
			System.out.println("Flag value updated by : " + Thread.currentThread().getName());
			
		},
		"thread 2"
		);
		t1.start();
		t2.start();
	}

}
