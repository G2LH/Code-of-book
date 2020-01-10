package P60_BinaryTree;

import java.util.*;

public class P60_TraversalOfBinaryTree {

    public static void visit(TreeNode node){
        System.out.print(node.val+" ");
    }

    //前序遍历递归版
    public static void preOrderRecursion(TreeNode<Integer> node){
        if(node==null) //如果结点为空则返回
            return;
        visit(node);//访问根节点
        preOrderRecursion(node.left);//访问左孩子
        preOrderRecursion(node.right);//访问右孩子
    }
    //中序遍历递归版
    public static void inOrderRecursion(TreeNode<Integer> node){
        if(node==null) //如果结点为空则返回
            return;
        inOrderRecursion(node.left);//访问左孩子
        visit(node);//访问根节点
        inOrderRecursion(node.right);//访问右孩子
    }
    //后序遍历递归版
    public static void postOrderRecursion(TreeNode<Integer> node){
        if(node==null) //如果结点为空则返回
            return;
        postOrderRecursion(node.left);//访问左孩子
        postOrderRecursion(node.right);//访问右孩子
        visit(node);//访问根节点
    }

    //前序遍历非递归版
    public static void preOrderIterative(TreeNode<Integer> node){
        //stack栈顶元素永远为cur的父节点
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        if(node == null)
            return;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while(cur != null||!stack.isEmpty()){
            // 若当前考查节点非空，则visit该点
            // 由考查顺序得知，需要一直往左走
            if(cur!=null){
                visit(cur);
                // 为了之后能找到该节点的右子树，暂存该节点
                stack.push(cur);
                cur = cur.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，cur等于该节点的右子树
            else{
                cur = stack.pop().right;
            }
        }
    }
    //中序遍历非递归版（和前序相似）
    public static void inOrderIterative(TreeNode<Integer> node){
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        while(cur != null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                visit(cur);
                cur = cur.right;
            }
        }
    }
    //后序遍历非递归版
    public static void postOrderIterative(TreeNode<Integer> node){
        //stack栈顶元素永远为cur的父节点
        //prevVisted用于区分是从左子树还是右子树返回的
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        TreeNode<Integer> preVisited = null;
        while(cur != null||!stack.isEmpty()){
            //遍历左子树
            while(cur!=null){
                stack.push(cur);// 为了之后能找到该节点的右子树，存储节点到栈中
                cur = cur.left;
            }
            //其右子树不为空并且右子树未访问，遍历右子树
            cur = stack.peek();
            if(cur.right!=null && cur.right!=preVisited){
                cur = cur.right;
            }
            //否则,visit该节点
            else {
                visit(cur);
                preVisited = stack.pop();
                cur = null;
            }
        }
    }
    //层序遍历
    public static void levelorder(TreeNode<Integer> node){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> temp = null;
        if(node==null)
            return;
        queue.add(node);
        while(!queue.isEmpty()){
            //取出并访问父节点
            temp = queue.poll();
            visit(temp);
            //将左右叶节点入队
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
    }
    public static void main(String[] args){
        //            1
        //              \
        //               2
        //              /
        //             3
        //pre->123  in->132   post->321  level->123
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(2);
        root.right.left = new TreeNode<Integer>(3);
        postOrderRecursion(root);
        System.out.println();
        preOrderIterative(root);
        System.out.println();
        levelorder(root);
    }
}
