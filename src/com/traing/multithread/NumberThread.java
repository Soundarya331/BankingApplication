package com.traing.multithread;

public class NumberThread extends Thread {

	
	Thread t1 = new Thread();
	Thread t2 = new Thread();
	@Override
	public void run() {
		for (int i = 1; i <=10; i++) {
			
			try {
				System.out.println("2 *" + i +" " + i*2);
				t1.sleep(200);
				System.out.println("5 *" + i + i*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
