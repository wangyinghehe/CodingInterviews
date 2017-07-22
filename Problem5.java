/**
 * Created by Administrator on 2017/7/17.
 */
public class Problem5 {

    public static void main(String args[]) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node1.next = node2;
        node2.next = node3;
        Problem5.printListReverse(node1);
    }

    public static void printListReverse(ListNode headNode) {
        if (headNode != null) {
            if (headNode.next != null) {
                printListReverse(headNode.next);
            }
            System.out.println(headNode.data);
        }
    }

}

class ListNode {
    ListNode next;
    int data;
}