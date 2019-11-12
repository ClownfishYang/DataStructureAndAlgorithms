package io.clownfishyang.datastructure;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 11:17<br>
 */
@Slf4j
public class LinkedBagTest {
    @org.junit.Test
    public void linkedBagTest() {
        LinkedBag<Integer> linkedBag = new LinkedBag<>();
        Random random = new Random();
        int size = 10;
        for (int i = 0; i < size; i++) {
            int item = random.nextInt(100);
            log.debug("add item : {}", item);
            linkedBag.add(item);
        }
        double sum = 0;
        for (Integer item : linkedBag) {
            log.debug("iterator item : {}", item);
            sum += item;
        }
        double avg = sum / size;
        log.debug("sum / size = avg : {} / {} = {}", sum, size, avg);
        Object[] itemData = linkedBag.toArray();
        log.debug("item data : {}", Arrays.toString(itemData));
        Integer[] intData = new Integer[linkedBag.size()];
        linkedBag.toArray(intData);
        log.debug("double data : {}", Arrays.toString(intData));
        Integer[] subDoubleData = new Integer[linkedBag.size() / 2];
        subDoubleData = linkedBag.toArray(subDoubleData);
        log.debug("sub double data : {}", Arrays.toString(subDoubleData));
        Integer[] lengthDoubleData = new Integer[linkedBag.size() * 2];
        lengthDoubleData = linkedBag.toArray(lengthDoubleData);
        log.debug("length double data : {}", Arrays.toString(lengthDoubleData));
    }

}
