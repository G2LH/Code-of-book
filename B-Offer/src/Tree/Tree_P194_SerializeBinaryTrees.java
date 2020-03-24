package Tree;
//请实现两个函数，分别用来序列化和反序列化二叉树
//  解题思路：
//  序列化是指将结构化的对象转化为字节流以便在网络上传输或写到磁盘进行永久存储的过程。反序列化是指将字节流转回结构化的对象的过程，是序列化的逆过程。
public class Tree_P194_SerializeBinaryTrees {
    public static String Serialize(TreeNode root) {
        StringBuilder strPre = new StringBuilder();
        if(root == null){
            return null;
        }
        SerializePreOrder(root,strPre);
        return strPre.toString();
    }
    public static void SerializePreOrder(TreeNode root,StringBuilder strPre){
        if(root == null){
            strPre.append('#');
            strPre.append('!');
            return;
        }else{
            strPre.append(root.val);
            strPre.append('!');
        }
        SerializePreOrder(root.left,strPre);
        SerializePreOrder(root.right,strPre);
    }
    //含有#数组序列的特点  可以单序列构造二叉树
    public static TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] s = str.split("!");
        return DesrializePreOrder(s);
    }
    private static int index = 0;//每层递归返回时 index数组继续往后遍历
    public static TreeNode DesrializePreOrder(String[] str){
        if(str[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str[index]));
        index++;
        root.left = DesrializePreOrder(str);
        root.right = DesrializePreOrder(str);
        return root;
    }
    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        System.out.println("原始树："+root);
        String result = Serialize(root);
        System.out.println("序列化结果："+result);
        TreeNode<Integer> deserializeRoot = Deserialize(result);
        System.out.println("反序列后的树："+deserializeRoot);
    }
}
