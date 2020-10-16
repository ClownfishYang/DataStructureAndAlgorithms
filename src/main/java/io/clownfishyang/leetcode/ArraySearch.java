package io.clownfishyang.leetcode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 15:52<br>
 */
public class ArraySearch {

    /**
     *
     * 功能描述:
     * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
     * 数学表达式如下:
     * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
     * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     *
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: true
     *
     * 示例 2:
     * 输入: [5,4,3,2,1]
     * 输出: false
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-10 10:13:15
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        // 0 <= i < j < k <= n-1
        // arr[i] < arr[j] < arr[k]
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE, idx = 0;
        while (idx < nums.length) {
            int num = nums[idx];
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
            idx++;
        }
        return false;
    }

    /**
     *
     * 功能描述:
     *
     * 查询第一个错误版本
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 16:38:11
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        if (isBadVersion(low)) return low;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int v) {
        return v >= 5;
    }

    /**
     *
     * 功能描述:
     * 是否包含重复值
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 11:19:16
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        // hash set
        /*Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }*/
        // sort
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    /**
     * 功能描述:
     * <p>
     * 在有序数组中查询目标值，若目标值不存在则返回插入位置。
     *
     * @param nums
     * @param target
     * @return
     * @auther ClownfishYang
     * created on 2020-08-12 16:51:35
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + high >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 15:11:39
     */
    public int singleNumber(int[] nums) {
        // 位运算
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 10:45:21
     */
    public int majorityElement(int[] nums) {
        // 分治法
//        majorityElement(nums, 0, nums.length - 1);
        // boyer-moore 投票法
        return boyerMoore(nums);
    }

    /**
     * 功能描述:
     * <p>
     * 使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。长度为 1 的子数组中唯一的数显然是众数，直接返回即可。
     * 如果回溯后某区间的长度大于 1，我们必须将左右子区间的值合并。
     * 如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。
     * 否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 10:46:34
     */
    public int majorityElement(int[] nums, int low, int high) {
        if (low == high) return nums[low];

        int mid = (low + high) >> 1;
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid + 1, high);
        if (left == right) return left;


        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 功能描述:
     * <p>
     * Boyer-Moore 算法的详细步骤:
     * 维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     * 在遍历完成后，candidate 即为整个数组的众数。
     * <p>
     * 例：
     * nums:      [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * candidate:  7  7  7  7  7  7   5  5   5  5  5  5   7  7  7  7
     * count:      1  2  1  2  1  0   1  0   1  2  1  0   1  2  3  4
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 10:47:30
     */
    public int boyerMoore(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (--count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }


    /**
     * 功能描述:
     * <p>
     * Boyer-Moore 算法 找出超过1/3 的元素
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 17:29:59
     */
    public List<Integer> boyerMoore2(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        int count1 = 0, count2 = 0;
        int candidate1 = nums[0], candidate2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
                continue;
            }
            if (candidate2 == nums[i]) {
                count2++;
                continue;
            }

            if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }
        int n = nums.length / 3;
        List<Integer> list = new LinkedList<>();
        if (count1 > n) list.add(candidate1);
        if (count2 > n) list.add(candidate2);
        return list;
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/m ⌋ 次的元素。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: [3]
     * <p>
     * 示例 2:
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     * <p>
     * 基于 Boyer-Moore 算法：
     * 1、投票阶段，定义m - 1 个candidate，因为出现超过[n/m] 次，所以至多只有m - 1个；
     * 重复原先的计数抵消票数的方式，相等加一，为0 赋予 candidate，否则减少票数；
     * 2、计数阶段，由于是多个candidate，投票阶段得到的candidate 很可能会超过[n/m]次，需要再次验证。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 16:56:44
     */
    public List<Integer> majorityElement(int[] nums, int m) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        // init
        int n = m - 1;
        int[] candidates = new int[n];
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = nums[0];
            counts[i] = 0;
        }
        // 投票
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 相等
                if (candidates[j] == nums[i]) {
                    counts[j]++;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < n; j++) {
                    // 赋予candidate
                    if (counts[j] == 0) {
                        candidates[j] = nums[i];
                        counts[j]++;
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                // 减少票数
                for (int j = 0; j < n; j++) {
                    counts[j]--;
                }
            }
        }
        // 重置
        for (int i = 0; i < n; i++)
            counts[i] = 0;
        // 计数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < n; j++) {
                if (candidates[j] == nums[i]) {
                    counts[j]++;
                    break;
                }
            }
        }
        // 校验
        List<Integer> list = new LinkedList<>();
        int count = nums.length / m;
        for (int i = 0; i < n; i++) {
            if (counts[i] > count)
                list.add(candidates[i]);
        }
        return list;
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        if (m * k > n) return false;
        int N = n == m * k ? 1 : n - m * k;
        for (int i = 0; i < N; i++) {
            int j = i + m;
            int M = i + m * k;
            for (; j < M; j++) {
                if (arr[j] != arr[j-m]) break;
            }
            if (j == M) return true;
        }
        return false;
    }
}
