package Tree;
//二叉搜索树的第k大节点
public class Tree_P269_KthNodeInBST {
    private static int count = 0;
    private static TreeNode node = null;
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k == 0 || pRoot == null){
            return null;
        }
        InOrderKthNode(pRoot,k);
        return node;
    }
    public static void InOrderKthNode(TreeNode pRoot, int k){
        if(pRoot.left!=null){
            InOrderKthNode(pRoot.left,k);
        }
        if (++count == k) {
            node = pRoot;
        }
        if(pRoot.right!=null){
            InOrderKthNode(pRoot.right,k);
        }
    }
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        System.out.println(KthNode(root,3).val);
        //System.out.println(KthNode(root,6).val);
    }
}
