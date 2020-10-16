package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 11:45<br>
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int p = 0,q = 0,r = 1;
        for (int i = n; i > 0; i--) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
