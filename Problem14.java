/**
 * 调整数组顺序，使奇数位于偶数前面===》代码解耦
 * <p>
 * 题目：输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 */
public class Problem14 {
    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Problem14 test = new Problem14();
        test.order(array);
        for (int item : array) {
            System.out.println(item);
        }
    }

    public void order(int[] array) {
        if (array == null || array.length == 0)
            return;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isEven(array[start])) {
                start++;
            }
            while (start < end && isEven(array[end])) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 奇偶数区分
     *
     * @param n
     * @return
     */
    private boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * 正负数区分
     *
     * @param n
     * @return
     */
    private boolean isNagetive(int n) {
        return n < 0 ? true : false;
    }

    /**
     * 被3整除
     *
     * @param n
     * @return
     */
    private boolean is3div(int n) {
        return n % 3 == 0;
    }
}
