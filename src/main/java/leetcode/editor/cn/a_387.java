//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 282 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class a_387 {
    public static void main(String[] args) {
        Solution solution = new a_387().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char item : chars) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }

            for (int i = 0; i < chars.length; i++) {
                if (map.get(chars[i]) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}