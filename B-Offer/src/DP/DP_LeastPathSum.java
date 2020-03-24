package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//与不同路径的动态方程差不多：dp[i][j] = dp[i-1][j] + dp[i][j-1]
public class DP_LeastPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(i == 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                else if(j == 0){
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else{
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
