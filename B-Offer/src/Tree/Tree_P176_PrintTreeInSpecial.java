package Tree;
//之字形打印二叉树

//题目要求：
//请实现一个函数按照之字形打印二叉树。即第一层从左到右打印，第二层从右到左打印，第三层继续从左到右，以此类推。
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree_P176_PrintTreeInSpecial {
    //从上到下不分行打印
    public static void printTree1(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode<Integer> temp = q.poll();
            System.out.print(temp.val);
            if(temp.left != null){
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
        }
    }
    //从上到下分行打印,提前确定队列容量
    public static void printTree2(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        TreeNode<Integer> temp;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            for (int s = q.size(); s > 0; s--){
                temp = q.poll();
                System.out.print(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    //之字形打印
    //第k行从左到右打印，第k+1行从右到左打印，可以比较容易想到用两个栈来实现。
    //另外要注意，根据是从左到右还是从右到左访问的不同，压入左右子节点的顺序也有所不同。

    //每层添加一个null 判断该层结束， 用BFS来做
    public static void printTree3(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode<Integer> temp;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
                while (!s1.isEmpty()) {
                    temp = s1.pop();
                    System.out.print(temp.val);
                        if (temp.left != null) {
                            s2.push(root.left);
                        }
                        if (temp.right != null) {
                            s2.push(root.right);
                        }
                }
                while (!s2.isEmpty()) {
                    temp = s2.pop();
                    System.out.print(temp.val);
                        if (temp.right != null) {
                            s1.push(temp.right);
                        }
                        if (temp.left != null) {
                            s1.push(temp.left);
                        }
                }
            }
    }

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(5);
        printTree1(root);
        System.out.println();
        printTree3(root);
    }
}
