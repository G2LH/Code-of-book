package Tree;
/**
 * 重建二叉树:
 * 前序+中序，后续+中序可以完成重建，而前序+后序无法完成
 */
public class Tree_P62_ConstructBinaryTree {
    public static TreeNode construct(int[] preOrder, int[] inOrder){
        if(preOrder == null || inOrder == null || preOrder.length!=inOrder.length || preOrder.length == 0)
            return null;
        return constructCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }
    public static TreeNode constructCore(int[] preOrder, int pre_start, int pre_end, int[] inOrder, int in_start, int in_end){

        if(pre_start>pre_end||in_start>in_end){//判定是否序列是否便利完。
            return null;
        }
        TreeNode node = new TreeNode(preOrder[pre_start]);//存入节点
        for(int i=in_start;i<=in_end;i++){//从中序遍历开始，寻找和根节点相同的元素。
            if(inOrder[i]==preOrder[pre_start]){//找到了之后分为左右子树，递归进行查找。
                node.left=constructCore(preOrder,pre_start+1, pre_start + i, inOrder, in_start,i-1);
                node.right=constructCore(preOrder,pre_start + i + 1,pre_end,inOrder,i+1,in_end);
            }
        }
        return node;
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        TreeNode root = construct(pre,in);
        //对重建后的树,进行前中后序遍历，验证是否重建正确

        Tree_P60_TraversalOfBinaryTree.preOrderIterative(root);
        System.out.println();
        Tree_P60_TraversalOfBinaryTree.inOrderIterative(root);
        System.out.println();
        Tree_P60_TraversalOfBinaryTree.postOrderIterative(root);

    }
}
