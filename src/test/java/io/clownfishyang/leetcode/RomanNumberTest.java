package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 11:11<br>
 */
public class RomanNumberTest {

    @Test
    public void toIntTest() {
        RomanNumber romanNumber = new RomanNumber();
        Assert.assertEquals(romanNumber.toInt("III"), 3);
        Assert.assertEquals(romanNumber.toInt("IV"), 4);
        Assert.assertEquals(romanNumber.toInt("IIV"), 3);
        Assert.assertEquals(romanNumber.toInt("IX"), 9);
        Assert.assertEquals(romanNumber.toInt("LVIII"), 58);
        Assert.assertEquals(romanNumber.toInt("MCMXCIV"), 1994);
    }
}