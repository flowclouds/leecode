//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 670 👎 0


package leetcode.editor.cn;

public class a_34 {
    public static void main(String[] args) {
        Solution solution = new a_34().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) {
                    right = left = mid;
                    while (left >= 0 && nums[left] == target) {
                        left--;
                    }
                    while (right < nums.length && nums[right] == target) {
                        right++;
                    }

                    return new int[]{++left, --right};

                }
                if (nums[mid] < target) left = mid + 1;
                if (nums[mid] > target) right = mid - 1;
            }

            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}