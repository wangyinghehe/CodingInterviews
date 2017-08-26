package code.test;

import java.util.Scanner;

/**
 * 输入输出函数样例
 */
public class Temp1 {
      public static void main(String[] args) {
          Scanner in = new Scanner(System.in);

           /*  1.输入一个NUM，输入一个数组
                 4
                 1 2 3 4
           */
            int NUM = in.nextInt();
            int[] array = new int[NUM];
            for (int i = 0; i < NUM; i++) {
                array[i] = in.nextInt();
            }

          /* 2.输入一行数，空格隔开，再输入一个整数
              23 -43 3 52
              4
          */
          String[] ss = in.nextLine().split(" ");
          int[] array1 = new int[ss.length];
          for(int i =0;i<ss.length;i++) {
              array1[i]=Integer.parseInt(ss[i]);
          }
          int K = in.nextInt();

          /* 3.输入一行数，空格隔开，再输入一个整数
              23 -43 3 52
              4
          */
    }
}
