package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 选择排序<br>
 *
 * 最简单的排序算法：<br>
 *     1、找出数组中最小的元素；<br>
 *     2、与idx = 0 的元素交换位置；<br>
 *     3、在剩余的元素中找出最小的元素，与idx + 1 的元素交换位置；<br>
 *     4、重复 1-3，知道整个数组排序完成；<br>
 * 因为不断的选择剩余元素中的最小元素，所以称为选择排序。<br>
 * 运行时间与输入无关，数据移动最少。<br>
 * 比较次数：(1 + N）* (N / 2)，交换次数和数组的大小是线性关系。
 * @author ClownfishYang<br>
 * created on 2019/11/4 14:59<br>
 */
public class SelectSort extends AbstractSort {

    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
//        basicSort(data, low, high);
        bothEndSort(data, low, high);
    }

    private void basicSort(Comparable[] data, int low, int high) {
        for (int i = low; i < high; i++) {
            // 将a[i] 和 a[i+1 ... N]中最小元素交换位置
            int min = i;
            for (int j = i + 1; j < high; j++) {
                if (less(data[j], data[min]))
                    min = j;
            }
            exchange(data, i, min);
        }
    }

    /**
     *
     * 功能描述:
     *
     * 两端选择排序，从0 - N-1 选择出min、max 向中间排序。
     * @auther ClownfishYang
     * created on 2019-11-05 11:09:58
     */
    private void bothEndSort(Comparable[] data, int low, int high) {
        for (int left = low, right = high - 1; left <= right; left++, right--) {
            // 将a[left]/a[right] 和 a[left+1 ... right-1]中最小/最大元素交换位置
            int min = left;
            int max = right;
            for (int j = left; j <= right; j++) {
                if (less(data[j], data[min]))
                    min = j;
                if (less(data[max], data[j]))
                    max = j;
            }
            exchange(data, left, min);
            // left == max，由于是先排 min，所以原先指向left 的索引应该指向 min
            // 如果是先排 max，则应该考虑反过来
            if (left == max) {
                max = min;
            }
            exchange(data, right, max);
        }
    }
}
