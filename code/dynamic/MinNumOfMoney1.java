package code.dynamic;

/**
 * Created by Administrator on 2017/8/26.
 */
public class MinNumOfMoney1 {
        /**
         * 硬币找零：动态规划算法
         *   values:保存每一种硬币的币值的数组
         *   valueKinds:币值不同的硬币种类数量，即coinValue[]数组的大小
         *   money:需要找零的面值
         *   coinsUsed:保存面值为i的纸币找零所需的最小硬币数
         */
        public static void main(String[] args) {
            int[] coinValue = new int[] { 25, 21, 10, 5, 1 };// 硬币面值预先已经按降序排列
            int money = 65; // 需要找零的面值
            int[] coinsUsed = new int[money+1];// 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
            int[] coinTrack = new int[money+1];
            for(int i=1;i<=money;i++){
                coinsUsed[i] = 0;
                coinTrack[i] = 0;
            }
            makeChange(coinValue, coinValue.length, money, coinsUsed,coinTrack);
        }

        public static void makeChange(int[] values, int valueKinds, int money,int[] coinsUsed,int[] coinTrack) {
            coinsUsed[0] = 0;
            int last = 0;
            for (int cents = 1; cents <= money; cents++) { // 对每一分钱都找零，即保存子问题的解以备用，即填表
                int minCoins = 999;  // 当用最小币值的硬币找零时，所需硬币数量最多
                for (int kind = 0; kind < valueKinds; kind++) { // 遍历每一种面值的硬币，看是否可作为找零的其中之一
                    if (values[kind] <= cents) {// 若当前面值的硬币小于当前的cents则分解问题并查表
                        int temp = coinsUsed[cents - values[kind]] + 1;
                        if (temp < minCoins) {
                            minCoins = temp;
                            last = kind;
                        }
                    }
                }
                // 保存最小硬币数
                coinsUsed[cents] = minCoins;
                coinTrack[cents] = values[last];
                System.out.print("面值为 :" + (cents) + "的最小硬币数 : "+coinsUsed[cents]);
                System.out.print(" 硬币为：");
                trackPrint(cents, coinTrack);
                System.out.println();
            }
        }

        private static void trackPrint(int m,int[] coinTrack){
            if(m==0){
                return;
            }else {
                System.out.print(coinTrack[m]+" ");
                trackPrint(m-coinTrack[m], coinTrack);
            }
        }
}
