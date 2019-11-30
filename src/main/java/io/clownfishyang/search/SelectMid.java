package io.clownfishyang.search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 选择中位数<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/29 17:30<br>
 */
public class SelectMid<E extends Comparable<E>> extends AbstractSelect<E> {
    @Override
    public E[] selectImpl(E[] data, int low, int high) {
        E e = basicSelect(data, low, high, (high - low) >> 1);
        E[] res = (E[]) Array.newInstance(data.getClass().getComponentType(), 1);
        res[0] = e;
        return res;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 4, 1, 5, 10, 2};
        SelectMid<Integer> selectMid = new SelectMid<>();
        Integer[] select = selectMid.select(a, 0, a.length);
        System.out.println(Arrays.toString(select));
    }

    private E basicSelect(E[] data, int low, int high, int k) {
        int left = low, right = high - 1;
        while (left < high) {
            int j = partition(data, left, right);
            if (j == k) return data[k];
            else if (j < k) left = j + 1;
            else right = j - 1;
        }
        return data[k];
    }

    private int partition(E[] data, int low, int high) {
        E v = data[low];
        int left = low, right = high + 1;
        while (true) {
            while (!less(v, data[++left])) if (left == high) break;
            while (!less(data[--right], v)) if (right == low) break;
            if (left >= right) break;
            exchange(data, left, right);
        }
        exchange(data, left, low);
        return left;
    }
}
