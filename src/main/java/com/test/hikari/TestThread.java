package com.test.hikari;

/**
 * Created by kotu on 8/21/16.
 */
class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running thread :" + threadName);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);

        if(t == null ) {

            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {

    public static void main(String[] args) {

        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}
