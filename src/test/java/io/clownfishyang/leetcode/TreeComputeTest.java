package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/19 17:42<br>
 */
public class TreeComputeTest {

    @Test
    public void isSameTreeTest() {
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(2);

        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(3);

        TreeNode t1 = new TreeNode(1, l1, r1);
        TreeNode t2 = new TreeNode(1, l2, r2);
        TreeCompute treeCompute = new TreeCompute();
        boolean isSame = treeCompute.isSameTree(t1, t2);
        Assert.assertTrue(isSame);

        t1 = new TreeNode(1, l1, null);
        t2 = new TreeNode(1, null, l1);
        isSame = treeCompute.isSameTree(t1, t2);
        Assert.assertFalse(isSame);
    }

    @Test
    public void isSymmetricTest() {
        TreeCompute treeCompute = new TreeCompute();
        TreeNode treeNode;
        boolean symmetric;
//        treeNode = TreeNode.build(1, 2, 2, 3, 4, 4, 3);
//        symmetric = treeCompute.isSymmetric(treeNode);
//        Assert.assertTrue(symmetric);
//        treeNode = TreeNode.build(1,2,2,null,3,null,3);
//        symmetric = treeCompute.isSymmetric(treeNode);
//        Assert.assertFalse(symmetric);
        treeNode = TreeNode.build(2,3,3,4,5,5,4,null,null,8,9,9,8);
        symmetric = treeCompute.isSymmetric(treeNode);
        Assert.assertFalse(symmetric);
    }

    @Test
    public void dfsMaxDepthTest() {
        TreeCompute treeCompute = new TreeCompute();
        Assert.assertEquals(treeCompute.dfsMaxDepth(null), 0);

        TreeNode n4 = new TreeNode(4);
        // 1
        Assert.assertEquals(treeCompute.dfsMaxDepth(n4), 1);

        TreeNode n3 = new TreeNode(3);

        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, null, n2);

        // 3
        Assert.assertEquals(treeCompute.dfsMaxDepth(n1), 3);

