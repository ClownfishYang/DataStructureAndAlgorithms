package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 自顶向下归并排序<br>
 *
 * 通过 二分数组-递归 的方式进行归并排序，分治思想。<br>
 * 以树状图的方式表示，每个节点表示一个sort 方法通过merge 方法归并而成的子数组<br>
 * 树的高度为 n 层，对于 0 ~ n-1 之间的任意k，自顶向下的第 k 层有 2^k 个子数组，数组长度为 2^n-k，最多需要 2^n-k 次比较。<br>
 * 因此每层的比较次数为 2^k * 2^n-k = 2^n，总共 n 层为 n * 2^n = NlgN。
 * @author ClownfishYang<br>
 * created on 2019/11/5 18:11<br>
 */
public class TopDownSort extends AbstractMergeSort {

    private final int LOW_LIMIT;
    private final AbstractSort selectSort = new SelectSort();
    private final AbstractSort insertSort = new InsertionSort();

    public TopDownSort() {
        this.LOW_LIMIT = 15;
    }

    public TopDownSort(int lowLimit) {
        this.LOW_LIMIT = lowLimit;
    }

    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
//        Comparable[] aux = new Comparable[data.length];
//        basicSort(data, aux, low, high - 1);
//        embedSelectSort(data, low, high - 1);
//        embedInsertSort(data, aux, low, high - 1);

        Comparable[] aux = data.clone();
        exchangeParamSort(data, aux, low, high);
    }

    private void exchangeParamSort(Comparable[] data, Comparable[] aux, int low, int high) {
        if ((high - low) < this.LOW_LIMIT) {
            this.insertSort.sort(data, low, high + 1);
            addComparableCount(this.insertSort.comparableCount());
            addExchangeCount(this.insertSort.exchangeCount());
            return;
        }
        int mid = low + high >>> 1;
        exchangeParamSort(aux, data, low, mid);
        exchangeParamSort(aux, data, mid + 1, high);
        // 由于递归时aux - data 角色互换，此时aux 为输入的data，data 为输入的辅助数组，
        // 所以当aux mid + 1 >= mid 时，说明aux 已排序完成，将其copy 到data
        // mid + 1 >= mid, aux copy to data
        if (!less(aux[mid + 1], aux[mid])) {
            System.arraycopy(aux, low, data, low, high - low + 1);
            return ;
        }
        merge(data, aux, low, mid, high);
    }

    private void embedSelectSort(Comparable[] data, Comparable[] aux, int low, int high) {
        basicSort(data, aux, low, high, this.LOW_LIMIT, selectSort);
    }

    private void embedInsertSort(Comparable[] data, Comparable[] aux, int low, int high) {
        basicSort(data, aux, low, high, this.LOW_LIMIT, insertSort);
    }

    private void basicSort(Comparable[] data, Comparable[] aux, int low, int high) {
        basicSort(data, aux, low, high, 0, null);
    }

    private void basicSort(Comparable[] data, Comparable[] aux, int low, int high, int lowLimit, AbstractSort sort) {
        if (high <= low) return;
        if ((high - low) < lowLimit) {
            sort.sort(data, low, high + 1);
            addComparableCount(sort.comparableCount());
            addExchangeCount(sort.exchangeCount());
            return;
        }
        int mid = low + high >>> 1;
        basicSort(data, aux, low, mid, lowLimit, sort);
        basicSort(data, aux, mid + 1, high, lowLimit, sort);
        if (!less(data[mid], data[mid + 1])) {
            copyMerge(data, aux, low, mid, high);
        }
    }


}
