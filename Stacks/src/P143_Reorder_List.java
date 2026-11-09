import HelperFiles.ListNode;
import HelperFiles.StackObj;

public class P143_Reorder_List {
    public void reorderList(ListNode head) {
        ListNode temp = head;
        int size = getListSize(head);
        StackObj stack = new StackObj(size / 2);

        for (int i = 0; i < size / 2 + 1; i++)
            temp = temp.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;
        while (!stack.isEmpty()) {
            ListNode crr = (ListNode) stack.pop();
            crr.next = temp.next;
            temp.next = crr;
            temp = crr.next;
        }

        if (size % 2 == 0)
            temp.next.next = null;
        else
            temp.next = null;

    }

    public int getListSize(ListNode list) {
        int size = 0;
        ListNode temp = list;
        while (temp != null) {
            size += 1;
            temp = temp.next;
        }

        return size;
    }
}
