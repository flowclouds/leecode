//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 
// 👍 162 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class a_389 {
    public static void main(String[] args) {
        Solution solution = new a_389().new Solution();
        char theDifference = solution.findTheDifference("abcd", "abcde");
        System.out.println(theDifference);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }

            char[] chars2 = t.toCharArray();
            Map<Character, Integer> map2 = new HashMap<>();
            for (char aChar : chars2) {
                map2.put(aChar, map2.getOrDefault(aChar, 0) + 1);
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : map2.entrySet()) {
                Character key = characterIntegerEntry.getKey();
                Integer integer = map.get(key);
                if (!characterIntegerEntry.getValue().equals(integer)) {
                    return key;
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}