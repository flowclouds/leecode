//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ： 
//
// 
// 操作 1：交换任意两个 现有 字符。
//
// 
// 例如，abcde -> aecdb 
// 
// 
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
// 
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ） 
// 
// 
// 
//
// 你可以根据需要对任意一个字符串多次使用这两种操作。 
//
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
// 
//
// 示例 2： 
//
// 
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 示例 3： 
//
// 
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
// 
//
// 示例 4： 
//
// 
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 105 
// word1 和 word2 仅包含小写英文字母 
// 
// Related Topics 贪心算法 
// 👍 13 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class a_1657 {
    public static void main(String[] args) {
        a_1657.Solution solution = new a_1657().new Solution();
        boolean b = solution.closeStrings("abc", "bca");
        System.out.println(b);
    }

    //1、根据题目要求，两个字符串长度不一样，不能匹配
    //2、如果一个字符在另一个里没有，也不匹配
    //3、满足前两者情况下，统计字符串中字符数量，分别排序后比较
    //比如：abbzzca和babzzcz，字符数量分别为2、2、2、1和3、2、1、1则不可能匹配
    //其它情况都可以用题目两种规则匹配，
    //

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean closeStrings(String word1, String word2) {

            int aLength = word1.length();
            int bLength = word2.length();
            if (aLength != bLength) return false;

            int[] word1s = new int[26];
            int[] word2s = new int[26];

            for (int i = 0; i < aLength; i++) {
                word1s[word1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < aLength; i++) {
                word2s[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (!((word1s[i] == 0) == (word2s[i] == 0))) {
                    return false;
                }
            }
            Arrays.sort(word1s);
            Arrays.sort(word2s);
            for (int i = 0; i < 26; i++) {
                if (word1s[i] != word2s[i]) return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}