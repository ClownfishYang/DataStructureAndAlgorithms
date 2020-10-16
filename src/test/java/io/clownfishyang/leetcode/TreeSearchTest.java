package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/11 10:56<br>
 */
public class TreeSearchTest {

    @Test
    public void kthSmallestTest() {
        TreeSearch treeSearch = new TreeSearch();

        TreeNode root = TreeNode.build(41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30, 36,
                null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4, 29, 32, null, null,
                null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33, null, 6,
                8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null,
                null, null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23);

        int i = treeSearch.kthSmallest(root, 25);
        System.out.println(i);

    }
}