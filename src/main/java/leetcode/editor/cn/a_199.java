//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 361 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class a_199 {
    public static void main(String[] args) {
        a_199.Solution solution = new a_199().new Solution();

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

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> integers = new LinkedList<>();

            if (root == null) return integers;

            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    if (i == size - 1) {
                        integers.add(poll.val);
                    }
                    if (poll.left != null) deque.offer(poll.left);
                    if (poll.right != null) deque.offer(poll.right);
                }
            }
            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}