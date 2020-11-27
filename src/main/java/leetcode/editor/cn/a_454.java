//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找 
// 👍 264 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class a_454 {
    public static void main(String[] args) {
        Solution solution = new a_454().new Solution();

        int i = solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int count = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i : A) {
                for (int j : B) {
                    int key = i + j;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            for (int i : C) {
                for (int j : D) {
                    int key = i + j;
                    Integer integer = map.get(-key);
                    if (integer != null) {
                        count += integer;
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}