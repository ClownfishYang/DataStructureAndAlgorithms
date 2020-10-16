package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 11:50<br>
 */
public class ClimbStairsTest {

    @Test
    public void climbStairsTest() {
        ClimbStairs climbStairs = new ClimbStairs();
        Assert.assertEquals(climbStairs.climbStairs(2), 2);
        Assert.assertEquals(climbStairs.climbStairs(3), 3);

    }
}