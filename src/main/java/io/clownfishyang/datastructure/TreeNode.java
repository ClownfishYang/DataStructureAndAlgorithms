package io.clownfishyang.datastructure;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/19 17:37<br>
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(Integer... nums) {
        return insertLevelOrder(nums, 0);
    }

    private static TreeNode insertLevelOrder(Integer[] nums, int i) {
        TreeNode root = null;
        if (i < nums.length) {
            if (nums[i] == null)
                return null;
            root = new TreeNode(nums[i]);
            root.left = insertLevelOrder(nums, i * 2 + 1);
            root.right = insertLevelOrder(nums, i * 2 + 2);
        }
        return root;
    }

    public String str() {
        LinkedList<Integer> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null){
                lists.add(null);
            } else {
                lists.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (lists.size() > 1) {
            Integer val = lists.pollLast();
            if (val != null) {
                lists.offer(val);
                break;
            }
        }
        return lists.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public void toString(LinkedList<Integer> lists, TreeNode node) {
        if (node == null) {
            lists.add(null);
        }
    }
}
