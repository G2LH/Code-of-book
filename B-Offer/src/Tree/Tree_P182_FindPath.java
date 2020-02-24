package Tree;
//二叉树中和为某一值的路径
//题目要求：
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
import java.util.ArrayList;

public class Tree_P182_FindPath {
    //递归中，全局变量的使用
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode<Integer> root, int target) {
        if(root == null){
            return result;
        }
        findInOrder(root,target);
        return result;
    }
    public static void findInOrder(TreeNode<Integer> root, int target){
        target -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && target == 0){
            result.add(new ArrayList(path));//java中添加的是引用，而path是不断变化的，所以我们要新new一个当前路径的副本出来，防止添加进去的path都是相同的
        }
        if(root.left != null){
            findInOrder(root.left,target);
        }
        if(root.right != null){
            findInOrder(root.right,target);
        }
        path.remove(path.size() - 1);//将path恢复到之前未进行左子树检查的状态
        return;
    }
    public static void main(String[] args){
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        findPath(root,22);
        System.out.print(result);
    }
}
