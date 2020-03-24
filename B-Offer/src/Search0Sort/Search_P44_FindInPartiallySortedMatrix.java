package Search0Sort;

//一个二维数组中，每一行从左到右递增，每一列从上到下递增。输入一个整数，判断数组中是否含有该整数.
public class Search_P44_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int[][] data, int target){
        if(data == null || data.length == 0 || data[0].length == 0)
            return false;
        int rowMax = data.length - 1;
        int colMax = data[0].length - 1;
        int rowCur = data.length - 1;
        int colCur = 0;
        while(true){
            if(rowCur<0 || rowCur>rowMax || colCur<0 || colCur>colMax)
                return false;
            if(data[rowCur][colCur] == target)
                return true;
            else if(data[rowCur][colCur] > target)
                rowCur--;
            else
                colCur++;
        }
    }

    public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        System.out.println(findInPartiallySortedMatrix(data, 10));
    }
}
