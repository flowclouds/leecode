//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 667 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a_51 {
    public static void main(String[] args) {
        Solution solution = new a_51().new Solution();

        List<List<String>> lists = solution.solveNQueens(4);

        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<List<String>> res = new ArrayList<>();

        private void obtain(char[][] used, int y, int total) {
            //递归退出条件
            if (y == total) {
                res.add(arrayToString(used));
                return;
            }

            //循环控制
            for (int i = 0; i < total; i++) {

                //判断是否满足填充条件如不能满足 则进入下一行
                if (checkQ(used, i, y)) {
                    used[i][y] = 'Q';
                    obtain(used, y + 1, total);
                    used[i][y] = '.';
                }
            }
        }

        private boolean checkQ(char[][] used, int x, int y) {

            //判断X轴是否包含Q
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

        //将数组转换为字符串
        private List<String> arrayToString(char[][] used) {

            List<String> stringList = new LinkedList<>();

            for (char[] chars : used) {
                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(aChar);
                }
                stringList.add(sb.toString());
            }
            return stringList;
        }

        public List<List<String>> solveNQueens(int n) {

            char[][] used = new char[n][n];

            //将默认数组填充为 .
            for (int i = 0; i < used.length; i++) {
                for (int j = 0; j < used.length; j++) {
                    used[i][j] = '.';
                }
            }
            //从第0行开始渲染
            obtain(used, 0, n);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}