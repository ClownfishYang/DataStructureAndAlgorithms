package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;

import java.util.LinkedList;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/11 10:43<br>
 */
public class TreeSearch {

    /**
     *
     * 功能描述:
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     *
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 11:33:39
     */
    public int kthSmallest(TreeNode root, int k) {
        if (k < 1) throw new IllegalArgumentException();
        // 中序遍历第k 个
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        throw new IllegalArgumentException();
    }

    // 递归实现（深度优先搜索）
    public void recursion(TreeNode root) {
        if (root != null) {
            // root.val 前序
            recursion(root.left);
            // root.val 中序
            recursion(root.right);
            // root.val 后序
        }
    }

    // 非递归实现（深度优先搜索）
    public void linear(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                // pNode.val 前序
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                // node.val 中序
                pNode = node.right;
            }
        }
    }

    // 层级遍历（广度优先）
    public void level(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
    }
}
