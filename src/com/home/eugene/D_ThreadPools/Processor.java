package com.home.eugene.D_ThreadPools;

public class Processor implements Runnable {
    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex){

        }
        System.out.println("Completed " + id);
    }
}
