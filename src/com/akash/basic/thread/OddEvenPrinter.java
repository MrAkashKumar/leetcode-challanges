package com.akash.basic.thread;

public class OddEvenPrinter {

    private static final int MAX = 10;
    private static int number = 1;
    private static final Object lock = new Object();
    
    public static void main(String[] args) {

        oddEvenPrinterViaThread();
        
    }

    private static void oddEvenPrinterViaThread(){

        Thread oddThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) { /* only one thread at a time can enter the critical section */
                    if (number % 2 == 1) {
                        System.out.println("Odd: " + number);
                        number++;
                        lock.notify(); /* The thread gives up the lock and goes into the waiting state.
                                        * It won’t run again until some other thread calls lock.notify(). */
                    } else {
                        try {
                            lock.wait(); /* */
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println("Even: " + number);
                        number++;
                        lock.notify(); /* */
                    } else {
                        try {
                            lock.wait(); /* */
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();

    }


}
