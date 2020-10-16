package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 17:03<br>
 */
public class CountAndSayTest {

    @Test
    public void sayTest() {
        CountAndSay countAndSay = new CountAndSay();
        Assert.assertEquals(countAndSay.say(1), "1");
        Assert.assertEquals(countAndSay.say(4), "1211");
        Assert.assertEquals(countAndSay.say(5), "111221");
        Assert.assertEquals(countAndSay.say(5), "111221");
    }
}