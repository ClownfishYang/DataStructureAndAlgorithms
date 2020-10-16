package io.clownfishyang.leetcode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 18:03<br>
 */
public class ArraySum {


    public List<List<Integer>> threeSum(int[] nums) {
        /*if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        // sort
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        // 主指针
        for (int i = 0; i < nums.length; i++) {
            // 重复
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 在(i,length) 中查询值等于 -nums[i]的下标
            int high = nums.length - 1, target = -nums[i];
            for (int low = i + 1; low < nums.length; low++) {
                // 重复
                if (low > i + 1 && nums[low] == nums[low - 1])
                    continue;
                // 尾指针前移
                while (low < high && nums[low] + nums[high] > target)
                    high--;
                if (low == high) break;
                // 相等
                if (nums[low] + nums[high] == target)
                    lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
            }
        }
        return lists;*/

        if (nums == null || nums.length < 3) return Collections.EMPTY_LIST;
        // sort
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {
            // 主指针
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                // 重复
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                // 在(i,length) 中查询值等于 -nums[i]的下标
                int low = i + 1, high = nums.length - 1, target = -nums[i];
                while (low < high) {
                    // 相等
                    if (nums[low] + nums[high] == target) {
                        lists.add(Arrays.asList(nums[i], nums[low++], nums[high]));
                        // low 指针后移，跳过重复
                        while (low < high && nums[low] == nums[low - 1]) low++;
                    } else if (nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        low++;
                    }


                    // 不相等时也执行low 指针后移操作，跳过重复(不知道为啥实际变慢了)
                    /*if (nums[low] + nums[high] > target) {
                        // 移动high 指针，跳过重复
                        high --;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else {
                        if (nums[low] + nums[high] == target) {
                            lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        }
                        // 移动low 指针，跳过重复
                        low ++;
                        while (low < high && nums[low] == nums[low - 1]) low++;
                    }*/
                }
            }
        }
        return lists;

    }

    /**
     *
     * 功能描述: 
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 示例 1：
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 示例 2：
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 提示：
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 14:54:27
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int per = 0, maxAns = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = maxAns;
            maxAns = Math.max(per + nums[i], maxAns);
            per = temp;
        }
        return maxAns;
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-13 09:51:32
     */
    public int[] plusOne(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i]++;
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        // 全为零，则首位为1，99 -> 100, 999 -> 1000
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }

    
    /**
     *
     * 功能描述: 
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param
     * @return 
     * @auther ClownfishYang
     * created on 2020-08-24 10:58:46
     */
    public int maxProfitSingle(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    /**
     *
     * 功能描述:
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 11:16:46
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        // 找出峰值跟低估
        int valley = prices[0];
        int peak = prices[0];
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }

        // 上升就累加
        /*for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }*/
        return maxProfit;
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums 数组
     * @return 最大和
     * @auther ClownfishYang
     * created on 2020-08-12 18:01:35
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // max(前面的值 + 当前值, 当前值)
            pre = Math.max(pre + nums[i], nums[i]);
            // max(最大值, 新计算的值)
            max = Math.max(max, pre);
        }
        return max;
    }


    /**
     * 功能描述:
     * <p>
     * maxSubArray 的另一种实现，通过分治法的方式，递归生成MaxSubSegment 求得最大和。
     *
     * @param nums 数组
     * @return 最大和
     * @auther ClownfishYang
     * created on 2020-08-13 09:13:45
     */
    public int maxSubArrayBySegment(int[] nums) {
        return maxSubArrayBySegmentGet(nums, 0, nums.length - 1).mSum;
    }

    private MaxSubSegment maxSubArrayBySegmentGet(int[] nums, int low, int high) {
        if (low == high) return new MaxSubSegment(nums[low], nums[low], nums[low], nums[low]);
        int mid = low + high >> 1;
        MaxSubSegment lSub = maxSubArrayBySegmentGet(nums, low, mid);
        MaxSubSegment rSub = maxSubArrayBySegmentGet(nums, mid + 1, high);
        return MaxSubSegment.pushUp(lSub, rSub);
    }

    /**
     * Copyright (C), 2015-${YEAR}, 深圳市环球易购电子商务有限公司<br>
     * <p>
     * lSum 表示 [l, r] 内以 l 为左端点的最大子段和
     * rSum 表示 [l, r] 内以 r 为右端点的最大子段和
     * mSum 表示 [l, r] 内的最大子段和
     * iSum 表示 [l, r] 的区间和
     *
     * @author ClownfishYang<br>
     * created on 2020-08-12 18:11:37<br>
     */
    public static class MaxSubSegment {
        int lSum, rSum, mSum, iSum;

        public MaxSubSegment(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        public static MaxSubSegment pushUp(MaxSubSegment l, MaxSubSegment r) {
            int lSum = Math.max(l.lSum, l.iSum + r.lSum);
            int rSum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            int iSum = l.iSum + r.iSum;
            return new MaxSubSegment(lSum, rSum, mSum, iSum);
        }
    }
}
