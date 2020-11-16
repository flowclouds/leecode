//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 682 👎 0


package leetcode.editor.cn;

public class a_79 {
    public static void main(String[] args) {
        Solution solution = new a_79().new Solution();
        boolean abcced = solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "");
        System.out.println(abcced);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //标记是否使用
        boolean[][] used = null;
        private int m, n;

        private boolean match(char[][] board, String word, int index, int X, int Y) {

            if (word.length() == index) {
                return true;
            }

            //剪枝
            //如果数组越界 单词不等 访问的单词已被使用 就不在访问进行下一次访问
            if (X >= m || X < 0 || Y >= n || Y < 0 || board[X][Y] != word.charAt(index) || used[X][Y]) {
                return false;
            }

            //递归回溯
            //标记访问
            used[X][Y] = true;

            boolean res = match(board, word, index + 1, X + 1, Y) ||
                    match(board, word, index + 1, X - 1, Y) ||
                    match(board, word, index + 1, X, Y + 1) ||
                    match(board, word, index + 1, X, Y - 1) ||
                    match(board, word, index + 1, X + 1, Y);
            //res为false 就回溯
            used[X][Y] = false;

            return res;
        }

        public boolean exist(char[][] board, String word) {

            m = board.length;
            n = board[0].length;
            used = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (match(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}