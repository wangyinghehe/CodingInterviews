package code.swordOfffer;

import java.util.ArrayList;
import java.util.Scanner;
//网易测试开发算法:按照要求进行调换顺序
   //1.序列A:1 2 3 4
   //2.将序列A的第i项取出防止B序列的最后位置，B逆序（重复次数是A的长度）
   //3.最终B序列为？ 4 2 1 3
  /* 输入：4
          1 2 3 4
     输出：4 2 1 3
   */
public class ProblemOther2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NUM = in.nextInt();
        int[] array = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            array[i] = in.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < NUM; j++) {
            list.add(array[j]);
            list= reservse(list);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static ArrayList reservse(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() / 2; i++) {
            int temp = array.get(i);
            array.set(i, array.get(array.size() - i - 1));
            array.set(array.size() - i - 1, temp);
        }
        return array;
    }
}