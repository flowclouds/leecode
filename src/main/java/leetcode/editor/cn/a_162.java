//峰值元素是指其值大于左右相邻值的元素。
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。 
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2: 
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5 
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 说明: 
//
// 你的解法应该是 O(logN) 时间复杂度的。 
// Related Topics 数组 二分查找 
// 👍 330 👎 0


package leetcode.editor.cn;

public class a_162 {
    public static void main(String[] args) {
        Solution solution = new a_162().new Solution();
        int peakElement = solution.findPeakElement(new int[]{1});
        System.out.println(peakElement);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0;

            int right = nums.length - 1;

            while (left < right) {
                int mid = (left + right) >>> 1;

                if (nums[mid] < nums[mid + 1]) left = mid + 1;
                else right = mid;
            }

            return left;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}