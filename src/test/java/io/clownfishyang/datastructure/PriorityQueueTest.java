package io.clownfishyang.datastructure;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/25 17:54<br>
 */
@Slf4j
public class PriorityQueueTest {



    @org.junit.Test
    public void topNTest() {
        int size = 20;
        PriorityQueueImpl<Integer> priorityQueue = new PriorityQueueImpl(size);
        Random random = new Random();
        int max = size << 3;
        for (int i = 0; i < size; i++) {
            int e = random.nextInt(max);
            log.info("add e : {}",e);
            priorityQueue.add(e);
        }

        log.info("======= start out top N ======");
        Integer lastE = null;
        while(!priorityQueue.isEmpty()) {
            Integer highElement = priorityQueue.removeHigh();
            log.info(String.valueOf(highElement));
            if (lastE == null)
                lastE = highElement;
            else if (highElement.compareTo(lastE) > 0) {
                log.info("highElement : {}, lastE : {}", highElement, lastE);
                log.error("top N out element err.");
                break;
            } else
                lastE = highElement;
        }
    }

}
