//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 988 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;


public class a_17 {

    public static void main(String[] args) {
        a_17.Solution solution = new a_17().new Solution();
        List<String> strings = solution.letterCombinations("");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String[] phonesNo = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> resList = new LinkedList<>();

        private void obtainString(String digits, int index, String res) {
            if (index == digits.length()) {
                resList.add(res);
                return;
            }

            int words = digits.charAt(index) - '0';
            String s1 = phonesNo[words];
            int currindex = index + 1;

            for (int word = 0; word < s1.length(); word++) {
                String s = res + s1.charAt(word);
                obtainString(digits, currindex, s);
            }
        }

        public List<String> letterCombinations(String digits) {
            if ("".equals(digits)) {
                return resList;
            }

            obtainString(digits, 0, "");

            return resList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}