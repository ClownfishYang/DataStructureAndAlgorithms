package io.clownfishyang.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/1 10:47<br>
 */
public enum GraphUtil {
    INSTANCED;

    /**
     * 功能描述:
     * <p>
     * 领边数量
     *
     * @auther ClownfishYang
     * created on 2019-12-01 10:22:33
     */
    public int degreeE(Graph graph, int v) {
        return degree(graph, v, GraphElementType.E);
    }

    /**
     * 功能描述:
     * <p>
     * 最大领边数量
     *
     * @auther ClownfishYang
     * created on 2019-12-01 10:22:33
     */
    public int maxDegreeE(Graph graph) {
        return maxDegree(graph, GraphElementType.E);
    }


    /**
     * 功能描述:
     * <p>
     * 领点数量
     *
     * @auther ClownfishYang
     * created on 2019-12-01 10:22:33
     */
    public int degreeV(Graph graph, int v) {
        return degree(graph, v, GraphElementType.V);
    }

    /**
     * 功能描述:
     * <p>
     * 最大领点数量
     *
     * @auther ClownfishYang
     * created on 2019-12-01 10:22:33
     */
    public int maxDegreeV(Graph graph) {
        return maxDegree(graph, GraphElementType.V);
    }

    /**
     * 功能描述:
     * <p>
     * 相邻的元素类型数量
     *
     * @param graph       图对象
     * @param v           顶点
     * @param elementType 元素类型
     * @return 相邻的元素类型数量
     * @auther ClownfishYang
     * created on 2019-12-01 10:42:41
     */
    public int degree(Graph graph, int v, GraphElementType elementType) {
        Iterable<Integer> vs;
        switch (elementType) {
            case V:
                vs = graph.adjacentV(v);
                break;
            case E:
                vs = graph.adjacentE(v);
                break;
            default:
                throw new UnsupportedOperationException(String.format("GraphElementType : [%s]", elementType));
        }
        // 可能存在溢出的情况
        int degree = 0;
        for (int w : vs) degree++;
        return degree;
    }

    /**
     * 功能描述:
     * <p>
     * 最大的元素类型数量
     *
     * @param graph       图对象
     * @param elementType 元素类型
     * @return 最大的元素类型数量
     * @auther ClownfishYang
     * created on 2019-12-01 10:42:41
     */
    public int maxDegree(Graph graph, GraphElementType elementType) {
        int v = graph.V();
        int maxDegree = 0;
        for (int i = 0; i < v; i++) {
            int degree = degree(graph, v, elementType);
            if (degree > maxDegree) maxDegree = degree;
        }
        return maxDegree;
    }

    /**
     * 功能描述:
     * <p>
     * 平均度数
     *
     * @param graph 图对象
     * @return 平均度数
     * @auther ClownfishYang
     * created on 2019-12-01 10:50:56
     */
    public double avgDegree(Graph graph) {
        return (graph.E() << 1) / graph.V();
    }

    /**
     * 功能描述:
     * <p>
     * 返回自环的顶点
     *
     * @param graph 图对象
     * @return 自环顶点 Set
     * @auther ClownfishYang
     * created on 2019-12-01 10:56:31
     */
    public Set<Integer> selfLoops(Graph graph) {
        int vs = graph.V();
        Set<Integer> set = new HashSet<>(vs + 1, 1);
        for (int v = 0; v < vs; v++) {
            for (int w : graph.adjacentV(v)) {
                if (v == w) set.add(w);
            }
        }
        return set;
    }

    /**
     * 功能描述:
     * <p>
     * 自环数量
     *
     * @param graph
     * @return 自环数量
     * @auther ClownfishYang
     * created on 2019-12-01 10:57:10
     */
    public int selfLoopCount(Graph graph) {
        return selfLoops(graph).size();
    }

    public String toString(Graph graph) {
        StringBuilder sb = new StringBuilder();
        int vs = graph.V();
        sb.append(vs).append(" vertices, ").append(graph.E()).append(" edges.\n");
        for (int v = 0; v < vs; v++) {
            sb.append(v).append(": ");
            for (int w : graph.adjacentV(v)) {
                sb.append(w).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
