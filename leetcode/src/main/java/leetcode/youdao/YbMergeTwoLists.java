package leetcode.youdao;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists
 */
public class YbMergeTwoLists {
    public static void main(String[] args) {
        YbMergeTwoLists yb = new YbMergeTwoLists();
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);

        ListNode list2=new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);
        yb.mergeTwoLists(list1,list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode node = result;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            } else if (list2 == null) {
                node.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    node.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    node.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                node = node.next;
            }

        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
