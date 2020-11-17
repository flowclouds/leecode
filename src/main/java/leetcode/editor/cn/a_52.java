//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 211 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class a_52 {
    public static void main(String[] args) {
        Solution solution = new a_52().new Solution();
        int i = solution.totalNQueens(4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int sum = 0;

        private void obtain(char[][] used, int y, int total) {
            //退出条件
            if (y == total) {
                sum++;
                return;
            }

            for (int i = 0; i < total; i++) {
                if (checkQ(used, i, y)) {
                    used[i][y] = 'Q';
                    obtain(used, y + 1, total);
                    used[i][y] = '.';
                }
            }
        }

        private boolean checkQ(char[][] used, int x, int y) {
            //判断X轴
            for (int i = 0; i < used.length; i++) {
                if (used[i][y] == 'Q') {
                    return false;
                }
            }

            //判断Y轴是否包含Q
            for (int i = 0; i < used[x].length; i++) {
                if (used[x][i] == 'Q') {
                    return false;
                }
            }

            //判断左斜上方是否包含Q
            for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
                if (used[i][j] == 'Q') {
                    return false;
                }
            }

            //判断右斜上方是否包含Q
            for (int i = x, j = y; i < used.length && j >= 0; i++, j--) {
                if (used[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        public int totalNQueens(int n) {
            char[][] used = new char[n][n];
            //填充
            for (char[] chars : used) {
                Arrays.fill(chars, '.');
            }

            obtain(used, 0, n);

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}