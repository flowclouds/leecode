//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 366 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class a_107 {
    public static void main(String[] args) {
        Solution solution = new a_107().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        LinkedList<List<Integer>> res = new LinkedList<>();


        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return res;

            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);

            while (!deque.isEmpty()) {

                int size = deque.size();
                LinkedList<Integer> integers = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    integers.addLast(poll.val);
                    if (poll.left != null) deque.offer(poll.left);
                    if (poll.right != null) deque.offer(poll.right);
                }
                res.addFirst(integers);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}