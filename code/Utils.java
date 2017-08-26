package code;

/**
 * Created by cheng on 2017/7/25.
 */
public class Utils {

    public static void print2Dmatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");

            }
            System.out.println();
        }
    }
}
