//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 509 👎 0

package leetcode.editor.cn;

public class a_67 {
    public static void main(String[] args) {
        Solution solution = new a_67().new Solution();
        String s = solution.addBinary("1010",
                "1011");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {

            int temp = 0;

            int aLength = a.length() - 1;
            int bLength = b.length() - 1;

            StringBuilder sb = new StringBuilder();
            while (aLength >= 0 || bLength >= 0) {
                int aTemp = 0;
                int bTemp = 0;
                if (aLength >= 0) {
                    aTemp = a.charAt(aLength) - '0';
                }
                if (bLength >= 0) {
                    bTemp = b.charAt(bLength) - '0';
                }

                int sum = aTemp + bTemp + temp;
                if (sum == 1) {
                    temp = 0;
                }
                if (sum == 2) {
                    sum = 0;
                    temp = 1;
                }
                if (sum == 3) {
                    sum = 1;
                    temp = 1;
                }
                sb.insert(0, sum);
                aLength--;
                bLength--;
            }
            if (temp == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}