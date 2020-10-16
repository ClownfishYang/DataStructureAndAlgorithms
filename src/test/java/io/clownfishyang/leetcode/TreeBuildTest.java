package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/10 16:53<br>
 */
public class TreeBuildTest {


    @Test
    public void buildTreeTest() {
        TreeBuild treeCompute = new TreeBuild();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = treeCompute.buildTree(preorder, inorder);
        System.out.println(root.str());

    }

    @Test
    public void connectTest() {



    }
}