package Tree;
//二叉树的镜像
//题目要求：求一棵二叉树的镜像。
public class Tree_P151_MirrorOfBinaryTree {
    public static void mirrorRecursively(TreeNode<Integer> head){
        if(head == null)
            return;
        if(head.left == null && head.right == null)
            return;
        TreeNode tempNode = head.left;
        head.left = head.right;
        head.right = tempNode;
        if(head.left != null)
            mirrorRecursively(head.left);
        if(head.right != null)
            mirrorRecursively(head.right);
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(11);
        System.out.println(root);
        mirrorRecursively(root);
        System.out.println(root);
    }
}