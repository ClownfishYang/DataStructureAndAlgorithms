package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 9:24<br>
 */
public class IntReverseTest {

    @Test
    public void linearStringTest() {
        IntReverse intReverse = new IntReverse();
        Assert.assertEquals(intReverse.linearString(123), 321);
        Assert.assertEquals(intReverse.linearString(-123), -321);
        Assert.assertEquals(intReverse.linearString(120), 21);
        Assert.assertEquals(intReverse.linearString(-1463847412), -2147483641);
    }


    @Test
    public void numberConversionTest() {
        IntReverse intReverse = new IntReverse();
        Assert.assertEquals(intReverse.numberConversion(123), 321);
        Assert.assertEquals(intReverse.numberConversion(-123), -321);
        Assert.assertEquals(intReverse.numberConversion(120), 21);
        Assert.assertEquals(intReverse.numberConversion(-1463847412), -2147483641);
    }

    @Test
    public void longConversionTest() {
        IntReverse intReverse = new IntReverse();
        Assert.assertEquals(intReverse.longConversion(123), 321);
        Assert.assertEquals(intReverse.longConversion(-123), -321);
        Assert.assertEquals(intReverse.longConversion(120), 21);
        Assert.assertEquals(intReverse.longConversion(-1463847412), -2147483641);
    }
}