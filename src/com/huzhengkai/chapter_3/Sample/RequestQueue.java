package com.huzhengkai.chapter_3.Sample;

import java.util.Queue;
import java.util.LinkedList;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println(Thread.currentThread().getName()+"调用wait");
                wait();
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"调用notifyAll");
    }
}
