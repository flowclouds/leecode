//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 698 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a_102 {
    public static void main(String[] args) {
        a_102.Solution solution = new a_102().new Solution();

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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {

                List<Integer> integers = new LinkedList<>();

                //这里的size 应该先拿出变量保存起来，应为size 是不停变化的
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();//出栈
                    integers.add(cur.val);
                    if (cur.left != null){
                        queue.offer(cur.left);
                    }
                    if (cur.right != null){
                        queue.offer(cur.right);
                    }
                }

                res.add(integers);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}