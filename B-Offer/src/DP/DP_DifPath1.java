package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
public class DP_DifPath1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int l = obstacleGrid[0].length;
        int[][] dp = new int[r][l];
        for(int i = 0; i<r;i++){
            if(obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else{
                break;
            }
        }
        for(int j = 0; j<l;j++){
            if(obstacleGrid[0][j] != 1){
                dp[0][j] = 1;
            }else{
                break;
            }
        }
        for(int i = 1; i<r;i++){
            for(int j = 1; j<l;j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[r-1][l-1];
    }
}
