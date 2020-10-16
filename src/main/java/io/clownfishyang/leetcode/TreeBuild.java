package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/10 16:38<br>
 */
public class TreeBuild {

    /**
     *
     * 功能描述:
     *
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 10:35:30
     */
    public Node connect(Node root) {
        // BFS
        /*if (root == null) return null;
        LinkedList<Node> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                Node node = stack.pop();
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
                size --;
                if (size > 0)
                    node.next = stack.peek();
            }
        }
        return root;*/
        // DFS
//        connect(root, null);
//        return root;

        // 使用next 指针
        if (root == null) return root;
        // N 层的left 节点
        Node leftmost = root;
        while (leftmost.left != null) {
            // N + 1 层的节点next 指针
            Node head = leftmost;
            while (head != null) {
                // 同一个父节点
                head.left.next = head.right;
                // 不同父节点的子节点
                if (head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    private void connect(Node node, Node next) {
        if (node != null) {
            node.next = next;
            connect(node.left, node.right);
            connect(node.right, next != null ? next.left : null);
        }
    }


    /**
     * 功能描述:
     *
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 09:23:16
     */
    public TreeNode buildTree (int[] preorder, int[] inorder) {
        // 迭代法
        return iterativeBuildTree(preorder, inorder);

        // 分治法
//        return divideBuildTree(preorder, inorder);
    }

    /**
     *
     * 功能描述:
     * 迭代法
     * 前序遍历中的任意两个连续节点 u 和 v，根据前序遍历的流程，我们可以知道 u 和 v 只有两种可能的关系：
     *  v 是 u 的左儿子。这是因为在遍历到 u 之后，下一个遍历的节点就是 u 的左儿子，即 v；
     *  u 没有左儿子，并且 v 是 u 的某个祖先节点（或者 u 本身）的右儿子。
     *      如果 u 没有左儿子，那么下一个遍历的节点就是 u 的右儿子。
     *      如果 u 没有右儿子，我们就会向上回溯，直到遇到第一个有右儿子（且 u 不在它的右儿子的子树中）的节点 ua，那么v 就是ua 的右儿子。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 16:38:04
     */
    private TreeNode iterativeBuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        // 前序遍历第一个节点肯定是root 节点
        TreeNode root = new TreeNode(preorder[0]);
        // 当前所有还未考虑过右节点的祖先节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inIdx = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            // 当前节点的值和中序遍历数组的值不相等
            if (node.val != inorder[inIdx]) {
                // 作为左子树
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                // index 恰好指向栈顶节点，不断弹出栈顶结点判断
                // 前序遍历节点与中序遍历节点比较
                while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
                    node = stack.pop();
                    inIdx++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     *
     * 功能描述:
     * 分治法
     * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
     * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 16:38:30
     */
    private TreeNode divideBuildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, idxMap);
    }

    /**
     *
     * 功能描述:
     * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *
     * @param preorder 前序遍历数组
     * @param preLeft 前序遍历开始index
     * @param preRight 前序遍历结束index
     * @param inLeft 中序遍历开始index (用于计算左子树数量)
     * @param idxMap 中序遍历值- index 映射
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 15:21:03
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int inLeft, Map<Integer,Integer> idxMap) {
        if (preLeft > preRight)
            return null;
        // 前序遍历的第一个节点 = 根节点
        int preRoot = preLeft;
        // 中序遍历的根节点
        int inRoot = idxMap.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftSize = inRoot - inLeft;
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftSize,
                inLeft, idxMap);
        root.right = buildTree(preorder, preLeft + leftSize + 1, preRight,
                inRoot + 1, idxMap);
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
