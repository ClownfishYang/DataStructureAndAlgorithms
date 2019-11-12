package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 插入排序<br>
 *
 * 与选择排序 {@code SelectSort} 相同，当前索引左边的所有元素都是有序的，但最终位置不确定。<br>
 * 插入排序所需的时间取决于元素的初始顺序, 每次将当前索引元素与索引之前的所有元素进行比较。
 * 比较次数/交换次数：N-1/0 ~ (N * N / 2);
 * 交换次数与倒置元素数量相同，比较次数大于等于倒置元素的数量。
 * @author ClownfishYang<br>
 * created on 2019/11/4 17:01<br>
 */
public class InsertionSort extends AbstractSort {

    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
//        basicSort(data, low, high);
//        moveSort(data, low, high);
        binarySearchSort(data, low, high);
    }

    private void basicSort(Comparable[] data, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            for (int j = i; j > 0 && less(data[j], data[j - 1]); j--) {
                exchange(data, j, j - 1);
            }
        }
    }

    /**
     *
     * 功能描述:
     *
     * 移动插入排序，减少交换次数。
     * @auther ClownfishYang
     * created on 2019-11-05 11:11:28
     */
    private void moveSort(Comparable[] data, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            Comparable d = data[i];
            int j = i;
            for (; j > 0 && less(d, data[j - 1]); j--) {
                data[j] = data[j - 1];
                addExchangeCount();
            }
            data[j] = d;
            addExchangeCount();
        }
    }

    /**
     *
     * 功能描述:
     *
     * 移动插入排序 + 二分查找，减少交换次数以及比较次数。
     * @auther ClownfishYang
     * created on 2019-11-05 11:11:28
     */
    private void binarySearchSort(Comparable[] data, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            Comparable d = data[i];

            int l = low;
            int h = i - 1;
            while (l <= h) {
                int mid = (l + h) >>> 1;
                if (less(d, data[mid])) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (i != l) {
                for (int j = i; j > l; j--) {
                    data[j] = data[j - 1];
                    addExchangeCount();
                }
                data[l] = d;
                addExchangeCount();
            }
        }
    }



}
