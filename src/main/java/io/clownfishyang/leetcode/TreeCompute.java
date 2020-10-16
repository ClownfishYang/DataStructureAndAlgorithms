package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/19 17:36<br>
 */
public class TreeCompute {


    /**
     *
     * 功能描述:
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 15:05:09
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // DFS
        /*LinkedList<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        zigzagLevelOrder(lists, 0, root);
        return lists;*/
        // BFS
        LinkedList<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        boolean reverseFlag = false;
        while (!stack.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            lists.add(levelList);
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.pop();
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
                if (reverseFlag)
                    levelList.push(node.val);
                else
                    levelList.offer(node.val);
                size --;
            }
            reverseFlag = !reverseFlag;
        }
        return lists;
    }

    private void zigzagLevelOrder(LinkedList<List<Integer>> lists, int level, TreeNode root) {
        if (level >= lists.size())
            lists.add(new LinkedList<Integer>());
        if (level % 2 == 0)
            lists.get(level).add(root.val);
        else
            lists.get(level).add(0, root.val);
        if (root.left != null) zigzagLevelOrder(lists, level + 1, root.left);
        if (root.right != null) zigzagLevelOrder(lists, level + 1, root.right);
    }

    /**
     *
     * 功能描述:
     * 给定一个二叉树，返回它的中序 遍历。
     * 示例:
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 莫里斯遍历：
     * Step 1: 将当前节点current初始化为根节点
     * Step 2: While current不为空，
     * 若current没有左子节点
     *     a. 将current添加到输出
     *     b. 进入右子树，亦即, current = current.right
     * 否则
     *     a. 在current的左子树中，令current成为最右侧节点的右子节点
     *     b. 进入左子树，亦即，current = current.left
     *
     * 举例而言:
     *           1
     *         /   \
     *        2     3
     *       / \   /
     *      4   5 6
     * 首先，1 是根节点，所以将 current 初始化为 1。1 有左子节点 2，current 的左子树是
     *          2
     *         / \
     *        4   5
     * 在此左子树中最右侧的节点是 5，于是将 current(1) 作为 5 的右子节点。令 current = cuurent.left (current = 2)。
     * 现在二叉树的形状为:
     *          2
     *         / \
     *        4   5
     *             \
     *              1
     *               \
     *                3
     *               /
     *              6
     * 对于 current(2)，其左子节点为4，我们可以继续上述过程
     *         4
     *          \
     *           2
     *            \
     *             5
     *              \
     *               1
     *                \
     *                 3
     *                /
     *               6
     * 由于 4 没有左子节点，添加 4 为输出，接着依次添加 2, 5, 1, 3 。节点 3 有左子节点 6，故重复以上过程。
     * 最终的结果是 [4,2,5,1,6,3]。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 14:20:32
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        /*LinkedList<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;*/
        // 栈
        /*if (root == null) return Collections.EMPTY_LIST;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;*/
        // 莫里斯方法遍历
        List<Integer> res = new LinkedList<>();
        TreeNode curr = root, pre = null;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                // 进入右节点
                curr = curr.right;
            } else {
                // 以左节点为根节点，找到最右节点
                pre = curr.left;
                while (pre.right != null)
                    pre = pre.right;
                // 将当前节点(curr)作为最右节点(pre)的右节点
                pre.right = curr;
                // 将当前节点(curr) 的左节点置空，并将左节点作为当前节点
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                inorderTraversal(root.left, res);
            res.add(root.val);
            if (root.right != null)
                inorderTraversal(root.right, res);
        }
    }


    /**
     *
     * 功能描述:
     * 是否是平衡二叉树
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 11:01:24
     */
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        Integer per = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 左节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 从左往右遍历，若当前节点值 <= 上一节点值，则不是BST
            if (per != null && root.val <= per) return false;
            per = root.val;
            root = root.right;
        }
        return true;
        // 递归
