//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 475 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class a_145 {
    public static void main(String[] args) {
        Solution solution = new a_145().new Solution();
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
        private final List<Integer> res = new LinkedList<>();

        private void obtain(TreeNode root) {
            if (root == null) return;

            obtain(root.left);
            obtain(root.right);

            res.add(root.val);
        }


        public List<Integer> postorderTraversal(TreeNode root) {
            obtain(root);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}