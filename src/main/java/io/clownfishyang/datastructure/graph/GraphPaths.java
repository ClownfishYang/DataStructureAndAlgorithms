package io.clownfishyang.datastructure.graph;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/3 17:01<br>
 */
public interface GraphPaths {

    /**
     *
     * 功能描述:
     *
     * 是否存在从s 到v 的路径
     * @param v 顶点v
     * @return
     * @auther ClownfishYang
     * created on 2019-12-03 17:02:31
     */
    boolean hasPathTo(int v);

    /**
     *
     * 功能描述:
     *
     * 从s 到v 的路径
     * @param v 顶点v
     * @return 路径
     * @auther ClownfishYang
     * created on 2019-12-03 17:03:46
     */
    Iterable<Integer> pathTo(int v);

}
