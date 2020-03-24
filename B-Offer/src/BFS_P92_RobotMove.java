//回溯：机器人的运动范围BFS
//题目要求：
//地上有一个m行n列的方格，一个机器人从坐标(0,0)的各自开始移动，它每次可以向上下左右移动一格，但不能进入横纵坐标数位之和大于k的格子。
public class BFS_P92_RobotMove {
    private static int count = 0;
    public static int movingCount(int m,int n,int k){
        if(k == 0) {
            return 1;
        }
        int[][] visited = new int[m][n];
        movingCountCore(k,m,n,0,0,visited);
        return count;
    }
    public static void movingCountCore(int threshold,int rows,int cols,int row,int col,int[][] visited){
        if(row >= rows || col >= cols || row < 0 || col < 0){
            return;
        }
        if(visited[row][col] == 1) {
            return;
        }
        if((row%10 + row/10 + col%10 + col/10) > threshold) {
            return;
        }
        visited[row][col] = 1;
        count++;
        movingCountCore(threshold,rows,cols,row-1,col,visited);
        movingCountCore(threshold,rows,cols,row+1,col,visited);
        movingCountCore(threshold,rows,cols,row,col-1,visited);
        movingCountCore(threshold,rows,cols,row,col+1,visited);
    }
//    public static boolean check(int threshold,int rows,int cols,int row,int col,boolean[][] visited){
//        if( row>=0 && col>=0 && row<rows
//                && col<cols && !visited[row][col]
//                && getDigitSum(row)+getDigitSum(col)<=threshold)
//            return true;
//        return false;
//    }
//    public static int getDigitSum(int number){
//        int sum = 0;
//        while(number>0){
//            sum+=number%10;
//            number/=10;
//        }
//        return sum;
//    }
    public static void main(String[] args){
        System.out.println(movingCount(3,4,0)); //1
        System.out.println(movingCount(3,4,1)); //3
        System.out.println(movingCount(2,20,9)); //39
    }
}
