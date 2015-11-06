package com.cpk.showcase.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Author:cp
 * Created on 11/4/15.
 */
public class BootStrap {

    public static void main(String[] args) throws InterruptedException {
        final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/user-dubbo-provider.xml");
        ac.start();
        System.out.println("User Service started successfully");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutdown hook was invoked. Shutting down User Service.");
                ac.close();
            }
        });
        //prevent main thread from exit
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
