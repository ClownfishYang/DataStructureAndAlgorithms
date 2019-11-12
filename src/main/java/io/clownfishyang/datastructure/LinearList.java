package io.clownfishyang.datastructure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 线性表：n个类型相同数据元素的有限序列
 * 在数据元素的有限集中，除第一个元素无直接前驱，最后一个元素无直接后续以外，
 * 每个数据元素有且仅有一个直接前驱元素和一个直接后续元素。
 *
 * 记作：L = （a0, a1, …ai-1, ai, ai+1 …, an-1 ）。
 * 其中，L是表名，a0是第一个数据元素（也简称为元素），无前驱，有一个后继；
 * an-1是最后一个数据元素(即第n个数据元素)，有一个前驱，无后继。
 * 其余的每个数据元素ai (i=2,3, … ,n-1)
 * 都只有一个前驱，且只有一个后继。i (i=1,2, … ,n)称为表的序号。
 * n是数据元素的个数，也称为表的长度，若n=0，L称作空表。
 *
 * @author ClownfishYang<br>
 * created on 2019/10/24 15:44<br>
 */
public class LinearList<E> extends AbstractList<E>
        implements RandomAccess, Cloneable, java.io.Serializable{

    private int size = 0;
    private Object[] elementData;

    public LinearList(int capacity) {
        this.elementData = new Object[capacity];
    }

    @Override
    public void add(int index, E e) {
        elementData[index] = e;
        size++;
    }


    @Override
    public E get(int pos) {
        return (E)elementData[pos];
    }

    @Override
    public E remove(int pos) {
        Object oldValue = elementData[pos];
        elementData[pos] = null;
        size --;
        return (E)oldValue;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(i);
        }
    }


    public static void main(String[] args) {
        LinearList<String> linearList = new LinearList<String>(10);
        linearList.add(0, "a");
        linearList.add("b");
        linearList.add(2, "c");
        linearList.remove(2);
        linearList.add("c");
        System.out.println(linearList);
    }
}
