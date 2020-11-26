//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 303 👎 0


package leetcode.editor.cn;

public class a_153 {
    public static void main(String[] args) {
        Solution solution = new a_153().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {

            int left = 0;
            int right = nums.length - 1;

            //找最小值
            while (left < right) {
                int mid = left + (right - left) / 2;

                //最小值在左边
                if (nums[mid] > nums[right]) left = mid + 1;
                else right = mid;
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}