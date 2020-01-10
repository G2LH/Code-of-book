//回溯:矩阵中的路径
public class P89_StringPathInMatrix {
    public static boolean hasPath(char[][] data,String str){
        if(data==null||data.length==0||str==null||str.length()==0)
            return false;
        int rowLen = data.length;
        int colLen = data[0].length;
        //java的Boolean数组默认值是false, 不用初始化
        boolean[][] visited = new boolean[rowLen][colLen];
        //boolean[] visited = new boolean[rowLen*colLen];
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                if(hasPathCore(data,row,col,visited,str,0))
                    return true;
            }
        }
        return false;
    }
    public static boolean hasPathCore(char[][] data,int rowIndex, int colIndex,
                                      boolean[][] visited,String str,int strIndex) {
        //结束条件（字符的已匹配下标）
        if (strIndex == str.length())
            return true;
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= data.length || colIndex >= data[0].length)
            return false;
        boolean result = false;
        //递归
        if (!visited[rowIndex][colIndex] && data[rowIndex][colIndex] == str.charAt(strIndex)) {
            //如果未被访问，且匹配字符串，标记当前位置为已访问，分上下左右四个位置递归求解
            strIndex++;
            visited[rowIndex][colIndex] = true;
            //visited[row*col+col]=true;
             result = hasPathCore(data, rowIndex + 1, colIndex, visited, str, strIndex) ||
                    hasPathCore(data, rowIndex - 1, colIndex, visited, str, strIndex) ||
                    hasPathCore(data, rowIndex, colIndex + 1, visited, str, strIndex) ||
                    hasPathCore(data, rowIndex, colIndex - 1, visited, str, strIndex);
            //已经求出结果，无需修改标记了
            if (!result) {
                strIndex--;
                visited[rowIndex][colIndex] = false;
                //当前递归的路线求解失败，要把这条线路上的标记清除掉，其他起点的路径依旧可以访问本路径上的节点。
            }
        }
        return result;
    }
    public static void main(String[] args){
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(hasPath(data,"bfce")); //true
        System.out.println(hasPath(data,"abfb")); //false,访问过的位置不能再访问
    }
}

