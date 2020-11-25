//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 279 👎 0


package leetcode.editor.cn;

public class a_74 {
    public static void main(String[] args) {
        Solution solution = new a_74().new Solution();
        boolean b = solution.searchMatrix(new int[][]{{1, 1}}, 2);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //数组为空时应判断
            int row = matrix.length;
            if (row == 0) return false;
            int left = 0;

            //1.将数组看作为一个数组
            //2.总长度为 width*heigth 索引应该相应的-1
            //长度不应为index 数量  长度应为length
            int cloumn = matrix[0].length;
            int right = row * cloumn - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (target == matrix[mid / cloumn][mid % cloumn]) return true;
                else if (target < matrix[mid / cloumn][mid % cloumn]) right = mid - 1;
                else if (target > matrix[mid / cloumn][mid % cloumn]) left = mid + 1;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}