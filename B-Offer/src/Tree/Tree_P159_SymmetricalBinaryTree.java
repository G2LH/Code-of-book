package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_P159_SymmetricalBinaryTree {
    //递归
    public static boolean isSymmetrical(TreeNode<Integer> head){
        if(head == null)
            return true;
        if(head.left == null && head.right == null)
            return true;
        if(head.left == null || head.right == null)
            return false;
        return isSymmetrical(head.left, head.right);
    }
    public static boolean isSymmetrical(TreeNode<Integer> head1, TreeNode<Integer> head2){
        if(head1 == null && head2 == null)
            return true;
        if(head1 == null || head2 == null)
            return false;
        if(head1.val != head2.val)//两点不同，树肯定不对称；两点相同，树不一定对称
            return false;
        return isSymmetrical(head1.left, head2.right) && isSymmetrical(head1.right, head2.left);
    }

    //迭代
    public static boolean isSymmetrical2(TreeNode<Integer> head){
        if(head == null)
            return true;
        if(head.left == null && head.right == null)
            return true;
        if(head.left == null || head.right ==null)
            return false;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.offer(head.left);
        right.offer(head.right);
        TreeNode<Integer> tempLeft, tempRight;
        while(!left.isEmpty() || !right.isEmpty()){
            tempLeft = left.poll();
            tempRight = right.poll();
            if(tempLeft.val != tempRight.val)
                return false;
            if(tempLeft.left != null)
                left.offer(tempLeft.left);
            if(tempLeft.right != null)
                left.offer(tempLeft.right);
            if(tempRight.left != null)
                right.offer(tempRight.left);
            if(tempRight.right != null)
                right.offer(tempRight.right);
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(11);
        System.out.println(isSymmetrical(root));
        System.out.println(isSymmetrical2(root));

    }

}
