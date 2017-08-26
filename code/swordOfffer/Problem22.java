package code.swordOfffer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Problem22 {
    public static void main(String[]args){
	int[] array1={1,2,3,4,5};
	int[] array2={4,3,5,2,1};
       // int[] array2={4,3,5,1,2};
	Problem22 test = new Problem22();
	System.out.println(test.isPopOrder(array1,array2));
	}
	public boolean isPopOrder(int[] array1,int[] array2){
        if(array1==null||array2==null){
            return  false;
        }
        int index = 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(array1[0]);
        for(int i=0;i<array2.length;i++) {
            if(array2[i]==stack.peek()){
                stack.pop();
            }
            while(array2[i]!=stack.peek()){
                stack.push(array1[index]);
                index=index+1;
            }
           /* if(index==array1.length&&!stack.empty()){
                return false;
            }*/
        }
        return true;
    }

}
