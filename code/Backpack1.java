package code;

/**
 * Created by cheng on 2017/7/25.
 * <p>
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * <p>
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * <p>
 * 测试样例：[1,2,3],[1,2,3],3,6
 * 返回：6
 * <p>
 * 详细视频教程 https://www.youtube.com/watch?v=8LusJS5-AGo
 *
             0  0  0  0  0  0  0  0
             0  0  0  0  0  0  0  0
             0  0  0  0  0  0  0  0
             0  0  0  0  0  0  0  0

             0  1  1  1  1  1  1  1
             0  0  0  0  0  0  0  0
             0  0  0  0  0  0  0  0
             0  0  0  0  0  0  0  0

             0  1  1  1  1  1  1  1
             0  1  1  4  5  5  5  5
             0  1  1  4  5  6  6  9
             0  1  1  4  5  7  8  9

             9
 */
public class Backpack1 {

    public static void main(String[] args) {

        Backpack1 backpack = new Backpack1();
//        int[] w = new int[]{42, 25, 30, 35, 42, 21, 26, 28};
//        int[] v = new int[]{261, 247, 419, 133, 391, 456, 374, 591};
//        int result = backpack.maxValue(w, v, 8, 297);

        int[] w = new int[]{1, 3, 4, 5};
        int[] v = new int[]{1, 4, 5, 7};

        int result = backpack.maxValue(w, v, 4, 7);
        System.out.println(result);
    }

    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[][] dp = new int[n][cap + 1];

        // 初始化动态规划矩阵的第一列
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        Utils.print2Dmatrix(dp);
        // 初始化动态规划矩阵的第一行
        for (int i = 0; i < cap + 1; i++) {
            if (w[0] > i) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = v[0];
            }
        }
        Utils.print2Dmatrix(dp);
        // 循环填充 dp 矩阵
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < cap + 1; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        Utils.print2Dmatrix(dp);
        return dp[n - 1][cap];
    }
}
