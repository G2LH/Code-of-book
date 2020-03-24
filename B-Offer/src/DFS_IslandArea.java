//给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
//
//找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。
public class DFS_IslandArea {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1){
                        max = Math.max(max,dfs(grid,i,j));
                    }
                }
            }
            return max;
        }
        public int dfs(int[][] grid, int i, int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
                return 0;
            }
            if(grid[i][j] == 1){
                grid[i][j] = 0;//可以用visited替代
                return 1 + dfs(grid,i-1,j) + dfs(grid,i+1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1);
            }
            return 0;
        }
}
