//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横
//坐标就足够了。开始坐标总是小于结束坐标。 
//
// 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xsta
//rt ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的
//最小数量。 
//
// 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球 
//
// 示例 2： 
//
// 
//输入：points = [[1,2],[3,4],[5,6],[7,8]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,2],[2,3],[3,4],[4,5]]
//输出：2
// 
//
// 示例 4： 
//
// 
//输入：points = [[1,2]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：points = [[2,3],[2,3]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= points.length <= 104 
// points[i].length == 2 
// -231 <= xstart < xend <= 231 - 1 
// 
// Related Topics 贪心算法 排序 
// 👍 200 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class a_452 {
    public static void main(String[] args) {
        Solution solution = new a_452().new Solution();
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}});
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{-10, 16}, {-2, 8}, {-1, 6}, {-7, 12}});
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{1, 2}, {4, 5}, {1, 5}});
        int minArrowShots = solution.findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}});
        System.out.println(minArrowShots);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int findMinArrowShots(int[][] points) {

            List<int[]> collect = Arrays.stream(points).sorted(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt((int[] arr) -> arr[1])).collect(Collectors.toList());
//                Arrays.sort(points, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] o1, int[] o2) {
//                        if (o1[0] == o2[0]) {
//                            return o1[1] - o2[1];
//                        }
//                        return o1[0] - o2[0];
//                    }
//                });

//            for (int[] ints : collect) {
//                System.out.print("[");
//                for (int anInt : ints) {
//                    System.out.print(anInt);
//                    System.out.print("'");
//                }
//                System.out.print("]");
//                System.out.print("'");
//            }
            //2147483646
            //2147483648
            final int START = 0;
            final int DOING = 1;
            int shots = 0;
            int right = Integer.MIN_VALUE;
            int left = Integer.MIN_VALUE;

            int status = START;

            for (int[] point : collect) {
                switch (status) {
                    case START:
                        right = point[1];
                        left = point[0];
                        shots++;
                        status = DOING;
                        break;
                    case DOING:
                        if (point[0] > right || point[1] < left) {
                            shots++;
                            right = point[1];
                            left = point[0];
                        } else {
                            right = Math.min(right, point[1]);
                            left = Math.max(left, point[0]);
                        }
                        break;
                }
            }
            return shots;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

