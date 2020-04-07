import java.util.ArrayDeque;
import java.util.Queue;
//BFS 可以看成是层序遍历。从某个结点出发，BFS 首先遍历到距离为 1 的结点，然后是距离为 2、3、4…… 的结点。因此，BFS 可以用来求最短路径问题。BFS 先搜索到的结点，一定是距离最近的结点。

//你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
//        我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
//        如果我们的地图上只有陆地或者海洋，请返回 -1。
public class BFS_Map {
    //对于图的BFS也是一样滴～ 与Tree的BFS区别如下：
    //1、tree只有1个root，而图可以有多个源点，所以首先需要把多个源点都入队。
    //2、tree是有向的因此不需要标志是否访问过，而对于无向图来说，必须得标志是否访问过！
    //并且为了防止某个节点多次入队，需要在入队之前就将其设置成已访问！
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        if (q.size() == m * n || q.size() == 0) {
            return -1;
        }
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋
        int distance = -1;
        while (!q.isEmpty()) {
            distance++;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] cell = q.poll();
                // 取出队列的元素，将其四周的海洋入队。
                for (int j = 0; j < 4; j++) {
                    int x = cell[0] + dx[j];
                    int y = cell[1] + dy[j];
                    if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] != 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return distance;
    }
}
