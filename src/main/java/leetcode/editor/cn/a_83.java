//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 420 👎 0

package leetcode.editor.cn;

public class a_83 {
    public static void main(String[] args) {
        a_83.Solution solution = new a_83().new Solution();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        solution.deleteDuplicates(listNode);

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
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode res = head;
            while (res != null) {
                ListNode next = res.next;
                if (next != null) {
                    if (res.val == next.val) {
                        res.next = next.next;
                        continue;
                    }
                }
                res = res.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}