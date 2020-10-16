package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/24 18:06<br>
 */
public class ExcelTest {

    @Test
    public void convertToTitleTest() {
        Excel excel = new Excel();
//        Assert.assertEquals(excel.convertToTitle(1), "A");
//        Assert.assertEquals(excel.convertToTitle(2), "B");
//        Assert.assertEquals(excel.convertToTitle(28), "AB");
        Assert.assertEquals(excel.convertToTitle(701), "ZY");

    }
}