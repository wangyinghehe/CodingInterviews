package code;

/**
 * Created by cheng on 2017/7/24.
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * <p>
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * <p>
 * 测试样例：
 * [1,2,4],3,3
 */

public class Exchange1 {

    public static void main(String[] args) {
        Exchange1 exchange = new Exchange1();
        int[] penny = new int[]{1, 3, 6};
        int res = exchange.count(penny, 3, 13);
        System.out.println(res);
    }

    public int count(int[] penny, int n, int aim) {
        return countWays(penny, 0, aim);
    }
    public int countWays(int[] penny, int index, int aim) {
        int res = 0;
        if (index == penny.length ) {
            res = aim == 0 ? 1 : 0;
        }else {
            for (int i = 0; penny[index] * i <= aim; i++) {
                res += countWays(penny, index + 1, aim - penny[index] * i);
            }
        }
        return res;
    }

}
