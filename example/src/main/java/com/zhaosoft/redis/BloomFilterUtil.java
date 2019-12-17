package com.zhaosoft.redis;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author xiaoleizhao
 * @create 2019-12-16 11:14
 **/
public class BloomFilterUtil {
    private static int size = 1000000;

    private static BloomFilter<String> bloomFilter = null;

    //获取一个布隆过滤器 fileName:持久化的文件名,这里是相对路径,就在本项目下
    public static BloomFilter<String> getStringBloomFilter(String fileName) {

        try {
            File file = new File("filter");
            if (!file.exists()) {
                System.out.println("持久化文件不存在!,将创建文件,布隆过滤器为空");
                bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), size);
            } else {
                System.out.println("持久化文件存在!,从文件读取数据到布隆过滤器");
                FileInputStream fileInputStream = new FileInputStream(file);
                bloomFilter = BloomFilter.readFrom(fileInputStream, Funnels.stringFunnel(Charset.defaultCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bloomFilter;
    }

    //把布隆过滤器的储存到硬盘(持久化操作,也可以放数据库) fileName:持久化的文件名,这里是相对路径,就在本项目下
    public static void write(String fileName) {
        try {
            bloomFilter.writeTo(new FileOutputStream(new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

