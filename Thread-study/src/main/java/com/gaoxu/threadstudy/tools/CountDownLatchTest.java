package com.gaoxu.threadstudy.tools;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        int size = 3;
        CountDownLatch countDownLatch = new CountDownLatch(0);

        for (int i = 0; i < size; i++) {
            new Thread(() -> {

                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(500);
        countDownLatch.countDown();
    }
}
