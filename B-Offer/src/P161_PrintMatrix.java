//顺时针打印矩阵
//顺时针打印矩阵
//题目要求：输入一个矩阵，按照从外向里以顺时针的顺序一次打印出每一个数字
public class P161_PrintMatrix {
    public static  void printMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int i = 0, j = 0;
        while(left <= right && up <= down){
            //从左向右走
            if(left <= right && i == up){
                while(j <= right){
                    System.out.println(matrix[i][j]);
                    j++;
                }
                up++;//边界缩短
                j--;//j多加了1
                i++;//防止重复走
            }

            //从上向下走
            if(up <= down && j == right){
                while(i <= down ){
                    System.out.println(matrix[i][j]);
                    i++;
                }
                j--;
                i--;
                right--;
            }

            //从右往左走
            if(right >= left && i == down){
                while(j >= left){
                    System.out.println(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                down--;
            }

            //从下往上走
            if(down >= up && j == left){
                while(i >= up){
                    System.out.println(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                left++;
            }
        }
    }
    public static void main(String[] args){
        int[][] matr= {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        printMatrix(matr);
    }
}
