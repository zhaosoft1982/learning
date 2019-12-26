package com.zhaosoft.example.other;

/**
 * @author mengnanshi2
 * @title: CompareExchangeQuick
 * @description: 快速排序
 * @date 2019/12/912:56
 */
public class CompareExchangeQuick {
    /**
     * 快排
     * 时间复杂度(平均) O(nlogn)
     * 时间复杂度(最坏) O(n^2)
     * 时间复杂度(最好) O(nlogn)
     * 空间复杂度O(nlogn) 堆栈深度
     * 稳定性:不稳定
     * 解析:找到一个元素节点,将数组分为左半部分 与 右半部分. [left,position] [position,right]
     * 使左半部分的值都小于position 元素,右半部分的值都大于position 元素.并递归重复这一过程
     *
     * @param arr
     * @return
     */
    public void quickSort(int arr[], int left, int right) {
        if (left < right) {
            //获取分界值--position 节点位置已经正确
            int position = getPosition(arr, left, right);
            //递归调用 左区间排序
            quickSort(arr, left, position - 1);
            //递归调用 右区间排序
            quickSort(arr, position + 1, right);
        }
    }

    /**
     * 获取position 分割位置
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int getPosition(int[] arr, int left, int right) {
        /**
         * 3 5 4 1 2 tarVal = 3 i=1 index=1     3 5 4 1 2
         * 3 5 4 1 2 tarVal = 3 i=2 index=1     3 5 4 1 2
         * 3 5 4 1 2 tarVal = 3 i=3 index=1     3 1 4 5 2   swap  index++
         * 3 1 4 5 2 tarVal = 3 i=4 index=2     3 1 2 5 4   swap  index++
         * index = 3 目标位置 index-1=2 swap(0,2)
         * 2 1 3 5 4
         */
        //目标位置
        int tarVal = arr[left];
        //当前比较元素起始位置-- 用于记录大于 tarVal元素的开始下标,用于 与 小于 tarVal 元素 下标的记录交换
        int index = left+1;
        for (int i = index; i <= right; i++) {
            //如果目标值 比当前值大 需要交换i,index,将小值 与 大值交换位置
            if (tarVal > arr[i]) {
                SortUtil.swap(arr,i,index);
                index++;
            }
        }
        //index-1 为最终位置
        SortUtil.swap(arr, left, index-1);
        return index-1;
    }
}
