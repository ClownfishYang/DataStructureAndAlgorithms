package io.clownfishyang.datastructure;

import io.clownfishyang.util.Compare;

import java.util.Queue;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 优先级队列<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 10:54<br>
 */
public interface PriorityQueue<E extends Comparable<E>> extends Queue<E>, Compare<E> {

    /**
     * 功能描述:
     * <p>
     * 删除优先级最高元素，若存在多个，则全部删除。
     *
     * @return 删除元素
     * @auther ClownfishYang
     * created on 2019-11-25 17:46:58
     */
    E removeHigh();

    /**
     * 功能描述:
     * <p>
     * 删除优先级最低元素，若存在多个，则全部删除。
     *
     * @return 删除元素
     * @auther ClownfishYang
     * created on 2019-11-25 17:46:58
     */
    E removeLow();

    /**
     * 功能描述:
     * <p>
     * 检索优先级最高元素，若存在多个，则返回其中一个。
     *
     * @return 优先级最高元素
     * @auther ClownfishYang
     * created on 2019-11-25 17:47:55
     */
    E elementHigh();

    /**
     * 功能描述:
     * <p>
     * 检索优先级最低元素，若存在多个，则返回其中一个。
     *
     * @return 优先级最高元素
     * @auther ClownfishYang
     * created on 2019-11-25 17:47:55
     */
    E elementLow();
}
