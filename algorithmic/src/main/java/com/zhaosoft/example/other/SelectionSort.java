package com.zhaosoft.example.other;
/**  
 *     
 * @author xiaoleizhao  
 * @date 2018/12/12 20:13
 */
public class SelectionSort {
    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]){
                    //将最小数的索引保存
                    minIndex = j;
                }

            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
