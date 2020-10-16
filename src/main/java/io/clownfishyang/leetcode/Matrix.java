package io.clownfishyang.leetcode;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 17:21<br>
 */
public class Matrix {



    /**
     * 功能描述:
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1:
     * 输入:
     * [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出: 1
     *
     * 示例 2:
     * 输入:
     * [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 14:16:01
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        char land = '1';
        int count = 0;
        // DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == land) {
                    count++;
                    dfsLands(grid, i, j);
                }
            }
        }

        // BFS
        /*Queue<Integer> neighbors = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == land) {
                    count++;
                    grid[i][j] = '0';
                    neighbors.add(i * n + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int r = id / n;
                        int c = id % n;
                        if (r - 1 >= 0 && grid[r - 1][c] == land) {
                            neighbors.add((r - 1) * n + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < m && grid[r + 1][c] == land) {
                            neighbors.add((r + 1) * n + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == land) {
                            neighbors.add(r * n + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < n && grid[r][c + 1] == land) {
                            neighbors.add(r * n + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }*/
        return count;
    }

    private void dfsLands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == '0')
            return ;
        grid[i][j] = '0';
        dfsLands(grid, i - 1, j);
        dfsLands(grid, i + 1, j);
        dfsLands(grid, i, j - 1);
        dfsLands(grid, i, j + 1);
    }


    public void setZeroes(int[][] matrix) {
        // 额外存储i,j
        /*Set<Integer> rowList = new HashSet<>();
        Set<Integer> columnList = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!rowList.contains(i)) rowList.add(i);
                    if (!columnList.contains(j)) columnList.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowList.contains(i) || columnList.contains(j)) matrix[i][j] = 0;
            }
        }*/

        // 位存储(length 小于32)
        /*int r = 0, c = 0, mask = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    r |= mask << i;
                    c |= mask << j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            boolean rowFlag = ((r >> i) & mask) == mask;
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowFlag || ((c >> j) & mask) == mask)
                    matrix[i][j] = 0;
            }
        }*/

        // 打标记
        // 行首为0 标识
        boolean isCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (isCol == false && matrix[i][0] == 0)
                isCol = true;
            // 从1 开始
            for (int j = 1; j < matrix[i].length; j++) {
                // 若为0，则将行首、列首置为0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 反向遍历
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (isCol) matrix[i][0] = 0;
        }

        /*for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                // 若行首、列首为0，则为0
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // 第一行（列首）置为0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[0][j] = 0;
            }
        }
        // 行首置为0
        if (isCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }*/
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * <p>
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * 示例:
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * <p>
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *
     * @param board 矩阵
     * @auther ClownfishYang
     * created on 2020-08-12 17:35:46
     */
    public void aroundChar(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        // 打标
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        // 处理
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 越界
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length
                // 非标记
                || board[i][j] == 'X' || board[i][j] == '#')
            return;
        // 打标
        board[i][j] = '#';
        dfs(board, i - 1, j);// 上
        dfs(board, i + 1, j);// 下
        dfs(board, i, j - 1);// 左
        dfs(board, i, j + 1);//右
    }

    /**
     * 功能描述:
     * <p>
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-02 14:22:52
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            // row, column, box
            int row = 0, column = 0, box = 0;
            for (int j = 0; j < board[i].length; j++) {
                int r = board[i][j] - 48;
                if (r > 0 && (row = sodokuer(r, row)) == -1)
                    return false;
                int c = board[j][i] - 48;
                if (c > 0 && (column = sodokuer(c, column)) == -1)
                    return false;
                int b = board[3 * (i / 3) + (j / 3)][3 * (i % 3) + (j % 3)] - 48;
                if (b > 0 && (box = sodokuer(b, box)) == -1)
                    return false;
            }
        }


        /*// max box
        int R = board.length - 1;
        int C = board[board.length -1].length - 1;
        int maxBox = boxIdx(R, C);

        // row arr, column arr, box arr
        boolean[][] rowArr = new boolean[R + 1][ C + 1];
        boolean[][] columnArr = new boolean[C + 1][R + 1];
        boolean[][] boxArr = new boolean[maxBox + 1][9];

        // for each board
        for (int i = 0; i <= R; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                // row
                if (rowArr[i][val])
                    return false;
                // column
                if (columnArr[j][val]) {
                    return false;
                }
                // box
                int boxIdx = boxIdx(i, j);
                if (boxArr[boxIdx][val]) {
                    return false;
                }
                rowArr[i][val] = true;
                columnArr[j][val] = true;
                boxArr[boxIdx][val] = true;
            }
        }*/
        return true;
    }

    private int sodokuer(int n, int val) {
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }

    private int boxIdx(int rowIdx, int columnIdx) {
        // (6 7 8 -> 6) + 6 7 8 -> 2
        return (rowIdx / 3) * 3 + (columnIdx / 3);
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) >> 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 四个面
                int temp = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[i][j] = temp;

                /*int[] tmp = new int[4];
                int row = i;
                int col = j;

                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - x - 1;
                }

                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x= row;
                    row = col;
                    col = n - x - 1;
                }*/

            }
        }
    }
}
