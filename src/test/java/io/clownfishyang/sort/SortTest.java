package io.clownfishyang.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 选择排序单元测试<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/11/4 15:30<br>
 */
@Slf4j
public class SortTest {

    @Test
    public void selectSortTest() {
        SelectSort selectSort = new SelectSort();
        sortTest(selectSort);
    }

    @Test
    public void insertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();
        sortTest(insertionSort);
    }

    @Test
    public void shellSortTest() {
        ShellSort shellSort = new ShellSort();
        sortTest(shellSort);
    }

    @Test
    public void topDownSortTest() {
        TopDownSort topDownSort = new TopDownSort();
        sortTest(topDownSort);
    }

    @Test
    public void downTopSortTest() {
        DownTopSort downTopSort = new DownTopSort();
        sortTest(downTopSort);
    }

    @Test
    public void quickSortTest() {
        QuickSort quickSort = new QuickSort();
        sortTest(quickSort);
    }

    @Test
    public void bubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort();
        sortTest(bubbleSort);
    }

    @Test
    public void stackSortTest() {
        HeapSort stackSort = new HeapSort<>();
        sortTest(stackSort);
    }

    @Test
    public void compareTest() {
        SelectSort selectSort = new SelectSort();
        sortTest(selectSort);
        InsertionSort insertionSort = new InsertionSort();
        sortTest(insertionSort);
    }

    private void sortTest(AbstractSort sort) {
        log.info("{} sort test start...", sort.getClass().getSimpleName());
        Random random = new Random();
//        Integer[] data = {44, 145, 35, 42, 60, 28, 12, 121, 36, 144, 66};
//        int size = data.length;
//        int size = 5000000;
        int size = 20;
        int max = size << 3;
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(max);
        }

        log.debug("data : {}", Arrays.toString(data));
        sort.sort(data, 0, size);
//        sort.sort(data, 1, size - 1);
        log.debug("sort data : {}", Arrays.toString(data));
        boolean sorted = sort.isSorted(data, 0, size);
//        boolean sorted = sort.isSorted(data, 1, size - 1);
        Assert.assertTrue(sorted);

        log.info("data is sorted: {}", sorted);
        log.info("sort comparable / exchange count : {}, {}",
                sort.comparableCount(), sort.exchangeCount());
        log.info("sort time millis : {}", sort.sortTimeMillis());
        log.info("{} sort test success...", sort.getClass().getSimpleName());
    }
}
