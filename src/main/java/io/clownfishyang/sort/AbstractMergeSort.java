package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 归并排序抽象类<br>
 *
 * 要将一个数组排序，可以先将数组分组分别排序，然后将结果归并起来。<br>
 * 能够保证任意长度为 N 的数组排序所需时间和 N logN 成正比，但是所需的额外空间和N 成正比。<br>
 * 优化方案：<br>
 * 1、直接将辅助数组 {@code aux} 作为参数参数；<br>
 * 2、对小规模数组使用插入排序{@link InsertionSort};<br>
 * 3、判断数组是否已经有序，跳过{@code merge} 方法；<br>
 * 4、将{@code merge} 方法复制 mid - high 时倒序，可节省复制条件1、2 的判断；<br>
 * 5、{@code merge} 方法不将元素复制到辅助数组 {@code aux}，节省数组复制的时间；<br>
 * 调用两个排序方法，一种是将数据从输入数组 {@code data}排序到辅助数组 {@code aux}，
 * 另一种是将数据从辅助数组 {@code aux}排序到输入数组 {@code data}，
 * 需要在每个层次交换辅助数组 {@code aux}排序到输入数组 {@code data} 的角色。
 * @author ClownfishYang<br>
 * created on 2019/11/5 17:02<br>
 */
public abstract class AbstractMergeSort extends AbstractSort{


    public void merge(Comparable[] data, Comparable[] aux, int low, int mid, int high) {
        // 1、左边取完，取右边元素
        // 2、右边取完，取左边元素
        // 3、若右边 j 元素 < 左边 i 元素，取右边 j 元素
        // 4、若右边 j 元素 >= 左边 i 元素，取左边 i 元素
        for (int k = low, i = low, j = mid + 1; k <= high; k++) {
            if (i > mid) {
                data[k] = aux[j++];
            } else if (j > high) {
                data[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                data[k] = aux[j++];
            } else {
                data[k] = aux[i++];
            }
        }
    }

    public void copyMerge(Comparable[] data, Comparable[] aux, int low, int mid, int high) {
        // mid - high: 倒序
        for (int k = low; k <= high; k++) {
            if (k > mid) {
                aux[k] = data[high - k + mid + 1];
            } else {
                aux[k] = data[k];
            }
            addExchangeCount();
        }
        // 3、若右边 j 元素 < 左边 i 元素，取右边 j 元素
        // 4、若右边 j 元素 >= 左边 i 元素，取左边 i 元素
        for (int k = low, i = low, j = high; k <= high; k++) {
            if (less(aux[j], aux[i])) {
                data[k] = aux[j--];
            } else {
                data[k] = aux[i++];
            }
            addExchangeCount();
        }
    }

}
