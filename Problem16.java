/**
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class Problem16 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        Problem16 test = new Problem16();
        ListNode resListNode = test.reverseList(head);
        System.out.println(resListNode.data);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode preListNode = null;
        ListNode nowListNode = head;
        ListNode tempListNode = null;
        while (nowListNode.next != null) {
            tempListNode = nowListNode.next;//1.保存下一个节点
            nowListNode.next = preListNode;//2.更改指针
            nowListNode = tempListNode;//3.迭代，两个指针同时右移
            preListNode = nowListNode;
        }
        return nowListNode;
    }
}
