package io.clownfishyang.sort;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 17:02<br>
 */
public abstract class AbstractSort implements Sort{

    private int comparableCount;
    private int exchangeCount;
    private long timeMillis;

    public void addComparableCount() {
        this.comparableCount++;
    }

    public void addComparableCount(int comparableCount) {
        this.comparableCount += comparableCount;
    }

    public int comparableCount() {
        return this.comparableCount;
    }

    public void addExchangeCount() {
        this.exchangeCount++;
    }

    public void addExchangeCount(int exchangeCount) {
        this.exchangeCount += exchangeCount;
    }

    public int exchangeCount() {
        return this.exchangeCount;
    }

    public long sortTimeMillis() {
        return this.timeMillis;
    }

    @Override
    public void sort(Comparable[] data, int low, int high) {
        long s = System.currentTimeMillis();
        sortImpl(data, low, high);
        this.timeMillis = System.currentTimeMillis() - s;
    }

    /**
     *
     * 功能描述:
     *
     * 排序方法的具体实现
     * @auther ClownfishYang
     * created on 2019-11-05 11:50:58
     */
    public abstract void sortImpl(Comparable[] data, int low, int high);

    @Override
    public int compare(Comparable a, Comparable b) {
        addComparableCount();
        return a.compareTo(b);
    }

    @Override
    public boolean less(Comparable a, Comparable b) {
        addComparableCount();
        return a.compareTo(b) < 0;
    }

    @Override
    public boolean greater(Comparable a, Comparable b) {
        addComparableCount();
        return a.compareTo(b) > 0;
    }

    @Override
    public void exchange(Comparable[] data, int i, int j) {
        if (i != j) {
            Comparable d = data[i];
            data[i] = data[j];
            data[j] = d;
            addExchangeCount();
        }
    }

    /**
     *
     * 功能描述:
     *
     * 二分查找元素
     * @param data 数组
     * @param fromIndex 查找起始位
     * @param toIndex 查找结束位（不包括）
     * @param key 查找元素
     * @return 查找元素的index，不存在则返回-1
     * @auther ClownfishYang
     * created on 2019-11-05 11:42:36
     */
    public int binarySearch(Comparable[] data, int fromIndex, int toIndex, Comparable key) {
        rangeCheck(data.length, fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = data[mid].compareTo(key);
            addComparableCount();

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }
}
