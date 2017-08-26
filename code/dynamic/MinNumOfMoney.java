package code.dynamic;

/**
 * Created by Administrator on 2017/8/26.
 *  最小数量的硬币面值组合：给出硬币种类，及要组合的sum，求用最少的硬币数目到达sum。
 *
 */
public class MinNumOfMoney {
    public static void main(String[] args) {
        int[] coinValue = new int[]{25, 21, 10, 5, 1};// 硬币面值预先已经按降序排列
        int money = 63;// 需要找零的面值
        int[] coinsUsed = new int[money + 1]; // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }

    public static void makeChange(int[] values, int valueKinds, int money, int[] coinsUsed) {
        coinsUsed[0] = 0;
        for (int cents = 1; cents <= money; cents++) { // 对每一块钱都找零，即保存子问题的解以备用，即填表
            int minCoins = cents;  // 当用最小币值的硬币找零时，所需硬币数量最多
            for (int kind = 0; kind < valueKinds; kind++) { // 遍历每一种面值的硬币，看是否可作为找零的其中之一
                if (values[kind] <= cents) { // 若当前硬币面值小于当前的sum则分解问题并查表
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            coinsUsed[cents] = minCoins;   // 保存最小硬币数
            System.out.println("面值为 " + (cents) + " 的最小硬币数: " + coinsUsed[cents]);
        }
    }
}
