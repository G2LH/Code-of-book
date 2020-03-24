package Tree;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 * 将二叉搜索树转换为双向链表，树的left指向prev节点，树的right指向post节点
 * 左右支转换完之后要与根节点组合，所以左右支要返回自己的最小点与最大点两个节点，返回值使用数组
 */
//先中序遍历加到list里，再将list里的左右节点进行变换
public class Tree_P191_ConvertBinarySearchTree {
//    private static Stack<TreeNode> s = new Stack<TreeNode>();
//    private static Queue<TreeNode> q = new LinkedList<TreeNode>();
//    public static TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null){
//            return null;
//        }
//        ConvertInOrder(pRootOfTree);
//        pRootOfTree=q.poll();
//        while(!q.isEmpty()){
//            pRootOfTree.right = q.poll();
//            pRootOfTree = pRootOfTree.right;
//        }
//        s.pop();
//        while(!s.isEmpty()){
//            pRootOfTree.left = s.pop();
//            pRootOfTree = pRootOfTree.left;
//        }
//        return pRootOfTree;
//    }
//    public static void ConvertInOrder(TreeNode root){
//        if(root == null){
//            return ;
//        }
//        ConvertInOrder(root.left);
//        s.push(root);
//        q.offer(root);
//        ConvertInOrder(root.right);
//    }
    private static ArrayList<TreeNode> list = new ArrayList<>();
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ConvertInOrder(pRootOfTree);
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
    public static void ConvertInOrder(TreeNode pRootOfTree){
        if(pRootOfTree.left != null){
            ConvertInOrder(pRootOfTree.left);
        }
        list.add(pRootOfTree);
        if(pRootOfTree.right != null){
            ConvertInOrder(pRootOfTree.right);
        }
    }
    public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);
        TreeNode<Integer> result = Convert(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        while(result!=null){
            System.out.println(result.val);
            result = result.right;
        }
    }
}
