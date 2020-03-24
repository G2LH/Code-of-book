package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_Summary {
    //MaxDepth
    public static int MaxDepth(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return Math.max(left,right)+1;
    }
    //MinDepth
    public static int MinDepth(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        //没有左右子树得时候
        if(root.left == null){
            return MinDepth(root.right)+1;
        }
        if(root.right == null){
            return MinDepth(root.left)+1;
        }
        //左右子树都存在得时候
        return Math.min(MinDepth(root.left),MinDepth(root.right)) + 1;
    }
    //Number of Node
    public static int NumberOfNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int left = NumberOfNode(root.left);
        int right = NumberOfNode(root.right);
        return left+right+1;
    }
    //Number of ChildNode
    public static int NumberOfChildNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = NumberOfChildNode(root.left);
        int right = NumberOfChildNode(root.right);
        return left + right;
    }
    //Number of Node in K level
    public static int NumberOfNodeInKLevel(TreeNode<Integer> root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        int numLeft = NumberOfNodeInKLevel(root.left,k-1);
        int numRight = NumberOfNodeInKLevel(root.right,k-1);
        return numLeft + numRight;
    }
    //IsBalanced(左右子树高度差不超过1)
    //后续
    public static boolean IsBalanced2(TreeNode root){
        if(root==null){
            return true;
        }
        return Depth(root)!=-1;
    }
    public static int Depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Depth(node.left);
        int right = Depth(node.right);
        if((left-right) > 1 || (right-left) >1){
            return -1;
        }
        return left>right?left+1:right+1;
    }
    //前序
    public static boolean IsBalanced(TreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if((left-right) > 1 || (right - left) < 1){
            return false;
        }
        return IsBalanced(root.left)&&IsBalanced(root.right);
    }
    public static int TreeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
    //Is Complete Tree(除最后一层，其他层都满了,如果最后一层没满，那么没满的全在右边)
    public static boolean IsCompleteTree(TreeNode<Integer> root){
        if(root == null){
            return true;
        }
        boolean leaf=false;//leaf变量用来标记是否为叶节点（只要当前节点的左孩子和右孩子都为空或者左孩子不为空，右孩子为空）
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode<Integer> cur = q.poll();
            if(leaf == true){
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
                if(cur.left == null && cur.right !=null){
                    return false;
                }
            }
            if(cur.left!=null) {//左孩子不为空，加入到队列中去
                q.offer(cur.left);
            }
            if(cur.right!=null) {//右孩子不为空，加入到队列中去
                q.offer(cur.right);
            }
            if(cur.left==null || cur.right ==null){
                leaf=true;
            }
        }
        return true;
    }
    //Is Same
    public static boolean IsSame(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){//不等肯定false，相等不一定true
            return false;
        }
        boolean left = IsSame(root1.left,root2.left);
        boolean right = IsSame(root1.right, root2.right);
        return left&&right;
    }
    //Is Mirror
    public static boolean IsMirror(TreeNode<Integer> root1,TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return true;
        }
        return IsMirror(root1.left,root2.right)&&IsMirror(root1.right,root2.left);
    }
    //mirrorTreeNode
    public static TreeNode MirrorTree(TreeNode<Integer> root){
        if(root == null){
            return root;
        }
        TreeNode left = MirrorTree(root.left);
        TreeNode right = MirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //LastCommonParent
    public static TreeNode GetLastCommonParent(TreeNode<Integer> root, TreeNode<Integer> node1,TreeNode<Integer> node2){
        if(getPath(root.right,node1)){//在右子树
            if(getPath(root.left,node2)){
                return root;
            }else{
                return GetLastCommonParent(root.left,node1,node2);
            }
        }else{//在左子树
            if(getPath(root.right,node2)){
                return root;
            }else{
                return GetLastCommonParent(root.left,node1,node2);
            }
        }
    }
    public static boolean getPath(TreeNode<Integer> root,TreeNode<Integer> node){// 查找节点node是否在当前 二叉树中
        if(root == null || node == null){
            return false;
        }
        if(root == node){
            return true;
        }
        boolean found = getPath(root.left,node);
        if(!found){
            found = getPath(root.right,node);
        }
        return found;
    }

    public static TreeNode FindLCA(TreeNode<Integer> root,TreeNode<Integer> node1,TreeNode<Integer> node2){
        if(root == null){
            return null;
        }
        //一个节点是另一个节点的祖宗
        if(root == node1 || root == node2){
            return root;
        }
        TreeNode left = FindLCA(root.left,node1,node2);
        TreeNode right = FindLCA(root.right,node1,node2);
        // 分别在左右子树
        if(left!=null&&right!=null){
            return root;
        }
        // 都在左子树或右子树
        return left!=null ? left : right;
    }
    //insertNode
    public static TreeNode InsertNode(TreeNode<Integer> root,TreeNode<Integer> node){
        if(root == null) {
            return node;
        }
        TreeNode<Integer> cur = root;
        TreeNode<Integer> last = null;
        while(cur!=null){
            last =cur;
            if(cur.val > node.val){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        if(last!=null){
            if(last.val > node.val){
                last.left = node;
            }else{
                last.right = node;
            }
        }
        return root;
    }
    //K1-K2
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> SearchRange(TreeNode<Integer> root,int k1,int k2){
        if(root == null){
            return null;
        }
        SearchRangeHelp(root,k1,k2);
        return list;
    }
    public static void SearchRangeHelp(TreeNode<Integer> root,int k1,int k2){
        if(root.val>k1){
            SearchRangeHelp(root.left,k1,k2);
        }
        if(root.val>=k1&&root.val<=k2){
            list.add(root.val);
        }
        if(root.val<k2){
            SearchRangeHelp(root.right,k1,k2);
        }
    }
    //MaxDistanceBetweenTwoNode
    //1同时在根结点的左子树中；2同时在根结点的右子树中；3左右子树中各有一个结点。
    //1.
    private static class Result{
        int maxDistance;
        int maxDepth;
        public Result() {
        }
        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }
    public static int getMaxDistance(TreeNode root){
        return getMaxDistanceResult(root).maxDistance;
    }
    public static Result getMaxDistanceResult(TreeNode root){
        if(root == null){
            Result empty = new Result(0,-1);
            return empty;
        }
        Result lmd = getMaxDistanceResult(root.left);
        Result rmd = getMaxDistanceResult(root.right);
        Result result = new Result();
        result.maxDepth = Math.max(lmd.maxDepth,rmd.maxDepth) + 1;
        result.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth,Math.max(lmd.maxDistance,rmd.maxDistance));
        return result;
    }
    //2.修改树结构
//    private static  int maxLen=0;
//    public static void findMaxDistance(TreeNode root){
//        if(root==null){
//            return;
//        }
//        if(root.left==null){
//            root.maxLeftDistance=0;
//        }
//        if(root.right==null){
//            root.maxRightDistance=0;
//        }
//        //递归计算左右子树中每个节点最长距离
//        if(root.left!=null){
//            findMaxDistance(root.left);
//        }
//        if(root.right!=null){
//            findMaxDistance(root.right);
//        }
//
//        if(root.left!=null){
//            root.maxLeftDistance=Math.max(root.left.maxLeftDistance,root.left.maxRightDistance)
//                    +1;
//        }
//
//        if(root.right!=null){
//            root.maxRightDistance=Math.max(root.right.maxLeftDistance,root.right.maxRightDistance)
//                    +1;
//        }
//
//        if(maxLen<root.maxLeftDistance+root.maxRightDistance){
//            maxLen=root.maxLeftDistance+root.maxRightDistance;
//        }
//    }

    //n个节点不同的二叉树
    public static int numTrees(int n ){
        int[] counts = new int[n+2];
        counts[0] = 1;
        counts[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                counts[i] += counts[j] * counts[i-j-1];
            }
        }
        return counts[n];
    }

    //IsBST 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    private static int last = Integer.MIN_VALUE;
    public boolean isTree(TreeNode<Integer> root){
        if(root == null)
            return true;
        if(!isTree(root.left))//不满足直接返回
            return false;
        if(root.val <= last)
            return false;
        last=root.val;//保存上一个节点
        if(!isTree(root.right))//不满足直接返回
            return false;
        return true;
    }


    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int[] nums,int l, int r){
        if(l>r){
            return null;
        }
        int mid = (l + r)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, l, mid-1);
        node.right = construct(nums,mid+1,r);
        return node;
    }

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        System.out.print(NumberOfNode(root));
    }
}
