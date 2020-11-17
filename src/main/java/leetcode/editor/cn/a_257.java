//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 398 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class a_257 {
    public static void main(String[] args) {
        Solution solution = new a_257().new Solution();
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

        private final LinkedList<String> res = new LinkedList<>();

        private void obtain(TreeNode root, LinkedList<Integer> list) {
            if (root == null) return;

            list.addLast(root.val);

            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();

                for (Integer integer : list) {
                    sb.append(integer);
                    sb.append("->");
                }
                sb.delete(sb.length() - 2, sb.length());
                res.add(sb.toString());
            }

            obtain(root.left, list);
            obtain(root.right, list);
            list.removeLast();

        }

        public List<String> binaryTreePaths(TreeNode root) {
            res.clear();

            obtain(root, new LinkedList<>());

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}