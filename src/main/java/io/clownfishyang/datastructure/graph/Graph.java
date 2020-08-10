package io.clownfishyang.datastructure.graph;

import java.util.Optional;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/1 10:13<br>
 */
public interface Graph {

    /**
     *
     * 功能描述:
     *
     * 所有顶点
     * @auther ClownfishYang
     * created on 2019-12-01 10:15:06
     */
    int V();

    /**
     *
     * 功能描述:
     *
     * 所有边
     * @auther ClownfishYang
     * created on 2019-12-01 10:15:25
     */
    int E();

    /**
     *
     * 功能描述:
     *
     * 添加边
     * @auther ClownfishYang
     * created on 2019-12-01 10:15:42
     */
    void addEdge(int v, int w);

    /**
     *
     * 功能描述:
     *
     * 所有领边
     * @auther ClownfishYang
     * created on 2019-12-01 10:15:55
     */
    Iterable<Integer> adjacentE(int v);

    /**
     *
     * 功能描述:
     *
     * 所有领点
     * @auther ClownfishYang
     * created on 2019-12-01 10:15:55
     */
    Iterable<Integer> adjacentV(int v);

}
