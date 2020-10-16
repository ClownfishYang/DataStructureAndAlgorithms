package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 数组删除
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 16:45<br>
 */
public class ArrayRemove {

    /**
     * 功能描述:
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 使用双指针，一个指向新地址(idx)，一个用于遍历数组(i)，
     * 当nums[idx] == nums[i] 时，i++;
     * 当nums[idx] != nums[i] 时，需要将索引i 的值复制给索引idx+1;
     * 注意返回值是新的长度，而索引idx 从0 开始，需要补1。
     *
     * @param nums
     * @return 新长度
     * @auther ClownfishYang
     * created on 2020-08-11 16:46:56
     */
    public int linearRemoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) nums[++idx] = nums[i];
        }
        return ++idx;
    }

    /**
     * 功能描述:
     * <p>
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 使用双指针，一个指向新地址(idx)，一个用于遍历数组(i)，
     * 当val != nums[i] 时，idx 不需要移动，i ++;
     * 当val == nums[i] 时，需要将索引i 的值复制给索引idx，并将索引idx++;
     * 注意返回值是新的长度，而索引idx 复制完成后已经做了++ 操作。
     *
     * @param nums 数值
     * @param val  删除元素
     * @return 新长度
     * @auther ClownfishYang
     * created on 2020-08-11 17:43:33
     */
    public int removeElementByCopy(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) nums[idx++] = nums[i];
        }
        return idx;
    }

    /**
     * 功能描述:
     * removeElementByCopy 的另一种解法
     * <p>
     * 使用双指针，一个指向头(i)，一个指向尾(n)，
     * 当val == nums[i] 时，将尾元素(n)复制给索引i，并将n--，注意复制过来的尾元素也可能等于val;
     * 注意返回值是新的长度，而尾指针就是最后复制的索引位。
     *
     * @param nums 数值
     * @param val  删除元素
     * @return 新长度
     * @auther ClownfishYang
     * created on 2020-08-11 18:11:38
     */
    public int removeElementByChange(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return n;
    }

}
