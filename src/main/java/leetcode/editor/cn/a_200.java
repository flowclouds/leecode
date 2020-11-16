//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 855 👎 0


package leetcode.editor.cn;

public class a_200 {
    public static void main(String[] args) {
        Solution solution = new a_200().new Solution();
        int i = solution.numIslands(new char[][]{
                {'0', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}});

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] booleans = null;

        int m, n, total = 0;

        private boolean obtain(char[][] grid, int index, int x, int y) {
            //剪枝条件 判断数组是否越界 是否被浏览过  是否为0
            if (y < 0 || y >= n || x < 0 || x >= m || booleans[x][y] || grid[x][y] == '0') {
                return false;
            }

            booleans[x][y] = true;

            //递归标记
            obtain(grid, index + 1, x - 1, y);
            obtain(grid, index + 1, x + 1, y);
            obtain(grid, index + 1, x, y + 1);
            obtain(grid, index + 1, x, y - 1);

            //能进入到这里就肯定有一块陆地
            return true;
        }

        public int numIslands(char[][] grid) {

            m = grid.length;
            n = grid[0].length;

            booleans = new boolean[m][n];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    boolean obtain = obtain(grid, 0, i, j);
                    if (obtain) total++;
                }
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}