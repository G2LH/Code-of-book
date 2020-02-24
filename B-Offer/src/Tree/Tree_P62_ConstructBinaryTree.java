package Tree;
/**
 * 重建二叉树:
 * 前序+中序，后续+中序可以完成重建，而前序+后序无法完成
 */
public class Tree_P62_ConstructBinaryTree {
    public static TreeNode construct(int[] inOrder, int[] postOrder){
        /*if(preOrder == null || inOrder == null || preOrder.length!=inOrder.length || preOrder.length == 0)
            return null;
        return constructPreAndIn(preOrder, 0, inOrder, 0, inOrder.length );*/
        if(inOrder == null || postOrder == null || inOrder.length!=postOrder.length || postOrder.length == 0)
            return null;
        return constructInAndPost(postOrder, postOrder.length - 1, inOrder, 0, postOrder.length );
    }
    //Pre+In
    public static TreeNode constructPreAndIn(int[] preOrder, int pre_start, int[] inOrder, int in_start, int length){

        if(length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[pre_start]);//存入节点
        int index = -1;
        for(int i=in_start;i<=in_start+length;i++){//从中序遍历开始，寻找和根节点相同的元素。
            if(inOrder[i]==preOrder[pre_start]){//找到了之后分为左右子树，递归进行查找。
                index = i;
                break;
            }
        }
        int left_length = index - in_start;
        node.left=constructPreAndIn(preOrder,pre_start+1, inOrder, in_start,left_length);
        node.right=constructPreAndIn(preOrder,pre_start + left_length + 1,inOrder,index+1,length - left_length -1);
        return node;
    }

    //In+Post
    public static TreeNode constructInAndPost(int[] postOrder, int post_start, int[] inOrder, int in_start, int length){
        if(length == 0){
            return null;
        }
        TreeNode node = new TreeNode(postOrder[post_start]);//存入节点
        int index = -1;
        for(int i = in_start; i < in_start + length; i++){
            if(inOrder[i] == postOrder[post_start]){
                index = i;
                break;
            }
        }
        int left_length = index - in_start;
        int right_length = length - left_length - 1;
        node.left = constructInAndPost(postOrder,post_start-right_length-1,inOrder,in_start,left_length);
        node.right = constructInAndPost(postOrder,post_start - 1,inOrder,index+1,right_length);
        return node;
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre={1,2,3,4,5};
        int[] in={4,2,5,1,3};
        int[] post={4,5,2,3,1};
        TreeNode root = construct(in,post);
        //对重建后的树,进行前中后序遍历，验证是否重建正确

        Tree_P60_TraversalOfBinaryTree.preOrderIterative(root);
        System.out.println();
        Tree_P60_TraversalOfBinaryTree.inOrderIterative(root);
        System.out.println();
        Tree_P60_TraversalOfBinaryTree.postOrderIterative(root);

    }
}
