package io.clownfishyang.sort;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 排序接口类
 * @author ClownfishYang<br>
 * created on 2019/11/4 14:41<br>
 */
public interface Sort {

    /**
     *
     * 功能描述:
     *
     * 排序实现方法
     * @auther ClownfishYang
     * created on 2019-11-04 15:47:22
     */
    default void sort(Comparable[] data) {
        sort(data, 0, data.length);
    }

    /**
     *
     * 功能描述:
     *
     * 排序实现方法
     * @auther ClownfishYang
     * created on 2019-11-04 15:47:22
     */
    void sort(Comparable[] data, int low, int high);

    /**
     *
     * 功能描述:
     *
     * 小于判断，a < b 返回true
     * @auther ClownfishYang
     * created on 2019-11-04 14:50:45
     */
    default boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     *
     * 功能描述:
     *
     * 大于判断，a > b 返回true
     * @auther ClownfishYang
     * created on 2019-11-04 14:50:45
     */
    default boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    default void exchange(Comparable[] data, int i, int j) {
        if (i != j) {
            Comparable d = data[i];
            data[i] = data[j];
            data[j] = d;
        }
    }

    default boolean isSorted(Comparable[] data) {
        return isSorted(data, 0, data.length);
    }

    default boolean isSorted(Comparable[] data, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            if (less(data[i], data[i - 1]))
                return false;
        }
        return true;
    }
}
