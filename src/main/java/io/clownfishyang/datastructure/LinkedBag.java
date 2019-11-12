package io.clownfishyang.datastructure;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 背包，一种不支持从中删除元素的集合数据类型<br>
 * 目的是帮助用户手机元素并迭代所有收集到的元素
 * @author ClownfishYang<br>
 * created on 2019/11/4 10:52<br>
 */
public class LinkedBag<Item> implements Bag<Item> {

    private int size = 0;
    private Node<Item> first;

    @Override
    public boolean add(Item item) {
        Node<Item> newNode = new Node<>(item, this.first);
        this.first = newNode;
        size ++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] var1 = new Object[this.size];
        int var2 = 0;
        for(LinkedBag.Node var3 = this.first; var3 != null; var3 = var3.next) {
            var1[var2++] = var3.item;
        }

        return var1;
    }

    @Override
    public <T> T[] toArray(T[] var1) {
        if (var1.length < this.size) {
            var1 = (T[]) Array.newInstance(var1.getClass().getComponentType(), this.size);
        }

        int var2 = 0;
        for (LinkedBag.Node var3 = this.first; var3 != null; var3 = var3.next) {
            var1[var2++] = (T)var3.item;
        }
        return var1;
    }

    private class BagIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = this.current.item;
            this.current = this.current.next;
            return item;
        }
    }

    private class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

}
