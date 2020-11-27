//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2757 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class a_15 {
    public static void main(String[] args) {
        Solution solution = new a_15().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //[-4, -1, -1, 0, 1, 2]
            Arrays.sort(nums);

            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                //保证第一个数不从复
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                else {
                    int template = nums[i];
                    //改为twosum求和
                    int left = i + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        if (left - 1 > i && nums[left] == nums[left - 1]) left++;
                        else if (nums[left] + nums[right] + template < 0) {
                            left++;
                        } else if (nums[left] + nums[right] + template > 0) {
                            right--;
                        } else if (nums[left] + nums[right] == -template) {
                            List<Integer> resItem = new ArrayList<>();
                            resItem.add(template);
                            resItem.add(nums[left]);
                            resItem.add(nums[right]);
                            res.add(resItem);
                            left++;
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}