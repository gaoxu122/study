package com.gaoxu.threadstudy.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * 多个线程同时执行 模拟并发场景
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        int size = 3;
        CountDownLatch countDownLatch = new CountDownLatch(0);

        for (int i = 0; i < size; i++) {
            new Thread(() -> {

                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());

                    LockSupport.park();
                    System.out.println("111111111111111111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(500);
        countDownLatch.countDown();
    }
}
