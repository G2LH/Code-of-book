package P60_BinaryTree;

public class TreeNode_father {
    public int val;
    public TreeNode_father left;
    public TreeNode_father right;
    public TreeNode_father father;
    public TreeNode_father(int val){
        this.val = val;
        this.left = null;
        this.right = null;
        this.father = null;
    }
}
