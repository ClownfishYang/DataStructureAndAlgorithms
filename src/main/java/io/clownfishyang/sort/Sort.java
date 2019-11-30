package io.clownfishyang.sort;

import io.clownfishyang.util.Compare;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 排序接口类
 * @author ClownfishYang<br>
 * created on 2019/11/4 14:41<br>
 */
public interface Sort<E extends Comparable<E>> extends Compare<E> {

    /**
     *
     * 功能描述:
     *
     * 排序实现方法
     * @auther ClownfishYang
     * created on 2019-11-04 15:47:22
     */
    default void sort(E[] data) {
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
    void sort(E[] data, int low, int high);

    default boolean isSorted(E[] data) {
        return isSorted(data, 0, data.length);
    }

    default boolean isSorted(E[] data, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            if (less(data[i], data[i - 1]))
                return false;
        }
        return true;
    }
}
