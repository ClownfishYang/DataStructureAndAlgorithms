package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 希尔排序<br>
 *
 * 对于大规模乱序的数组，插入排序 {@code InsertionSort}很慢，因为它只会交换相邻的元素，假设 min 元素正好在数组的尽头，
 * 那么 min 元素就需要移动 N-1 次。<br>
 * 希尔排序简单的对插入排序 {@code InsertionSort} 进行了优化，通过交换不相邻的元素以对数据进行局部排序。
 * 使数组中任意间隔为 h 的元素都是有序的，称为 h 有序数组。<br>
 * 一个 h 有序数组就是 h 个互相独立的有序编织在一起组成的数组。<br>
 * @author ClownfishYang<br>
 * created on 2019/11/5 15:20<br>
 */
public class ShellSort extends AbstractSort {

    private final int FACTOR;

    public ShellSort() {
        this.FACTOR = 3;
    }

    public ShellSort(int FACTOR) {
        this.FACTOR = FACTOR;
    }

    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
        int h =  1;
        while (h < high/this.FACTOR) {
            h = this.FACTOR * h + 1;
        }
        while (h > 0) {
            int fromIdx = low + h;
            for (int i = fromIdx; i < high; i++) {
                for (int j = i; j >= fromIdx && (less(data[j], data[j - h])); j -= h) {
                    exchange(data, j, j - h);
                }
            }
            h /= this.FACTOR;
        }
    }
}
