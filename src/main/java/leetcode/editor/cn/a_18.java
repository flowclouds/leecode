//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 677 👎 0


package leetcode.editor.cn;

import java.util.*;

public class a_18 {
    public static void main(String[] args) {
        Solution solution = new a_18().new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);//-2 -1 0 0 1 2
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<List<Integer>> res = new LinkedList<>();

        private void obtain(int[] nums, int target, int startIndex, int count, Deque<Integer> resTemplate) {
            int left = startIndex;
            int right = nums.length - 1;
            //双指针操作
            if (count == 2) {
                while (left < right) {
                    int template = nums[left] + nums[right];
                    if (left > startIndex && nums[left] == nums[left - 1]) left++;
                    else if (template < target) left++;
                    else if (template > target) right--;
                    else if (template == target) {
                        List<Integer> integers = new ArrayList<>(resTemplate);
                        integers.add(nums[left]);
                        integers.add(nums[right]);
                        res.add(integers);
                        left++;
                        right--;
                    }
                }
                //递归 枚举 前一个数 直到递归为2个数字时
            } else if (count > 2) {
                for (; left <= right - (count - 1); left++) {
                    if (left > startIndex && nums[left] == nums[left - 1]) continue;
                    resTemplate.addLast(nums[left]);
                    obtain(nums, target - nums[left], left + 1, count - 1, resTemplate);
                    resTemplate.removeLast();
                }
            }
        }

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            obtain(nums, target, 0, 4, new LinkedList<>());
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}