package com.zhaosoft.io;

/**
 * @author xiaoleizhao
 * @create 2019-12-07 17:25
 **/
public class IOServerThreadPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOServerThreadPool.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));
        } catch (IOException ex) {
            LOGGER.error("Listen failed", ex);
            return;
        }
        try{
            while(true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> {
                    try{
                        InputStream inputstream = socket.getInputStream();
                        LOGGER.info("Received message {}", IOUtils.toString(new InputStreamReader(inputstream)));
                    } catch (IOException ex) {
                        LOGGER.error("Read message failed", ex);
                    }
                });
            }
        } catch(IOException ex) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
            LOGGER.error("Accept connection failed", ex);
        }
    }
}

