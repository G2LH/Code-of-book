package Tree;

public class Tree_P271_TreeDepth {
    //1.
    private static int max = 0;
    public static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int depth = 0;
        FindtreeDepth(root,depth);
        return max;
    }
    public static void FindtreeDepth(TreeNode node, int curDepth){
        curDepth++;
        if(curDepth > max){
            max = curDepth;
        }
        if(node.left!=null){
            FindtreeDepth(node.left,curDepth);
        }
        if(node.right!=null){
            FindtreeDepth(node.right,curDepth);
        }
        curDepth--;
        return;
    }
    //2
    public static int TreeDepth2(TreeNode<Integer> root){
        if(root==null)
            return 0;
        int left = TreeDepth2(root.left);
        int right = TreeDepth2(root.right);
        return left>right?(left+1):(right+1);
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(TreeDepth(root));
        //System.out.println(treeDepth2(root));
    }
}
