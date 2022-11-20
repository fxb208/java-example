package leetcode.youdao;

import java.util.List;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/solution/
 */
public class YbMergeKLists {

    public static void main(String[] args) {
        YbMergeKLists yb = new YbMergeKLists();
        ListNode[] lists = new ListNode[3];
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(4);
        node1.next.next=new ListNode(5);
        lists[0]=node1;

        ListNode node2=new ListNode(1);
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);
        lists[1]=node2;

        ListNode node3=new ListNode(2);
        node3.next=new ListNode(6);
        lists[2]=node3;

        yb.mergeKLists(lists);
        //[[1,4,5],[1,3,4],[2,6]]
    }

    public ListNode mergeKLists(ListNode[] lists) {
        while(lists.length>1){
            lists = merge(lists);
        }
        if(lists.length==0){
            return null;
        }
        return lists[0];
    }

    public ListNode[] merge(ListNode[] lists){
        int size = lists.length/2;
        ListNode[] arrNode = new ListNode[size];
        for(int i=0;i<size;i++){
            arrNode[i]=merger(lists[i],lists[lists.length-i-1]);
        }
        if(lists.length%2==1){
            arrNode[size-1]=merger(arrNode[size-1],lists[size]);
        }
        return arrNode;
    }

    public ListNode merger(ListNode node1,ListNode node2){
        ListNode result = new ListNode();
        ListNode node = result;
        while(node1 !=null || node2 !=null){
            if(node1==null){
                node.next=node2;
                break;
            }else if(node2==null){
                node.next=node1;
                break;
            }else{
                if(node1.val< node2.val){
                    node.next=new ListNode(node1.val);
                    node1 = node1.next;
                }else{
                    node.next=new ListNode(node2.val);
                    node2 = node2.next;
                }
                node=node.next;
            }
        }
        return result.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
