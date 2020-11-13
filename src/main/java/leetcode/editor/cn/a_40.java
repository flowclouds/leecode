//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 441 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class a_40 {
    public static void main(String[] args) {
        Solution solution = new a_40().new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> resList = new LinkedList<>();

        private void obtain(int[] candidates, List<Integer> res, int index, int target) {
            int sum = res.stream().mapToInt(a -> a).sum();
            if (sum > target) {
                return;
            }
            if (target == sum) {
                resList.add(res);
            }

            for (int i = index; i < candidates.length; i++) {
                List<Integer> newRes = new LinkedList<>(res);
                newRes.add(candidates[i]);
                obtain(candidates, newRes, index + 1, target);
            }

        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            resList.clear();

            obtain(candidates, new LinkedList<>(), 0, target);

            return resList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}