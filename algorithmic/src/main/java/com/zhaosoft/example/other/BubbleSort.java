package com.zhaosoft.example.other;

/**
 * 冒泡排序
 * 最佳情况：T(n) = O(n) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 * @author xiaoleizhao
 * @date 2018/12/12 19:56
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
