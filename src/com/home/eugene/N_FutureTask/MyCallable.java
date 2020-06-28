package com.home.eugene.N_FutureTask;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private long waitTime;

    public MyCallable(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //returns thread name that executes that task
        return Thread.currentThread().getName();
    }
}
