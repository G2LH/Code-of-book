package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Tree_P326_CommonParentInTree {
    ////输入一棵二叉树的根节点，输入两个被观察节点，求这两个节点的最低(最近)公共祖先
    //如果p和q分别是root的左右节点，那么root就是我们要找的最近公共祖先
    //如果p和q都是root的左节点，那么返回lowestCommonAncestor(root.left,p,q)
    //如果p和q都是root的右节点，那么返回lowestCommonAncestor(root.right,p,q)
    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;

        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);

        if(leftNode==null)
            return rightNode;
        if(rightNode==null)
            return leftNode;

        return root;
    }
    //输入一棵树的根节点，输入两个被观察节点，求这两个节点的最低(最近)公共祖先
    public static class CommonTreeNode{
        public char val;
        public List<CommonTreeNode> children;
        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
        public void addChildren(CommonTreeNode... children){
            for(CommonTreeNode child:children)
                this.children.add(child);
        }
    }
    public static CommonTreeNode getLastParent2(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        CommonTreeNode lastParent = null;
        for(int i=0;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)==path2.get(i)) {
                lastParent = path1.get(i);
            }
        }
        return lastParent;
    }
    public static boolean getPath(CommonTreeNode root,CommonTreeNode node,List<CommonTreeNode> curPath){
        if(root==node)
            return true;
        curPath.add(root);
        for(CommonTreeNode child:root.children){
            if(getPath(child,node,curPath))
                return true;
        }
        curPath.remove(curPath.size()-1);
        return false;
    }

        public static void main(String[] args){
            CommonTreeNode root = new CommonTreeNode('A');
            CommonTreeNode b = new CommonTreeNode('B');
            CommonTreeNode c = new CommonTreeNode('C');
            CommonTreeNode d = new CommonTreeNode('D');
            CommonTreeNode e = new CommonTreeNode('E');
            CommonTreeNode f = new CommonTreeNode('F');
            CommonTreeNode g = new CommonTreeNode('G');
            CommonTreeNode h = new CommonTreeNode('H');
            CommonTreeNode i = new CommonTreeNode('I');
            CommonTreeNode j = new CommonTreeNode('J');
            root.addChildren(b,c);
            b.addChildren(d,e);
            d.addChildren(f,g);
            e.addChildren(h,i,j);
            System.out.println(getLastParent2(root,h,i).val);

        }
    }
