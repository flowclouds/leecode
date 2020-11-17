//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 384 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_113 {
    public static void main(String[] args) {
        Solution solution = new a_113().new Solution();
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

        List<List<Integer>> res = new ArrayList<>();

        private void obtain(TreeNode root, LinkedList<Integer> integers, int sum, int temp) {
            if (root == null) return;

            temp += root.val;
            integers.addLast(root.val);
            if (root.left == null && root.right == null && temp == sum) {
                res.add(new ArrayList<>(integers));
                integers.removeLast();
                return;
            }
            obtain(root.left, integers, sum, temp);
            obtain(root.right, integers, sum, temp);
            integers.removeLast();
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {

            obtain(root, new LinkedList<>(), sum, 0);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}