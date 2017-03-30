package com.liangjiange.cloud.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.*;

/**
 * Created by liangjiange on 2017/3/24.
 */
public class ExecutorTest {

    private static final int NUM = 100;

    private static final Executor exec = Executors.newFixedThreadPool(NUM);

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(80);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                //TODO handle connection;
            }
        };
        exec.execute(task);
    }

}
