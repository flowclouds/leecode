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
        String s = solution.longestCommonPrefix(new String[]{"aaa", "aa", "aaa","aaaaaaa"});
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

            String subString = strs[0];

            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                while (j < subString.length() && j < strs[i].length()) {
                    if (subString.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                    j++;
                }
                subString = subString.substring(0, j);
            }

            return subString;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}