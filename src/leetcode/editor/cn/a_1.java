//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9508 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class a_1 {
    public static void main(String[] args) {
        Solution solution = new a_1().new Solution();
        int[] ints = {2, 5, 5, 11};
        int[] ints1 = solution.twoSum(ints, 10);
        System.out.println(Arrays.toString(ints1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ints = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 1; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (nums[i] + nums[j] == target) {
                        ints[0] = i;
                        ints[1] = j;
                        return ints;
                    }
                }
            }

            return ints;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}