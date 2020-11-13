//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1048 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class a_39 {
    public static void main(String[] args) {
        Solution solution = new a_39().new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<List<Integer>> resList = new LinkedList<>();

        private void combin(int[] candidates, int index, List<Integer> res, int target) {
            System.out.println("开始进入");
            int sum = res.stream().mapToInt(a -> a).sum();

            if (sum > target) {
                System.out.println("不满足退出" + "index是:" + index + "\t" + "res是:" + res);
                return;
            }

            if (sum == target) {
                resList.add(res);
                System.out.println("满足退出" + "index是:" + index + "\t" + "res是:" + res);
                return;
            }

            System.out.println("进入循环");
            for (int i = index; i < candidates.length; i++) {
                System.out.println("进入循环i:" + i);
                List<Integer> integers = new LinkedList<>(res);
                integers.add(candidates[i]);
                System.out.println("integers添加元素:" + candidates[i]);
                combin(candidates, i, integers, target);
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            combin(candidates, 0, new LinkedList<>(), target);

            return resList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}