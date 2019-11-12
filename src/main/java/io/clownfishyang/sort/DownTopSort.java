package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 自底向上归并排序<br>
 *
 * 实际上归并 {@code TopDownSort} 排序的数组大多数都非常小，
 * 这就需要非常多的 merge 操作，虽然可以通过嵌入其他初级排序算法 {@code SelectSort、InsertionSort...} 来进行优化，但是依旧存在很多 merge 操作。
 * 此时可以先归并这些小数组，然后再对归并得到的子数组，这种方式比标准的归并排序 {@code TopDownSort} 代码量更少。
 * @author ClownfishYang<br>
 * created on 2019/11/6 11:11<br>
 */
public class DownTopSort extends AbstractMergeSort {



    @Override
    public void sortImpl(Comparable[] data, int low, int high) {
        Comparable[] aux = new Comparable[data.length];
        basicSort(data, aux, low, high);
    }

    private void basicSort(Comparable[] data, Comparable[] aux, int low, int high) {
        // sz : 1, 2, 4, 8 ...
        for (int sz = 1; sz < high; sz = sz << 1) {
            for (int i = low; i < high - sz; i += (sz << 1)) {
                int mid = i + sz - 1;
                merge(data, aux, i, mid, Math.min(mid + sz, high - 1));
            }
        }
    }

}
