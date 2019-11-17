package com.company;

import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
//        node2.next.next = new ListNode(9);
//        node2.next.next.next = new ListNode(9);
//        node2.next.next.next.next = new ListNode(9);
//        node2.next.next.next.next.next = new ListNode(9);
//        node2.next.next.next.next.next.next = new ListNode(9);
//        node2.next.next.next.next.next.next.next = new ListNode(9);
//        node2.next.next.next.next.next.next.next.next = new ListNode(9);
//        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(node1,node2));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        // 新链表
        ListNode listNode ;
        boolean isAdd = false;
        if (temp1.val+temp2.val >= 10){
             listNode = new ListNode(temp1.val+temp2.val - 10);
             if (l1.next == null && l2.next == null){
                 listNode.next = new ListNode(1);
                 return  listNode;
             }else {
                 isAdd = true;
             }
        }else {
            listNode = new ListNode(temp1.val+temp2.val);
        }
        ListNode temp = listNode;
        int val;
        while (temp1!=null||temp2!=null){
            if (temp1!=null){
                temp1 = temp1.next;
            }
            if (temp2!=null){
                temp2 = temp2.next;
            }
            if (temp1!=null&&temp2!=null){
                val = temp1.val + temp2.val;
            }else if (temp1 == null&& temp2!=null){
                val = temp2.val;
            }else if (temp2 == null&&temp1!=null){
                val = temp1.val;
            }else {
                if (isAdd){
                    val = 0;
                }else {
                    break;
                }
            }
            if (isAdd){
                val++;
            }
            if (val >= 10){
                temp.next = new ListNode(val - 10);
                temp = temp.next;
                isAdd = true;
            }else {
                temp.next = new ListNode(val);
                temp = temp.next;
                isAdd = false;
            }
        }
        return listNode;
    }
}
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
