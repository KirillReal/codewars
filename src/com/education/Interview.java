package com.education;

import java.util.ArrayList;
import java.util.List;

public class Interview {
    public void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        var res = reverseList(root);
        System.out.println(res);
    }
    class ListNode {
       public int val;
       public ListNode next;
       public ListNode() {

       }
        public ListNode(int x) {
            this.val = x;
        }


        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }


    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

}