//        return isValidBST(root, null, null);
    }

    /**
     *
     * 功能描述:
     *
     * lower < root.val < upper
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-04 17:58:58
     */
    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && lower >= val) return false;
        if (upper != null && val >= upper) return false;
        return isValidBST(root.left, lower, val)
                && isValidBST(root.right, val, upper);
    }



    /**
     * 功能描述:
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     * 示例 1:
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * <p>
     * [1,2,3],   [1,2,3]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:      1          1
     * /           \
     * 2             2
     * <p>
     * [1,2],     [1,null,2]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * <p>
     * [1,2,1],   [1,1,2]
     * 输出: false
     * <p>
     * 如果两个二叉树都为空，则两个二叉树相同。如果两个二叉树中有且只有一个为空，则两个二叉树一定不相同。
     * 如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，若不相同则两个二叉树一定不同，
     * 若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-19 17:43:12
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 深度优先 dfs
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *  
     * <p>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-20 18:06:51
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 迭代
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root.left);
        list.push(root.right);
        while (!list.isEmpty()) {
                TreeNode l = list.poll();
                TreeNode r = list.poll();
                if (l == null && r == null) {
                    continue;
                }
                if (!(l != null && r != null && l.val == r.val))
                    return false;
                list.push(l.left);
                list.push(r.right);
                list.push(l.right);
                list.push(r.left);
        }
        return true;

        // 递归
        /*if (root == null)
            return true;
        else
            return isSymmetric(root.left, root.right);*/
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else
            return p.val == q.val
                    && isSymmetric(p.left, q.right)
                    && isSymmetric(p.right, q.left);
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-20 18:16:05
     */
    public int maxDepth(TreeNode root) {
        // 深度优先
//        return dfsMaxDepth(root);
        // 广度优先
        return bfsMaxDepth(root);
    }

    /**
     * 功能描述:
     * 最大深度 广度优先实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-20 18:21:20
     */
    public int bfsMaxDepth(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;
        if (root.left == null && root.right == null)
            return ++ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 功能描述:
     * 最大深度 深度优先实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-20 18:21:20
     */
    public int dfsMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(dfsMaxDepth(root.left), dfsMaxDepth(root.right));
    }

    /**
     *
     * 功能描述:
     *
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 10:19:49
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 线性层级迭代
        /*if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new LinkedList<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            while (size > 0) {
                TreeNode node = list.pop();
                levelList.add(node.val);
                if (node.left != null)
                    list.offer(node.left);
                if (node.right != null)
                    list.offer(node.right);
                size --;
            }
            res.add(levelList);
        }
        return res;*/
        // 递归
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(0, root, res);
        return res;
    }

    private void levelOrder(int idx, TreeNode node, List<List<Integer>> res) {
        if (node == null) return ;
        List<Integer> levelList;
        if (idx >= res.size()) {
            levelList = new LinkedList<>();
            res.add(levelList);
        } else {
            levelList = res.get(idx);
        }
        levelList.add(node.val);

        idx++;
        levelOrder(idx, node.left, res);
        levelOrder(idx, node.right, res);
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 10:27:19
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;
        // 双向链表的特性
        LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
        // 先入先出队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> bottom = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                // 从左到右
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                bottom.add(node.val);
                size--;
            }
            // 头指针插入
            lists.addFirst(bottom);
        }
        return lists;
    }

    /**
     * 功能描述:
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *    0
     *   / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 11:11:45
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int mid = low + high >> 1;
        return new TreeNode(nums[mid],
                buildBST(nums, low, mid - 1),
                buildBST(nums, mid + 1, high));
    }


    /**
     *
     * 功能描述:
     *
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 16:26:53
     */
    public boolean isBalanced(TreeNode root) {
        // 自顶向下递归，对于同一节点，深度函数会被重复调用
        /*if (root == null || (root.left == null && root.right == null))
            return true;
        return Math.abs(dfsMaxDepth(root.left) - dfsMaxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);*/
        // 自底向上递归，每个节点，深度函数只会调用一次
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     *
     * 功能描述:
     *
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 16:27:51
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 深度优先
        return dfsHasPathSum(root, sum);
        // 广度优先
//        return bfsHasPathSum(root, sum);
    }

    /**
     *
     * 功能描述:
     *
     * 路径上所有节点值相加等于目标和, 深度优先(DFS)实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 16:53:37
     */
    public boolean dfsHasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        // 叶子节点
        if (root.left == null && root.right == null)
            return sum == root.val;
        return dfsHasPathSum(root.left, sum - root.val)
                || dfsHasPathSum(root.right, sum - root.val);
    }

    /**
     *
     * 功能描述:
     *
     * 路径上所有节点值相加等于目标和, 广度度优先(BFS)实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-21 16:53:37
     */
    public boolean bfsHasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> valQue = new LinkedList<>();
        valQue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer val = valQue.poll();
            // 叶子节点
            if (node.left == null && node.right == null) {
                if (val == sum)
                    return true;
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                valQue.offer(node.left.val + val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                valQue.offer(node.right.val + val);
            }
        }
        return false;
    }

}
