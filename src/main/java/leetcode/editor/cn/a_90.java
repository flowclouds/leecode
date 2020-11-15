//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 340 👎 0

package leetcode.editor.cn;

import java.util.*;

public class a_90 {
    public static void main(String[] args) {
        a_90.Solution solution = new a_90().new Solution();

        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4});

        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Set<List<Integer>> res = new HashSet<>();

        private void obtain(int[] nums, int index, List<Integer> integers) {

            Arrays.sort(nums);

            for (int i = index; i < nums.length; i++) {

                integers.add(nums[i]);

                res.add(new LinkedList<>(integers));

                obtain(nums, i + 1, integers);

                integers.remove(Integer.valueOf(nums[i]));
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {

            res.clear();

            res.add(new LinkedList<>());

            obtain(nums, 0, new LinkedList<>());

            return new ArrayList<>(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}