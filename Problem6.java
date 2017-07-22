import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/17.
 */
class BinaryTreeNode {
    public static int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
}
public class Problem6 {
    public static void main(String[] args){
        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = constructCore(preSort,inSort);
    }
    public static BinaryTreeNode constructCore(int[] preArr,int[] inArr){
         if(preArr==null||inArr==null){
             return null;
         }

         BinaryTreeNode root = new BinaryTreeNode();
         for(int i =0;i<inArr.length;i++) {
             if (preArr[0]==inArr[i]){
                 root.value=inArr[i];
                 root.leftNode=constructCore(Arrays.copyOfRange(preArr,1,i+1),Arrays.copyOfRange(inArr,0,i));
                 root.rightNode=constructCore(Arrays.copyOfRange(preArr,i+1,preArr.length),Arrays.copyOfRange(inArr,i+1,inArr.length));
             }
         }
         return root;
    }
}
