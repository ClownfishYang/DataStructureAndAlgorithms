package io.clownfishyang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author ClownfishYang<br>
 * created on 2020/8/10 17:04<br>
 */
public class TwoSum {


    /**
     *
     * 功能描述:
     * 通过hash 存储余数（target - nums[i] = value） - i 的方式
     *
     * @param nums 数组
     * @param target 目标值
     * @return 数组索引
     * @auther ClownfishYang
     * created on 2020-08-10 17:49:28
     */
    public int[] hashContains(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *
     * 功能描述:
     *
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *
     * 通过二分查询的方式
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 17:47:16
     */
    public int[] binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (numbers[mid] == target - numbers[i])
                    return new int[]{i + 1, mid + 1};
                else if (numbers[mid] > target - numbers[i])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *
     * 功能描述:
     *
     * binarySearch 的双指针实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 17:47:53
     */
    public int[] tailHeadSearch(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low <= high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{low + 1, high + 1};
            else if (sum > target)
                high--;
            else
                low ++;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
