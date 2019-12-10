package com.zhaosoft.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaoleizhao
 * @create 2019-12-07 17:24
 **/
@Slf4j
public class IOServerMultiThread {

    public static void main(String[] args) {
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
                new Thread( () -> {
                    try{
                        InputStream inputstream = socket.getInputStream();
                        log.info("Received message {}", IOUtils.toString(inputstream));
                        IOUtils.closeQuietly(inputstream);
                    } catch (IOException ex) {
                        log.error("Read message failed", ex);
                    }
                }).start();
            }
        } catch(IOException ex) {
            IOUtils.closeQuietly(serverSocket);
            log.error("Accept connection failed", ex);
        }
    }
}

