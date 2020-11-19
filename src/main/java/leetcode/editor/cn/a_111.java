//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 403 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class a_111 {
    public static void main(String[] args) {
        Solution solution = new a_111().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public int minDepth(TreeNode root) {
            int res = 0;

            if (root == null) return res;

            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            deque.offer(root);

            while (!deque.isEmpty()) {
                res++;
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();

                    if (poll.left == null && poll.right == null) {
                        return res;
                    }

                    if (poll.left != null) deque.offer(poll.left);
                    if (poll.right != null) deque.offer(poll.right);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}