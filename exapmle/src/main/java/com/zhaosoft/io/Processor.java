package com.zhaosoft.io;

/**
 * @author xiaoleizhao
 * @create 2019-12-07 17:30
 **/
public class Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);
    private static final ExecutorService service = Executors.newFixedThreadPool(16);

    public void process(SelectionKey selectionKey) {
        service.submit(() -> {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            int count = socketChannel.read(buffer);
            if (count < 0) {
                socketChannel.close();
                selectionKey.cancel();
                LOGGER.info("{}\t Read ended", socketChannel);
                return null;
            } else if(count == 0) {
                return null;
            }
            LOGGER.info("{}\t Read message {}", socketChannel, new String(buffer.array()));
            return null;
        });
    }
}

