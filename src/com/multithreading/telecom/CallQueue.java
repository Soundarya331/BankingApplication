package com.multithreading.telecom;

import java.util.ArrayDeque;
import java.util.Queue;

public class CallQueue {
	
	Queue<CallRequest> queue = new ArrayDeque<CallRequest>();
	
	void addCall(CallRequest request) {
		queue.add(request);
	}
	
	void processCall(){
		queue.poll();
		
	}

}
