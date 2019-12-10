package com.zhaosoft.io;

import lombok.extern.slf4j.Slf4j;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaoleizhao
 * @create 2019-12-07 17:25
 **/
@Slf4j
public class IOServerThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));
        } catch (IOException ex) {
            log.error("Listen failed", ex);
            return;
        }
        try{
            while(true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> {
                    try{
                        InputStream inputstream = socket.getInputStream();
                        log.info("Received message {}", new InputStreamReader(inputstream));
                    } catch (IOException ex) {
                        log.info("Read message failed", ex);
                    }
                });
            }
        } catch(IOException ex) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
            log.info("Accept connection failed", ex);
        }
    }
}

