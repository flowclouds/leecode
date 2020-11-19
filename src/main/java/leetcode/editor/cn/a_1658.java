//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 1 <= x <= 109 
// 
// Related Topics 贪心算法 双指针 二分查找 
// 👍 23 👎 0

package leetcode.editor.cn;

public class a_1658 {
    public static void main(String[] args) {
        a_1658.Solution solution = new a_1658().new Solution();
        int i = solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {

            int count = 0;
            int left = 0;
            int right = nums.length - 1;

            while (x > 0) {
                int temp;
                if (nums[left] > nums[right]) {
                    temp = x - nums[left];
                    if (temp >= 0) {
                        left++;
                    } else {
                        temp = x - nums[right];
                        right--;
                    }
                } else {
                    temp = x - nums[right];
                    if (temp >= 0) {
                        right--;
                    } else {
                        temp = x - nums[left];
                        left++;
                    }
                }
                count++;
                x = temp;
            }
            if (x == 0)
                return count;
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}