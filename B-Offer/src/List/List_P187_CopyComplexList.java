package List;

import java.util.HashMap;

public class List_P187_CopyComplexList {
    //1
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode cloned = null;
        //1复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (cur != null) {
            cloned = new RandomListNode(cur.label);
            cloned.next = cur.next;
            cur.next = cloned;
            cur = cur.next.next;
        }
        cur = pHead;
        //2重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (cur != null) {
            cloned = cur.next;
            if (cur.random == null) {
                cloned.random = null;
            } else {
                cloned.random = cur.random.next;
            }
            cur = cloned.next;
        }
        cur = pHead;
        cloned = pHead.next;
        RandomListNode pClone = pHead.next;
        //3拆分链表，将链表拆分为原链表和复制后的链表
        while (cur != null) {
            cloned = cur.next;
            cur.next = cloned.next;
            if (cloned.next != null)
                cloned.next = cloned.next.next;
            cur = cur.next;
        }
        return pClone;
    }
    //2O(n)的空间换来了O（n）的时间复杂度
    public RandomListNode Clone1(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pCloneHead = new RandomListNode(pHead.label);
        RandomListNode pCur = pHead,pClone = pCloneHead;

        //第一步，hashMap保存，原链表节点映射复制链表节点
        while(pCur != null){
            pClone.next = new RandomListNode(pCur.next.label);
            pClone = pClone.next;
            pCur = pCur.next;
            map.put(pCur,pClone);
        }

        //第二步：找到对应的m_pSibling
        pClone = pCloneHead;
        pCur = pHead;
        while(pClone!=null){
            pClone.random = map.get(pCur.random);//random也是链表节点，已经存放在map里了
            pCur = pCur.next;
            pClone = pClone.next;
        }
        return pCloneHead;
    }
    public static void main(String[] args){

    }
}


