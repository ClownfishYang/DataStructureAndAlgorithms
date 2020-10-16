package io.clownfishyang.leetcode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/1 14:05<br>
 */
public class ArrayUtil {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 递归
        /*res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> curr = new ArrayList<>(res.get(i));
                curr.add(num);
                res.add(curr);
            }
        }*/
        // 回溯
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(res, nums, 0, i, list);
        }
        return res;
    }

    private void subsets(List<List<Integer>> res, int[] nums, int curr, int len, LinkedList<Integer> list) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = curr; i < nums.length; i++) {
                list.add(nums[i]);
                subsets(res, nums, i + 1, len, list);
                list.removeLast();
            }
        }
    }


    /**
     * 功能描述:
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 17:35:18
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new ArrayList<>();
        // 拼接
//        boolean[] useds = new boolean[nums.length];
//        LinkedList<Integer> list = new LinkedList<>();
//        permute(res, nums, 0, useds, list);
        // 交换
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        permute(res, 0,list);
        return res;
    }

    /**
     *
     * 功能描述:
     * 拼接 实现的优化，去掉了标记数组。
     * 已经填到第 idx 个位置，那么 nums 数组中 [0,idx-1] 是已填过的数的集合，[idx,n-1] 是待填的数的集合。
     * 尝试用 [idx,n-1] 里的数去填idx 个数，假设待填的数的下标为 i ，那么填完以后我们将第 i 个数和第 idx 个数交换，
     * 即能使得在填第 idx+1个数的时候 nums 数组的[0,idx]部分为已填过的数，[idx+1,n-1] 为待填的数，回溯的时候交换回来即能完成撤销操作。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 17:24:19
     */
    private void permute(List<List<Integer>> res, int idx, List<Integer> list) {
        if (idx == list.size()) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = idx; i < list.size(); i++) {
                if (i == idx) {
                    permute(res, idx + 1, list);
                } else {
                    Collections.swap(list, idx, i);
                    permute(res, idx + 1, list);
                    Collections.swap(list, idx, i);
                }
            }
        }
    }

    /**
     *
     * 功能描述:
     * 有 n 个排列成一行的空格，我们需要从左往右依此填入题目给定的 n 个数，每个数只能使用一次。
     * 从左往右每一个位置都依此尝试填入一个数，看能不能填完这 n 个空格。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 17:24:57
     */
    private void permute(List<List<Integer>> res, int[] nums, int dept, boolean[] useds, LinkedList<Integer> list) {
        // 填完了n 个位置
        if (dept == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            // 遍历可能的值，依次填入
            for (int i = 0; i < nums.length; i++) {
                // 跳过已使用
                if (useds[i])
                    continue;
                // 标记
                useds[i] = true;
                // 填入
                list.add(nums[i]);
                // 递归下一个位置
                permute(res, nums, dept + 1, useds, list);
                // 撤消
                list.removeLast();
                useds[i] = false;
            }
        }
    }

    /**
     * 功能描述:
     * <p>
     * 翻转数组
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-01 17:45:23
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0, count = 0; count < nums.length; i++) {
            int current = i;
            int per = nums[i];
            do {
                current = (current + k) % nums.length;
                int num = nums[current];
                nums[current] = per;
                per = num;
                count++;
            } while (current != i);
        }
    }

    /**
     * 功能描述:
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * <p>
     * 示例 2:
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * <p>
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-01 18:24:05
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;

        // hash map
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] res = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[idx++] = num;
                map.put(num, --count);
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
        /*
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int idx1 = 0, idx2 = 0,idx = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]){
                idx2 ++;
            } else {
                res[idx++] = nums1[idx1++];
                idx2++;
            }
        }
        return Arrays.copyOfRange(res, 0, idx);*/
    }

    /**
     * 功能描述:
     * <p>
     * 移动0 元素到数组末尾
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 14:55:13
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;

        for (int i = 0, idx = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != idx) {
//                    nums[i] ^= nums[idx];
//                    nums[idx] ^= nums[i];
//                    nums[i] ^= nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = 0;
                }
                idx++;
            }
        }
    }

    public static class Shuffle {

        private int[] array;
        private int[] original;

        public Shuffle(int[] nums) {
            this.array = nums;
            this.original = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            System.arraycopy(this.original, 0, this.array, 0, this.original.length);
            return this.array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            // 利用list
            /*List<Integer> list = new ArrayList<Integer>();
            for (int i : array) {
                list.add(i);
            }
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                int idx = random.nextInt(list.size());
                array[i] = list.get(idx);
                list.remove(idx);
            }
            return array;*/
            // Fisher-Yates 洗牌算法
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                int idx = random.nextInt(array.length - i) + i;
                if (idx != i) {
                    array[i] ^= array[idx];
                    array[idx] ^= array[i];
                    array[i] ^= array[idx];
                }
            }
            return array;
        }
    }
}
