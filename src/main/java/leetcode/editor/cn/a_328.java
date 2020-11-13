//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 282 👎 0


package leetcode.editor.cn;

public class a_328 {
    public static void main(String[] args) {
        Solution solution = new a_328().new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNoderes = solution.oddEvenList(listNode);

        while (listNoderes != null) {
            System.out.println(listNoderes.val);
            listNoderes = listNoderes.next;
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode jishuHead = new ListNode();
            ListNode jishucurr = jishuHead;
            ListNode oushuHead = new ListNode();
            ListNode oushucurr = oushuHead;
            int time = 0;
            while (head != null) {
                ListNode temp = head.next;
                if (time % 2 == 0) {
                    jishucurr.next = head;
                    jishucurr = jishucurr.next;
                } else {
                    oushucurr.next = head;
                    oushucurr = oushucurr.next;
                }
                time++;
                head = temp;
            }

            jishucurr.next = oushuHead.next;
            oushucurr.next = null;
            return jishuHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}