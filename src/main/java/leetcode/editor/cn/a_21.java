//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1359 👎 0

package leetcode.editor.cn;

public class a_21 {
    public static void main(String[] args) {
        a_21.Solution solution = new a_21().new Solution();
        ListNode listNode2 = new ListNode(4);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        listNode2.next = listNode4;
        listNode4.next = listNode3;

        ListNode listNode5 = new ListNode(10);
//        ListNode listNode6 = new ListNode(9);
//        ListNode listNode7 = new ListNode(9);
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;

        ListNode listNode = solution.mergeTwoLists(listNode2, listNode5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

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

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode listNode = new ListNode();
            ListNode curr = listNode;

            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    curr.next = l2;
                    l2 = l2.next;
                    curr = curr.next;
                } else if (l2 == null) {
                    curr.next = l1;
                    l1 = l1.next;
                    curr = curr.next;
                } else {
                    if (l1.val > l2.val) {
                        curr.next = l2;
                        l2 = l2.next;
                        curr = curr.next;
                        if (l2 == null || (l2.val > l1.val)) {
                            curr.next = l1;
                            l1 = l1.next;
                            curr = curr.next;
                        }
                    } else {
                        curr.next = l1;
                        l1 = l1.next;
                        curr = curr.next;
                        if (l1 == null || (l1.val > l2.val)) {
                            curr.next = l2;
                            l2 = l2.next;
                            curr = curr.next;
                        }
                    }
                }
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}