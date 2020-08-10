package io.clownfishyang.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 无向图<br>
 * <p>
 * 图最基本也是最简单的一种结构<br>
 * 图的数据结构要求：<br>
 * 1、占用空间要足够小，这使得可以应付各种类型的图；<br>
 * 2、实现图算法要足够块，这是处理图结构的基础；<br>
 * 表示形式：<br>
 * 1、邻接矩阵：使用V * V 的布尔矩阵，实现算法快，但是空间和V 成平方比；<br>
 * 2、边的数组：使用Edge 类包含两个Vertex，但是实现算法需要遍历所有的边；<br>
 * 3、邻接表数组：使用以Vertex 为索引的列表数组，数组元素为该Vertex 的相邻Vertex 列表，空间与V+E 成正比；<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/1 10:13<br>
 */
public class UndirectedGraph implements Graph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public UndirectedGraph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
    }

    @Override
    public Iterable<Integer> adjacentE(int v) {
        List<Integer> ws = new LinkedList<>();
        for (int i = 0; i < this.adj.length; i++) {
            if (this.adj[i].contains(v))
                ws.add(i);

        }
        return ws;
    }

    @Override
    public Iterable<Integer> adjacentV(int v) {
        return this.adj[v];
    }
}
