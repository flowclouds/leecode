//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5215 👎 0

package leetcode.editor.cn;

public class a_2 {

//    public static void main(String[] args) {
//        a_2.Solution solution = new a_2().new Solution();
//
//        ListNode listNode2 = new ListNode(4);
////        ListNode listNode4 = new ListNode(9);
////        ListNode listNode3 = new ListNode(9);
////        listNode2.next = listNode4;
////        listNode4.next = listNode3;
//
//        ListNode listNode5 = new ListNode(5);
////        ListNode listNode6 = new ListNode(9);
////        ListNode listNode7 = new ListNode(9);
////        listNode5.next = listNode6;
////        listNode6.next = listNode7;
//
//        ListNode listNode = solution.addTwoNumbers(listNode2, listNode5);
//
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }
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

    static class ListNode {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode resPre = new ListNode();
            ListNode resPre1 = resPre;

            int sumTemp = 0;

            ListNode curr = null;
            while (l1 != null || l2 != null) {

                if (l1 != null) {
                    sumTemp += l1.val;
                    curr = l1;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sumTemp += l2.val;
                    curr = l2;
                    l2 = l2.next;
                }
                if (sumTemp <= 9) {
                    curr.val = sumTemp;
                    sumTemp = 0;
                } else {
                    curr.val = sumTemp % 10;
                    sumTemp = 1;
                }
                resPre1.next = curr;
                resPre1 = resPre1.next;
            }

            if (sumTemp != 0) {
                resPre1.next = new ListNode(1);
            }
            return resPre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}