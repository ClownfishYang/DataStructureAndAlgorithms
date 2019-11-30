package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 快速排序<br>
 * <p>
 * 快速排序也是一种分治算法，将数组分为两个子数组，将两部分独立地排序。<br>
 * 与归并排序不同{@link AbstractMergeSort}，归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使整个数组有序。<br>
 * 而快速排序则是将数组分为 N 个子数组（取决于 partition 的个数），当子数组都有序时，整个数组自然就有序了。<br>
 * 排序的效率最终依赖于切分数组的效果，而这依赖于切分元素的值。
 * 最好的情况是每次都正好能将数组对半平分，此时正好满足分治递归的CN = 2C(N/2) + N 公式。
 *
 * @author ClownfishYang<br>
 * created on 2019/11/12 17:06<br>
 */
public class QuickSort extends AbstractSort {
    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
        basicSort(data, low, high - 1);
//        embedInsertSort(data, low, high, 3, new InsertionSort());
//        threeSamplingSplitSort(data, low, high - 1);
//        threeWaySort(data, low, high - 1);
    }

    /**
     * 功能描述:
     * <p>
     * 三向切分排序（熵最优排序），当含有大量重复元素的数组，将当前实现的线性对数级的性能提高到线性级别<br>
     * 当一个元素全部重复的子数组就不需要继续排序了，但原有算法还会继续切分为更小的数组。<br>
     * 操作情况：<br>
     * i < v, lt 和 i 交换，将lt 和i 加一；<br>
     * i > v, gt 和 i 交换，将gt 减一，这里i 不减一的目的是为了再次进行元素的比较，有可能从gt 交换的元素依旧大于 v；<br>
     * i == v, i 加一；<br>
     * 每次循环完成都能达到(low ~ lt - 1) < v = (lt ~ gt) < (gt + 1 ~ high)，除非和切换元素v 相等，其他元素都会被交换；<br>
     * 准确的结论来自于对主键概率分布的分析，给定包含k 个不同值的N 个主键，对于从1 到k 的每个i，定义fi 为第i 个主键值出现的次数；
     * pi 为fi / N，即随机抽取一个数组元素是第i 个主键值出现的概率。所有主键的香农信息量为：
     * H = -(p1 * lg(p1) + p2 * lg(p2) + ... + pk * lg(pk))
     *
     * @auther ClownfishYang
     * created on 2019-11-25 12:19:00
     */
    private void threeWaySort(Comparable[] data, int low, int high) {
        if (high <= low) return;
        int lt = low, i = lt + 1, gt = high;
        Comparable v = data[low];
        // (low ~ lt - 1) < v = (lt ~ gt) < (gt + 1 ~ high)
        while (i <= gt) {
            int compare = compare(data[i], v);
            if (compare < 0) exchange(data, lt++, i++);
            else if (compare > 0) exchange(data, i, gt--);
            else i++;
        }
        threeWaySort(data, low, lt - 1);
        threeWaySort(data, gt + 1, high);
    }

    /**
     * 功能描述:
     * <p>
     * 大多数递归排序算法对于小数组的排序速度比插入排序慢{@code InsertionSort}
     *
     * @param data
     * @param low
     * @param high
     * @param M             小数组限制值
     * @param insertionSort 插入排序实现类
     * @return
     * @auther ClownfishYang
     * created on 2019-11-21 15:38:05
     */
    private void embedInsertSort(Comparable[] data, int low, int high, int M, InsertionSort insertionSort) {
        if (high <= low) return;
        if (high < low + M) {
            insertionSort.sort(data, low, high + 1);
            return;
        }
        int j = partition(data, low, high);
        embedInsertSort(data, low, j - 1, M, insertionSort);
        embedInsertSort(data, j + 1, high, M, insertionSort);
    }

    /**
     * 功能描述:
     * <p>
     * 三取样切分，使用子数组的一小部分元素的中位数来切分数组，代价是需要计算中位数。<br>
     * 将取样数设为3，并取low、high、mid 的元素中的中位数作为枢纽值效果最好，并将该元素移动至high-1 位，以该元素进行划分。<br>
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2019-11-21 15:43:06
     */
    private void threeSamplingSplitSort(Comparable[] data, int low, int high) {
        if (high <= low) return;
        threeSampling(data, low, high);
        int i = low, j = high - 1, pivot = j;
        while (true) {
            // 左右开工扫描，左边大于、右边小于并交换元素
            while (i < pivot && less(data[++i], data[pivot])) {
            }
            ;
            while (j > low && less(data[pivot], data[--j])) {
            }
            ;
            if (i >= j) break;
            exchange(data, i, j);
        }
        // 因为i >= j
        if (i < pivot)
            exchange(data, i, pivot);
        threeSamplingSplitSort(data, low, i - 1);
        threeSamplingSplitSort(data, i + 1, high);
    }

    /**
     * 功能描述:
     * 三取样方法，取low、high、mid 的元素的中位数，并移动至high-1 位。
     *
     * @auther ClownfishYang
     * created on 2019-11-21 17:18:42
     */
    private void threeSampling(Comparable[] data, int low, int high) {
        int mid = (high + low) >> 1;
        // mid < low
        if (less(data[mid], data[low]))
            exchange(data, mid, low);
        // high < low
        if (less(data[high], data[low]))
            exchange(data, high, low);
        // high < mid
        if (less(data[high], data[mid]))
            exchange(data, high, mid);
        exchange(data, mid, high - 1);
    }

    private void basicSort(Comparable[] data, int low, int high) {
        if (high <= low) return;
        int j = partition(data, low, high);
        basicSort(data, low, j - 1);
        basicSort(data, j + 1, high);
    }

    /**
     * 功能描述:
     * 切分方法
     * <p>
     * 1、在数组中任意挑选一个索引为pivot （这里取low）的元素v；<br>
     * 2、以pivot 为中数调整数组，使得low ~ pivot-1 < pivot < pivot+1 ~ high;<br>
     *
     * @auther ClownfishYang
     * created on 2019-11-12 17:26:53
     */
    private int partition(Comparable[] data, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = data[low];
        while (true) {
            // 左右开工扫描，左边大于、右边小于并交换元素
            while (!less(v, data[++i])) if (i == high) break;
            while (!less(data[--j], v)) if (j == low) break;
            if (i >= j) break;
            exchange(data, i, j);
        }
        // 因为i >= j
        exchange(data, low, j);
        return j;
    }
}