        n1 = new TreeNode(1, n2, n2);
        TreeNode n0 = new TreeNode(0, n1, n2);
        // 4
        Assert.assertEquals(treeCompute.dfsMaxDepth(n0), 4);
    }

    @Test
    public void bfsMaxDepthTest() {
        TreeCompute treeCompute = new TreeCompute();
        Assert.assertEquals(treeCompute.bfsMaxDepth(null), 0);

        TreeNode n4 = new TreeNode(4);
        // 1
        Assert.assertEquals(treeCompute.bfsMaxDepth(n4), 1);

        TreeNode n3 = new TreeNode(3);

        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, null, n2);

        // 3
        Assert.assertEquals(treeCompute.bfsMaxDepth(n1), 3);

        n1 = new TreeNode(1, n2, n2);
        TreeNode n0 = new TreeNode(0, n1, n2);
        // 4
        Assert.assertEquals(treeCompute.bfsMaxDepth(n0), 4);
    }

    @Test
    public void levelOrderBottomTest() {

        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20, n15, n7);

        TreeNode n3 = new TreeNode(3, n9, n20);

        TreeCompute treeCompute = new TreeCompute();
        List<List<Integer>> lists = treeCompute.levelOrderBottom(n3);
        System.out.println(lists);
    }

    @Test
    public void sortedArrayToBSTTest() {
        TreeCompute treeCompute = new TreeCompute();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = treeCompute.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    @Test
    public void isBalancedTest() {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.build(nums);
        TreeCompute treeCompute = new TreeCompute();
        boolean isBalanced = treeCompute.isBalanced(root);
        Assert.assertTrue(isBalanced);

        nums = new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4};
        root = TreeNode.build(nums);
        isBalanced = treeCompute.isBalanced(root);
        Assert.assertFalse(isBalanced);

        nums = new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        root = TreeNode.build(nums);
        isBalanced = treeCompute.isBalanced(root);
        Assert.assertFalse(isBalanced);
    }

    @Test
    public void hasPathSumTest() {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.build(nums);
        TreeCompute treeCompute = new TreeCompute();
        boolean hasPathSum;
//        boolean hasPathSum = treeCompute.hasPathSum(root, 18);
//        System.out.println(hasPathSum);
        /*hasPathSum = treeCompute.hasPathSum(root, 27);
        System.out.println(hasPathSum);
        hasPathSum = treeCompute.hasPathSum(root, 18);
        System.out.println(hasPathSum);
        hasPathSum = treeCompute.hasPathSum(root, 26);
        System.out.println(hasPathSum);
        hasPathSum = treeCompute.hasPathSum(root, 1);
        System.out.println(hasPathSum);
        hasPathSum = treeCompute.hasPathSum(root, 5);
        System.out.println(hasPathSum);*/

        nums = new Integer[]{1, 2};
        root = TreeNode.build(nums);
        hasPathSum = treeCompute.hasPathSum(root, 1);
        System.out.println(hasPathSum);
    }

    @Test
    public void dfsHasPathSumTest() {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.build(nums);
        TreeCompute treeCompute = new TreeCompute();
        boolean hasPathSum;
        hasPathSum = treeCompute.dfsHasPathSum(root, 18);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.dfsHasPathSum(root, 27);
        Assert.assertTrue(hasPathSum);
        hasPathSum = treeCompute.dfsHasPathSum(root, 26);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.dfsHasPathSum(root, 1);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.dfsHasPathSum(root, 5);
        Assert.assertFalse(hasPathSum);

        nums = new Integer[]{1, 2};
        root = TreeNode.build(nums);
        hasPathSum = treeCompute.dfsHasPathSum(root, 1);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.dfsHasPathSum(root, 3);
        Assert.assertTrue(hasPathSum);
    }

    @Test
    public void bfsHasPathSumTest() {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.build(nums);
        TreeCompute treeCompute = new TreeCompute();
        boolean hasPathSum;
        hasPathSum = treeCompute.bfsHasPathSum(root, 18);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.bfsHasPathSum(root, 27);
        Assert.assertTrue(hasPathSum);
        hasPathSum = treeCompute.bfsHasPathSum(root, 26);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.bfsHasPathSum(root, 1);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.bfsHasPathSum(root, 5);
        Assert.assertFalse(hasPathSum);

        nums = new Integer[]{1, 2};
        root = TreeNode.build(nums);
        hasPathSum = treeCompute.bfsHasPathSum(root, 1);
        Assert.assertFalse(hasPathSum);
        hasPathSum = treeCompute.bfsHasPathSum(root, 3);
        Assert.assertTrue(hasPathSum);
    }

    @Test
    public void isValidBSTTest() {
        TreeCompute treeCompute = new TreeCompute();
        TreeNode root;
        boolean isValid;

        root = TreeNode.build(2, 1, 3);
        isValid = treeCompute.isValidBST(root);
        System.out.println(isValid);
//
        root = TreeNode.build(5, 1, 4, null, null, 3, 6);
        isValid = treeCompute.isValidBST(root);
        System.out.println(isValid);


        root = TreeNode.build(10,5,15,null,null,6,20);
        isValid = treeCompute.isValidBST(root);
        System.out.println(isValid);
    }

    @Test
    public void levelOrderTest() {
        TreeCompute treeCompute = new TreeCompute();
        TreeNode root;
        List<List<Integer>> res;
        root = TreeNode.build(1);
        res = treeCompute.levelOrder(root);
        res.forEach(System.out::println);
        System.out.println();
        root = TreeNode.build(3,9,20,null,1,15,7);
        res = treeCompute.levelOrder(root);
        res.forEach(System.out::println);
        System.out.println();

        root = TreeNode.build(3,null,20,null,1,15,7);
        res = treeCompute.levelOrder(root);
        res.forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void inorderTraversalTest() {
        TreeCompute treeCompute = new TreeCompute();

        TreeNode root = TreeNode.build(1,2,3,4,5,6);
        List<Integer> list = treeCompute.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void zigzagLevelOrderTest() {
        TreeCompute treeCompute = new TreeCompute();

        TreeNode root = TreeNode.build(3, 9, 20, 6, 10, 15, 7);
        List<List<Integer>> lists = treeCompute.zigzagLevelOrder(root);
        System.out.println(lists);
        lists.forEach(System.out::println);
    }

}