package P60_BinaryTree;

public class P65_NextNodeInBinaryTrees {
    public static TreeNode_father getNext(TreeNode_father pNode){
        if(pNode == null)
            return null;
        TreeNode_father pNext = null;
        //节点有右子树，下一跳是其右子树最左的节点
        if(pNode.right != null){
            TreeNode_father pRight = pNode.right;
            while(pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        }
        else if(pNode.father != null){
            TreeNode_father pCurrent = pNode;
            TreeNode_father pFather = pNode.father;
            //节点无右子树且是其父节点的右子树，下一跳是其父节点的左子树的节点
            while(pFather != null && pCurrent == pFather.right){
              pCurrent = pFather;
              pFather = pFather.father;
            }
            //节点无右子树且是其父节点的左子树,下一跳节点就是节点的父节点
            pNext = pFather;
        }
        return pNext;
    }
    public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNode_father root = new TreeNode_father(1);
        root.left = new TreeNode_father(2);
        root.left.father = root;
        root.right = new TreeNode_father(3);
        root.right.father = root;
        root.left.left = new TreeNode_father(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode_father(5);
        root.left.right.father = root.left;

        System.out.println(getNext(root.left.left).val);
        System.out.println(getNext(root.left).val);
        System.out.println(getNext(root.left.right).val);
        System.out.println(getNext(root).val);
        System.out.println(getNext(root.right));
    }
}
