//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 251 👎 0


package leetcode.editor.cn;

public class a_81 {
    public static void main(String[] args) {
        Solution solution = new a_81().new Solution();
        boolean search = solution.search(new int[]{1, 3, 1, 1, 1}, 3);
        System.out.println(search);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0) return false;
            if (nums.length == 1) return nums[0] == target;

            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return true;
                    //不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
                else if (nums[left] == nums[mid]) {
                    left++;
                }
                //前半段有序
                else if (nums[left] <= nums[mid])
                    if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                    else left = mid + 1;
                    //后半段有序
                else if (nums[left] > nums[mid])
                    if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                    else right = mid - 1;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}