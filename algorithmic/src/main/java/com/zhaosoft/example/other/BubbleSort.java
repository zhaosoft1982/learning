package com.zhaosoft.example.other;

/**
 * ð������
 * ��������T(n) = O(n) ��������T(n) = O(n2) ƽ�������T(n) = O(n2)
 * @author xiaoleizhao
 * @date 2018/12/12 19:56
 */
public class BubbleSort {
    /**
     * ð������
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
