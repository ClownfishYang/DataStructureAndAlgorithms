package io.clownfishyang.datastructure.graph;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/2 17:34<br>
 */
public class GraphSearchTest {

    @org.junit.Test
    public void markedTest() {
        UndirectedGraph graph = new UndirectedGraph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        int s = 0;
        DepthFirstSearch graphSearch = new DepthFirstSearch(graph, s);

        Iterable<Integer> vs = graphSearch.pathTo(3);
        if (vs == null) {
            System.out.println("not conn.");
        } else {
            System.out.println("conn path : ");
            for (Integer v : vs) {
                System.out.print(v + " ");
            }
        }
    }

}
