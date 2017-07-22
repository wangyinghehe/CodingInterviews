/**
 *
 * 题目：输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打印出 1、2、3 一直到 999.  
 *
 */

public class Problem12 {

    public static void main(String[] args) {
        Problem12 p12 = new Problem12();
        p12.printToMaxOfNDigits(2);
    }

    public void printToMaxOfNDigits(int n) {
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }

    private void printArray(int[] array, int index) {
        if (index == array.length) {//打印
            boolean isBeginning0 = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0 || isBeginning0 == false) {
                    if (isBeginning0) {
                        isBeginning0 = false;
                    }
                    System.out.print(array[j]);
                }
            }
            System.out.println();
            return;
        } else {//填数
            for (int i = 0; i < 10; i++) {
                array[index] = i;
                printArray(array, index + 1);
            }
        }
    }
}
