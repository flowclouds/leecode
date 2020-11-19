//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 817 👎 0


package leetcode.editor.cn;

public class a_283 {
    public static void main(String[] args) {
        Solution solution = new a_283().new Solution();
        solution.moveZeroes(new int[]{0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {

            //左指针
            int leftIndex = 0;

            //右指针
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == 0) {
                    continue;
                }
                if (nums[i] != 0) {
                    nums[leftIndex] = nums[i];
                    leftIndex++;
                }
            }

            //左指针完毕填充右指针数据
            while (leftIndex < nums.length) {
                nums[leftIndex] = 0;
                leftIndex++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}