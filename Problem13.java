/**
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点。
 * 思路1：需要删除某一节点i，需要获取其前一个节点，从头遍历顺序查找，需要的时间复杂度是O(n)
 * 思路2：已知某一节点，则直接获取其下一节点，将其值copy覆盖指针节点，然后删除下一节点即可。O(1)
 *     细节：<1>.被删除节点，没有下一个节点，需要从头遍历
 *          <2>.链表中只有一个节点，指针置为null
 */
public class Problem13 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.next = second;
        second.next = third;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        Problem13 p13 = new Problem13();
        p13.deleteNode(head, second);
        System.out.println(head.next.data);
    }

    public void deleteNode(ListNode head, ListNode delistNode) {
        if (head == null || delistNode == null) {
            return;
        }
        if (head == delistNode) {//只有一个节点
            head = null;
        } else {
            if (delistNode.next == null) {//为尾节点
                ListNode temp = head;
                while (temp.next != delistNode) {
                    temp = temp.next;
                }
                temp.next = null;//倒数第二个节点，变为尾节点
            } else {
                delistNode.data = delistNode.next.data;
                delistNode.next = delistNode.next.next;
            }
        }
    }
}
