//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
public class Matrix {
        public void rotate(int[][] matrix) {
            if(matrix == null || matrix.length < 2){
                return;
            }
            //先转置
            for(int i = 0; i < matrix.length; i++){
                for(int j = i; j < matrix.length; j++){
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
            //再对称交换
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-j-1];
                    matrix[i][matrix.length-j-1] = temp;
                }
            }
        }
}
