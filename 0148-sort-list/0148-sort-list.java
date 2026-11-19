/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {

    //     // Base case
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     // 1. Find the middle
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     ListNode prev = null;

    //     while (fast != null && fast.next != null) {
    //         prev = slow;
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }

    //     // 2. Split the list
    //     prev.next = null;

    //     // 3. Sort both halves
    //     ListNode left = sortList(head);
    //     ListNode right = sortList(slow);

    //     // 4. Merge sorted halves
    //     return merge(left, right);
    // }

    // private ListNode merge(ListNode list1, ListNode list2) {

    //     ListNode dummy = new ListNode(-1);
    //     ListNode curr = dummy;

    //     while (list1 != null && list2 != null) {

    //         if (list1.val <= list2.val) {
    //             curr.next = list1;
    //             list1 = list1.next;
    //         } else {
    //             curr.next = list2;
    //             list2 = list2.next;
    //         }

    //         curr = curr.next;
    //     }

    //     if (list1 != null) {
    //         curr.next = list1;
    //     } else {
    //         curr.next = list2;
    //     }

    //     return dummy.next;

     ArrayList<Integer> arr = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
            Collections.sort(arr);
            ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;

    }
}