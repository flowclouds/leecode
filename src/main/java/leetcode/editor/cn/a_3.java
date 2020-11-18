//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4597 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class a_3 {
    public static void main(String[] args) {
        a_3.Solution solution = new a_3().new Solution();
        int count = solution.lengthOfLongestSubstring("abcabcbbasdfsdafdsfdsfsdfsdafsdfasdf");
        System.out.println(count);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int lengthMax = 0;
            int left = 0;

            Deque<Character> deque = new LinkedList<>();
            for (int right = 0; right < s.length(); right++) {

                char o = s.charAt(right);
                boolean contains = deque.contains(o);

                //判断是否包含
                //如果包含 左指针直接移动到 移除和 o 相同的位置为止
                if (contains) {
                    while (deque.size() > 0) {
                        Character poll = deque.poll();
                        left++;
                        if (poll == o) break;
                    }
                }
                //移动右指针
                deque.offer(o);
                lengthMax = Math.max(lengthMax, right - left + 1);
            }

            return lengthMax;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}