//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 288 👎 0

package leetcode.editor.cn;

public class a_242 {
    public static void main(String[] args) {
        a_242.Solution solution = new a_242().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int sLength = s.length();
            int tLength = t.length();
            if (sLength != tLength) return false;

            char[] chars = new char[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            for (int i = 0; i < sLength; i++) {
                chars[sChars[i] - 'a']++;
                chars[tChars[i] - 'a']--;
            }
            for (char aChar : chars) {
                if (aChar != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}