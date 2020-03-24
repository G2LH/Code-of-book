import java.util.LinkedList;
import java.util.Queue;

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
public class DFS_IslandNum {
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
            grid[i][j] = '0';
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
