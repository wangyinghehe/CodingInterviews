package code;

/**
 * Created by cheng on 2017/7/24.
 * 动态规划法实现 换钱
 */
class DPChangeMoney1 {

    public static void main(String[] args) {
        DPChangeMoney1 dpChangMoney = new DPChangeMoney1();
        int[] penny = new int[]{1, 3, 6};
        int res = dpChangMoney.countWays(penny, 3, 13);
        System.out.println(res);
    }

    public int countWays(int[] penny, int n, int aim) {
        int[][] map = new int[n][aim + 1];

        // 第一列初始化为 1  表示 在 只使用 0 到 i-1 种货币的情况下，组成钱数为 0 时的方法种数
        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }
        // 第一行初始化  表示，在只使用 arr[0] 这种货币的情况下，组成 钱数为 j 时的方法总数， 当 j 为 arr[0] 的整数
        // 倍时，方法种数为一种
        for (int i = 0; i < aim + 1; i++) {
            if (i % penny[0] == 0) {
                map[0][i] = 1;
            } else {
                map[0][i] = 0;
            }
        }
        // dp计算
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (j - penny[i] >= 0) {
                    map[i][j] = map[i - 1][j] + map[i][j - penny[i]];
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[n - 1][aim];
    }

//    public int count(int[] penny, int index, int aim, int[][] map) {
//        int res = 0;
//        if (index == penny.length) {
//            res = aim == 0 ? 1 : 0;
//        } else {
//            for (int i = 0; penny[index] * i <= aim; i++) {
//                int mapValue = map[index + 1][aim - penny[index] * i];
//                if (mapValue == 0) {   // map 中一共可能有三种值， -1 不能凑成， 0 还未计算， 其他值 正常值
//                    res += count(penny, index + 1, aim - penny[index] * i, map);
//                }else {
//                    res += mapValue == -1 ? 0 : mapValue;
//                }
//            }
//        }
//        map[index][aim] = res == 0 ?-1:res;
//        return res;
//    }
}
