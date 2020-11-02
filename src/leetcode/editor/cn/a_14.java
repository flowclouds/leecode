//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1318 👎 0


package leetcode.editor.cn;

public class a_14 {
    public static void main(String[] args) {
        Solution solution = new a_14().new Solution();
        String s = solution.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            String res = "";
            int i = 0;

            while (i < strs[0].length()) {
                int j = 0;
                while (j <= strs.length - 2) {
                    if (i == strs[j].length() || i == strs[j + 1].length()) {
                        return res;
                    }
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                        return res;
                    }
                    j++;
                }
                res += strs[0].charAt(i);
                i++;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}