package io.clownfishyang.datastructure;

import java.util.Collection;
import java.util.Iterator;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 堆接口<br>
 * <p>
 * 在二叉堆中，节点k 的子节点位置取决于root 节点的位置，<br>
 * 当root idx = 0 时，子节点为2k+1 和2k+2;<br>
 * 当root idx = 1 时，子节点为2k 和2k+1;<br>
 * 当root idx = 2 时，子节点为2k-1 和2k;<br>
 * 即子节点为2k-(root idx - 1) 和2k-(root idx - 2)，
 * 而父节点为子节点(idx+(root idx - 1)) / 2（按照左边子节点计算公式反推即可，右边子节点结果商相等，余数为1）；<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 10:55<br>
 */
public interface Heap<E extends Comparable<E>> {

    boolean less(E a, E b);

    void exchange(E[] data, int i, int j);

    /**
     * 功能描述:
     * <p>
     * 上浮<br>
     * <p>
     * 如果堆的有序状态因为k 节点比其父节点更大而被打破，那么就需要其和父节点交换来修复。
     * 交换完成之后，k 节点 > 两个子节点（一个是曾经的父节点，一个是曾经父节点的子节点），
     * 但k 节点可能比现在的父节点还要大，这需要轮询到父节点比其大或者到root 节点。<br>
     *
     * @auther ClownfishYang
     * created on 2019-11-26 16:55:50
     */
    default void swim(E[] data, int k, int N) {
        while (k > 0) {
            int j = (k - 1) >> 1;
            if (j > 0 && less(data[j], data[k])) {
                exchange(data, j, k);
                k = j;
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
    default void sink(E[] data, int k, int N) {
        while ((k << 1) + 1 <= N) {
            int j = (k << 1) + 1;
            if (j < N && less(data[j], data[j + 1])) j++;
            if (!less(data[k], data[j])) break;
            exchange(data, k, j);
            k = j;
        }
    }

}
