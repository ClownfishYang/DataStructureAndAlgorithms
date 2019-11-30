package io.clownfishyang.datastructure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 优先级队列接口实现类<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/25 17:49<br>
 */
public class PriorityQueueImpl<E extends Comparable<E>> implements PriorityQueue<E> {

    /**
     * 二叉堆数组，存储不使用索引位0，从1 开始
     * 若索引位从0 开始，则两个子节点的位置为2k+1 和2k+2。
     */
    private E[] pq;
    /**
     * 二叉堆偏移量
     */
    private int N = 0;

    public PriorityQueueImpl(int size) {
        this.pq = (E[])new Comparable[size + 1];
    }

    private boolean less(int i, int j) {
        return less(pq[i], pq[j]);
    }

    /**
     * 在二叉堆中，位置k 的节点的父节点的位置为k/2，而它的两个子节点的位置为2k 和2k+1。
     * 功能描述:
     * <p>
     * 上浮<br>
     * 如果堆的有序状态因为k 节点比其父节点更大而被打破，那么就需要其和父节点交换来修复。
     * 交换完成之后，k 节点 > 两个子节点（一个是曾经的父节点，一个是曾经父节点的子节点），
     * 但k 节点可能比现在的父节点还要大，这需要轮询到父节点比其大或者到root 节点。<br>
     *
     * @auther ClownfishYang
     * created on 2019-11-26 16:55:50
     */
    private void swim(int k) {
        while (k > 1) {
            int j = k >> 1;
            if (j > 0 && less(j, k)) {
                exchange(pq, j, k);
                k = k >> 1;
            } else {
                break;
            }
        }
    }

    /**
     * 功能描述:
     * 下沉<br>
     * <p>
     * 如果堆的有序状态因为k 节点比其子节点中更小而被打破，那么就需要其和子节点中较大的节点交换来修复。
     * 但k 节点可能还是比其子父节点更小，这需要轮询到子节点都比其小或者到堆的底部。<br>
     *
     * @auther ClownfishYang
     * created on 2019-11-26 17:35:29
     */
    private void sink(int k) {
        while (k << 1 <= this.N) {
            int j = k << 1;
            if (j < this.N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(this.pq, k, j);
            k = j;
        }
    }


    /**
     * 功能描述:
     * <p>
     * 删除high 元素<br>
     * <p>
     * 删除high 元素，堆的有序性被打破，将它和low 元素交换并执行high 节点的sink。
     *
     * @auther ClownfishYang
     * created on 2019-11-26 17:47:44
     */
    @Override
    public E removeHigh() {
        E high = this.pq[1];
        exchange(this.pq, 1, this.N--);
        sink(1);
        return high;
    }

    @Override
    public E removeLow() {
        return null;
    }

    @Override
    public E elementHigh() {
        return this.pq[1];
    }

    @Override
    public E elementLow() {
        return null;
    }

    @Override
    public int size() {
        return this.N;
    }

    @Override
    public boolean isEmpty() {
        return this.N == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * 功能描述:
     * 插入元素<br>
     * <p>
     * 将新元素添加到堆的末端，增加堆的大小并执行新元素的swim。
     *
     * @auther ClownfishYang
     * created on 2019-11-26 17:51:41
     */
    @Override
    public boolean add(E e) {
        this.pq[++this.N] = e;
        swim(this.N);
        System.out.println(Arrays.toString(pq));
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }


    @Override
    public void addComparableCount() {

    }

    @Override
    public void addExchangeCount() {

    }
}
