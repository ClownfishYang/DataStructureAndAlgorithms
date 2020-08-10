package io.clownfishyang.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 深度优先搜索<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/2 17:22<br>
 */
public class DepthFirstSearch implements GraphSearch, GraphPaths{

    private final boolean[] marked;
    private int[] edgeTo;
    private int count;
    private final int s;

    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        Iterable<Integer> vs = graph.adjacentV(v);
        for (Integer w : vs) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean marked(int w) {
        return marked[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked(v);
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> list = new LinkedList<Integer>();
        // 类似于linked 的遍历方法，以v 为起点查询到s
        for (int x = v; x != s; x = edgeTo[x]) {
            list.add(x);
        }
        return list;
    }
}
