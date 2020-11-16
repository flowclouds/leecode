//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 575 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class a_406 {
    public static void main(String[] args) {
        Solution solution = new a_406().new Solution();
        int[][] ints = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {

            //排列 由数字大小由小到大降序排列  k由升序排列
            Arrays.sort(people, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            });

            List<int[]> result = new LinkedList<>();
            //循环插入链表，每次插入按照K的index插入为index
            //因为插入顺序的是有H的大→小插入 先保持其完整队列
            //后插入小H也不会影响到大H的顺序
            for (int[] person : people) {
                result.add(person[1], person);
            }

            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}