//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 877 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_78 {
    public static void main(String[] args) {
        a_78.Solution solution = new a_78().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1});

        System.out.println(subsets);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Solution() {
        }

        private void obtain(int[] nums, int index, List<Integer> lastRes) {

            for (int i = index; i < nums.length; i++) {
                lastRes.add(nums[i]);
                res.add(new ArrayList<>(lastRes));

                obtain(nums, i + 1, lastRes);

                lastRes.remove(Integer.valueOf(nums[i]));
            }
        }

        private final List<List<Integer>> res = new LinkedList<>();


        public List<List<Integer>> subsets(int[] nums) {

            res.clear();

            res.add(new ArrayList<>());

            obtain(nums, 0, new LinkedList<>());

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}