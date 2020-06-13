package com.home.eugene.G_WaitAndNotify;

import java.util.Scanner;

public class Processor {
    public void produce() throws  InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running");
            wait();
            System.out.println("Resumed");
        }
    }

    public void consume() throws  InterruptedException{
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for return key");
            sc.nextLine();
            System.out.println("Return key pressed");
            //notify has to be last in the synchronized block
            //otherwise this thread wont release intrinsic log of 'this' obj
            notify();
            //Thread.sleep(5000);
        }
    }

}
