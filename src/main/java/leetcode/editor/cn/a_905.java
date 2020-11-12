//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 176 👎 0


package leetcode.editor.cn;

public class a_905 {
    public static void main(String[] args) {
        Solution solution = new a_905().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] A) {

            int length = A.length;
            int[] ints = new int[length];

            int jishu = 0;
            int oushu = length - 1;
            for (int a : A) {
                if (a % 2 == 0) {
                    ints[jishu] = a;
                    jishu++;
                } else {
                    ints[oushu] = a;
                    oushu--;
                }
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}