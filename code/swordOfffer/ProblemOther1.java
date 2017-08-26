package code.swordOfffer;
import java.util.Scanner;
/**
 * 数组中第k大的数字
 */
public class ProblemOther1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int[] array = new int[ss.length];
        for(int i =0;i<ss.length;i++) {
            array[i]=Integer.parseInt(ss[i]);
        }
        int K = in.nextInt();
        System.out.println(  findTheNumK(array,K));
    }

    public static int findTheNumK(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return getKthNO(nums.length - k + 1, nums, 0, nums.length - 1);
    }
    public static int getKthNO(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (true) {
            while (nums[left] < pivot && left < right) {
                left++;
            }
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, left, end);
        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKthNO(k, nums, start, left - 1);
        } else {
            return getKthNO(k, nums, left + 1, end);
        }
    }
    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    public static class Problem31 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String[] ss = in.nextLine().split(" ");
            int[] array = new int[ss.length];
            for(int i =0;i<ss.length;i++) {
                array[i]=Integer.parseInt(ss[i]);
            }
            System.out.println(findGreatestSubArray(array));
        }

        public static  int findGreatestSubArray(int[] array) {
            if(array==null||array.length==0)
                return 0;
            int currentSum=array[0];
            int greatestSum=array[0];
            for(int i=1; i<array.length; i++) {
                if(currentSum<0) {
                    currentSum=array[i];
                } else {
                    currentSum+=array[i];
                }
                if(currentSum>greatestSum)
                    greatestSum=currentSum;
            }
            return greatestSum;
        }
    }
}
