package io.clownfishyang.sort;

import io.clownfishyang.datastructure.Heap;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 堆排序<br>
 * <p>
 * 根据堆的特性，是一个完全二叉树，堆中每个节点都大于或等于子节点。<br>
 * 排序过程：<br>
 * 1、堆的构造，需要2N 次的比较；<br>
 * 2、堆的下沉排序，需要2N * lgN 次比较；<br>
 * 相对于快速排序{@code QuickSort}：
 * 1、由于堆排序需要进行堆化过程，这会打乱数据原有的相对先后顺序（有序度和逆序度），即经过堆化的过程，可能会让原本有序的数组变得无序；<br>
 * 2、其他排序数据访问方式都是通过局部顺序访问，而堆排序是跳跃式访问，这种方式对于CPU 缓存不友好；<br>
 * 3、虽然两种排序算法的时间复杂度都是O(N*logN)，且堆排序(O(N*logN))的比快速排序(O(N*N))更加稳定，但由于上面的原因，实际开发比较少选用堆排序；
 * @author ClownfishYang<br>
 * created on 2019/11/29 10:22<br>
 */
public class HeapSort<E extends Comparable<E>> extends AbstractSort<E> implements Heap<E> {

    @Override
    public void sortImpl(E[] data, int low, int high) {
        int N = data.length - 1;
        // 堆有序，但是root 节点为最大值
        heapify(data, N);
        // 从N 开始（最后一个叶子节点）从后往前依次跟root 节点替换，并使长度-1
        // 因为root 节点每次都是堆中的最大值
        while (N > 0) {
            exchange(data, 0, N--);
            sink(data, 0, N);
        }
    }

    /**
     * 功能描述:
     * 将数组进行调整，满足堆的特性，称为heapify（堆化）<br>
     * 堆化分为两种：
     * 1、从下往上：依次调用{@code sink} 方法构造子堆，递归地建立起堆的秩序；
     * 2、从上往下：依次调用{@code swim} 方法
     *
     * @auther ClownfishYang
     * created on 2019-11-29 15:32:22
     */
    private void heapify(E[] data, int N) {
        for (int k = N >> 1; k >= 0; k--)
            sink(data, k, N);
        /*for (int i = 0; i <= N; i++) {
            swim(data, i, N);
        }*/
    }
}
