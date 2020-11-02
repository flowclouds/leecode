//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1929 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class a_20 {
    public static void main(String[] args) {
        Solution solution = new a_20().new Solution();

        boolean valid = solution.isValid("(){}}{");
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (null == s && s.length() == 0) {
                return false;
            }

            char[] chars = s.toCharArray();

            Stack<Character> strings = new Stack<>();

            for (char aChar : chars) {
                if (aChar == '[' || aChar == '{' || aChar == '(') {
                    strings.push(aChar);
                } else {

                    boolean empty = strings.isEmpty();
                    if (empty) {
                        return false;
                    }
                    char pare = pare(aChar);
                    Character pop = strings.pop();

                    if (!pop.equals(pare)) {
                        return false;
                    }

                }
            }


            return strings.isEmpty();

        }


        public char pare(char c) {
            switch (c) {
                case ']':
                    return '[';
                case '}':
                    return '{';
                case ')':
                    return '(';
            }

            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}