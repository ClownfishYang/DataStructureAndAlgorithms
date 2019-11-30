package io.clownfishyang.search;

import io.clownfishyang.util.Compare;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 抽象选择类<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/29 17:24<br>
 */
public abstract class AbstractSelect<E extends Comparable<E>> implements Compare<E> {

    private int comparableCount;
    private int exchangeCount;
    private long timeMillis;

    @Override
    public void addComparableCount() {
        this.comparableCount++;
    }

    public void addComparableCount(int comparableCount) {
        this.comparableCount += comparableCount;
    }

    public int comparableCount() {
        return this.comparableCount;
    }

    @Override
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

    public E[] select(E[] data, int low, int high) {
        long s = System.currentTimeMillis();
        E[] res = selectImpl(data, low, high);
        this.timeMillis = System.currentTimeMillis() - s;
        return res;
    }

    abstract E[] selectImpl(E[] data, int low, int high);

}
