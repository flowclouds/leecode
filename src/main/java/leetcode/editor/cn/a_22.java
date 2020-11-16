//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1416 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class a_22 {
    public static void main(String[] args) {
        Solution solution = new a_22().new Solution();

        List<String> strings = solution.generateParenthesis(3);

        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new LinkedList<>();

        private void obtain(String str, int left, int right, int total) {
            if (right == total) {
                res.add(str);
                return;
            }

            if (left < total)
                obtain(str + '(', left + 1, right, total);
            if (right < left)
                obtain(str + ')', left, right + 1, total);
        }

        public List<String> generateParenthesis(int n) {

            obtain("", 0, 0, n);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}