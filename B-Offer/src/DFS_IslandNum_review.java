import java.util.LinkedList;
import java.util.Queue;

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
public class DFS_IslandNum_review {
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;
        }
        public void dfs(char[][] grid, int i, int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
                return;
            }
            grid[i][j] = '0';//设置为0，
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }

        //BFS
        class Solution {
            public int numIslands(char[][] grid) {
                if (grid == null || grid.length == 0) {
                    return 0;
                }

                int nr = grid.length;
                int nc = grid[0].length;
                int num_islands = 0;

                for (int r = 0; r < nr; ++r) {
                    for (int c = 0; c < nc; ++c) {
                        if (grid[r][c] == '1') {
                            ++num_islands;
                            grid[r][c] = '0'; // mark as visited
                            Queue<Integer> nei = new LinkedList<>();
                            nei.add(r * nc + c);//把坐标转换为一个数字
                            while (!nei.isEmpty()) {
                                int id = nei.remove();
                                int row = id / nc;
                                int col = id % nc;
                                if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                    nei.add((row-1) * nc + col);
                                    grid[row-1][col] = '0';
                                }
                                if (row + 1 < nr && grid[row+1][col] == '1') {
                                    nei.add((row+1) * nc + col);
                                    grid[row+1][col] = '0';
                                }
                                if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                    nei.add(row * nc + col-1);
                                    grid[row][col-1] = '0';
                                }
                                if (col + 1 < nc && grid[row][col+1] == '1') {
                                    nei.add(row * nc + col+1);
                                    grid[row][col+1] = '0';
                                }
                            }
                        }
                    }
                }

                return num_islands;
            }
        }
}

/**
 * 方法一：深度优先遍历
 */
    //           x-1,y
    //  x,y-1    x,y      x,y+1
    //           x+1,y
    // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧
//    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//    // 标记数组，标记了 grid 的坐标对应的格子是否被访问过
//    private boolean[][] marked;
//    // grid 的行数
//    private int rows;
//    // grid 的列数
//    private int cols;
//    private char[][] grid;
//    public int numIslands(char[][] grid) {
//        rows = grid.length;
//        if (rows == 0) {
//            return 0;
//        }
//        cols = grid[0].length;
//        this.grid = grid;
//        marked = new boolean[rows][cols];
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                // 如果是岛屿中的一个点，并且没有被访问过
//                // 就进行深度优先遍历
//                if (!marked[i][j] && grid[i][j] == '1') {
//                    count++;
//                    dfs(i, j);
//                }
//            }
//        }
//        return count;
//    }
//    // 从坐标为 (i,j) 的点开始进行深度优先遍历
//    private void dfs(int i, int j) {
//        marked[i][j] = true;
//        // 得到 4 个方向的坐标
//        for (int k = 0; k < 4; k++) {
//            int newX = i + directions[k][0];
//            int newY = j + directions[k][1];
//            // 如果不越界、没有被访问过、并且还要是陆地
//            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
//                dfs(newX, newY);
//            }
//        }
//    }
//    // 封装成 inArea 方法语义更清晰
//    private boolean inArea(int x, int y) {
//        // 等于号不要忘了
//        return x >= 0 && x < rows && y >= 0 && y < cols;
//    }


