package io.clownfishyang.sort;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 冒泡排序<br>
 *
 * 与选择排序{@code SelectSort} 思想类似，通过依次比较相邻两个元素，将小的元素放在前面，大的元素放在后面，
 * 那么每一次循环最小、最大元素都会在数组两端。<br>
 * 跟选择排序{@code SelectSort}相比，比较次数相等，但交换次数更多,可以通过设定flag 当数组已经有序时不再进行排序<br>
 * @author ClownfishYang<br>
 * created on 2019/11/25 15:13<br>
 */
public class BubbleSort extends AbstractSort{

    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
//        basicSort(data, low, high);
        cocktailSort(data, low, high);
    }

    private void basicSort(Comparable[] data, int low, int high) {
        boolean changeFlag;
        for (int i = low; i < high; i++) {
            changeFlag = false;
            for (int j = i + 1; j < high; j++) {
                if (less(data[j], data[i])) {
                    exchange(data, i, j);
                    changeFlag = true;
                }
            }
            // 内循环已经有序，说明数组已经有序
            if (!changeFlag)
                break;
        }
    }

    /**
     *
     * 功能描述:
     * 鸡尾酒排序<br>
     *
     * 基础冒泡排序，只是单向的排序，存在优化空间；<br>
     * 鸡尾酒排序，先从低到高，再从高到低来回进行排序，每次循环过程最小、最大元素都会在数组两端<br>
     * @auther ClownfishYang
     * created on 2019-11-25 15:55:29
     */
    private void cocktailSort(Comparable[] data, int low, int high) {
        for (int left = low, right = high - 1; left < right;) {
            for (int i = left; i < right; i++) {
                if (less(data[i+1], data[i]))
                    exchange(data, i+1, i);
            }
            left ++;
            for (int i = right; i > low; i--) {
                if (less(data[i], data[i-1]))
                    exchange(data, i, i - 1);
            }
            right --;
        }
    }
}
