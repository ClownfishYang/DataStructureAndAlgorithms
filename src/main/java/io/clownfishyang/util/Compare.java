package io.clownfishyang.util;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 比较接口<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/26 17:59<br>
 */
public interface Compare<E extends Comparable<E>> {

    void addComparableCount();
    void addExchangeCount();

    default int compare(E a, E b) {
        addComparableCount();
        return a.compareTo(b);
    }

    /**
     *
     * 功能描述:
     *
     * 小于判断，a < b 返回true
     * @auther ClownfishYang
     * created on 2019-11-04 14:50:45
     */
    default boolean less(E a, E b) {
        addComparableCount();
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
    default boolean greater(E a, E b) {
        addComparableCount();
        return a.compareTo(b) > 0;
    }

    /**
     *
     * 功能描述:
     *
     * 元素交换
     * @auther ClownfishYang
     * created on 2019-11-26 18:04:23
     */
    default void exchange(E[] data, int i, int j) {
        if (i != j) {
            addExchangeCount();
            E e = data[i];
            data[i] = data[j];
            data[j] = e;
        }
    }

}
