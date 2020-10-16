package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/21 17:26<br>
 */
public class YanghuiTriangleTest {

    @Test
    public void generateTest() {

        YanghuiTriangle yanghuiTriangle = new YanghuiTriangle();
        List<List<Integer>> lists = yanghuiTriangle.generate(5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void getRowTest() {
        YanghuiTriangle yanghuiTriangle = new YanghuiTriangle();
        List<Integer> row = yanghuiTriangle.getRow(0);
        Assert.assertArrayEquals(row.stream().toArray(Integer[]::new), new Integer[]{1});
        row = yanghuiTriangle.getRow(1);
        Assert.assertArrayEquals(row.stream().toArray(Integer[]::new), new Integer[]{1,1});
        row = yanghuiTriangle.getRow(2);
        Assert.assertArrayEquals(row.stream().toArray(Integer[]::new), new Integer[]{1,2,1});
        row = yanghuiTriangle.getRow(4);
        Assert.assertArrayEquals(row.stream().toArray(Integer[]::new), new Integer[]{1,4,6,4,1});
    }
}