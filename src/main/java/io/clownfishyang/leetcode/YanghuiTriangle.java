package io.clownfishyang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 杨辉三角
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author ClownfishYang<br>
 * created on 2020/8/21 17:19<br>
 */
public class YanghuiTriangle {

    /**
     *
     * 功能描述: 
     *
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * 示例:
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * @param
     * @return 
     * @auther ClownfishYang
     * created on 2020-08-24 10:18:50
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if (numRows > 0) {
            lists.add(Arrays.asList(1));
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>(i);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    List<Integer> pre = lists.get(i - 1);
                    row.add(pre.get(j - 1) + pre.get(j));
                }
                row.add(1);
                lists.add(row);
            }
        }
        return lists;
    }

    /**
     *
     * 功能描述:
     *
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 10:19:42
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Arrays.asList(1);
        int size = rowIndex + 1;
        List<Integer> row = new ArrayList<Integer>(size);
        // 第二行，初始化为1
        // row = {1, 1}
        for (int i = 0; i < 2; i++) {
            row.add(1);
        }
        // 第三行，开始计算
        for (int i = 2; i < size; i++) {
            // rot[i] = 1
            row.add(1);
            // 从后往前，避免值覆盖
            for (int j = i - 1 ; j >= 1; j--) {
                // row[j] = row[j-1] + row[j]
                row.set(j, row.get(j-1) + row.get(j));
            }
        }
        return row;
    }

}
