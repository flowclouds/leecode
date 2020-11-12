//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 140 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class a_922 {
    public static void main(String[] args) {
        Solution solution = new a_922().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParityII(int[] A) {

            int[] ints = new int[A.length];
            int oushuIndex = 0;
            int jishuIndex = 1;

            for (int j : A) {
                if (j % 2 == 0) {
                    ints[oushuIndex] = j;
                    oushuIndex += 2;
                } else {
                    ints[jishuIndex] = j;
                    jishuIndex += 2;
                }
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}