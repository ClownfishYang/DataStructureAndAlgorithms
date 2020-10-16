package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 17:37<br>
 */
public class MatrixTest {

    @Test
    public void aroundCharTest() {
        char[][] board = new char[][]
                {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
        Matrix matrix = new Matrix();
        matrix.aroundChar(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    @Test
    public void isValidSudokuTest() {
        char[][] board = {
                {
                        '5', '3', '.', '.', '7', '.', '.', '.', '.'
                },
                {
                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                },
                {
                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                },
                {
                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                },
                {
                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                },
                {
                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                },
                {
                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                },
                {
                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                },
                {
                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                }
        };

        Matrix matrix = new Matrix();
        boolean isValidSudoku = matrix.isValidSudoku(board);
        Assert.assertTrue(isValidSudoku);
        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        isValidSudoku = matrix.isValidSudoku(board);
        Assert.assertFalse(isValidSudoku);
    }

    @Test
    public void rotateTest() {
        Matrix matrix = new Matrix();
        int[][] matrix1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        matrix.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {
            { 5, 1, 9,11},
            { 2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16}
        };
        matrix.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    @Test
    public void setZeroesTest() {
        Matrix matrix = new Matrix();

        int[][]matrix1=null;
        matrix1 = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        matrix.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println();

        matrix1= new int[][]{{0,1,1},{1,0,1},{1,1,1}};
        matrix.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        matrix1= new int[][]{{1,1,0},{1,0,1},{1,1,1}};
        matrix.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));


        matrix1= new int[][]{{1,1,1},{0,1,1},{1,1,0}};
        matrix.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        matrix1= new int[][]{{0,1,1},{1,1,1},{1,1,0}};
        matrix.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }

    @Test
    public void numIslandsTest() {
        Matrix matrix = new Matrix();
        char[][]grid=null;
        int count = 0;

        grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        count = matrix.numIslands(grid);
        System.out.println(count);


        grid = new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        count = matrix.numIslands(grid);
        System.out.println(count);


        grid = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        count = matrix.numIslands(grid);
        System.out.println(count);

    }
}