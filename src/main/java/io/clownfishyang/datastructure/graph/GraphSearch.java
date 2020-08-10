package io.clownfishyang.datastructure.graph;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/2 9:33<br>
 */
public interface GraphSearch {

    boolean marked(int v);

    int count();
}
