import java.util.Arrays;

/**
 * 题目：输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最少的 4 个数字是 1,2,3,4.
 */
public class Problem30 {

    public static void main(String[] args) {
        Problem30 test = new Problem30();
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        test.getLeastNumbers(array, 2);
    }

    public void getLeastNumbers(int[] array, int k) {
        if (array == null || k < 0 || k > array.length)
            return;
        int[] kArray = Arrays.copyOfRange(array, 0, k);//堆的大小为k
        buildMaxHeap(kArray);//建立一个最大堆
        for (int i = k; i < array.length; i++) {
            if (array[i] < kArray[0]) {//顺序遍历数组，将数组中的数与最大值进行比较，比最大值小，则添加到最大堆里
                kArray[0] = array[i];
                maxHeap(kArray, 0);
            }
        }
        for (int i : kArray) {
            System.out.println(i);
        }
    }

    private void buildMaxHeap(int[] kArray) {
        for (int i = kArray.length/2-1; i >= 0; i--) {
            maxHeap(kArray, i);//堆的根节点，开始调整
        }
    }

    private void maxHeap(int[] kArray, int i) {//从i开始调整最大堆；从0开始算i节点的子节点为2*i+1 ,2*i+2
        int temp = kArray[i];//待调整节点
        int left = 2 * i+1;//待调整节点的左子节点
        if(left>=kArray.length){
            return;
        }
        if (left+1 < kArray.length && kArray[left] < kArray[left+1] ) {//在左右孩子中找最大的
           left++;
        }
        if(kArray[left]>temp){//保证根节点值最大
            kArray[i] = kArray[left];
            kArray[left] = temp;
            maxHeap(kArray, left);
        }
    }
}
