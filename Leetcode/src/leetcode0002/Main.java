/**
 * SOLVED : Solved
 * DATE : 2022.06.15
 * USER : KI-WOONG KIM
 * FROM : https://leetcode.com/problems/add-two-numbers/
 * ALGORITHM : LinkedList, Math, Recursion
 * NOTE : 
 */

package leetcode0002;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
	this.val = val;
    }

    ListNode(int val, ListNode next) {
	this.val = val;
	this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode node = new ListNode();
	ListNode fnode = null;
	ListNode head = node;
	
	ListNode n1 = l1;
	ListNode n2 = l2;
	int carry = 0;
	while (n1 != null || n2 != null) {
	    int digit1 = 0;
	    int digit2 = 0;
	    if (n1 != null) {
		digit1 = n1.val;
		n1 = n1.next;
	    }
	    if (n2 != null) {
		digit2 = n2.val;
		n2 = n2.next;
	    }
	    node.val = (digit1 + digit2 + carry) % 10;
	    carry = (digit1 + digit2 + carry) / 10;
	    node.next = new ListNode();
	    fnode = node;
	    node = node.next;
	}
	if (carry == 1) {
	    node.val = 1;
	} else {
	    fnode.next = null;
	}
	return head;
    }
}

public class Main {
    public static void main(String[] args) {
	Solution sol = new Solution();
	ListNode a1 = new ListNode(2);
	a1.next = new ListNode(4);
	a1.next.next = new ListNode(3);
	
	ListNode b1 = new ListNode(5);
	b1.next = new ListNode(6);
	b1.next.next = new ListNode(4);
	ListNode head = sol.addTwoNumbers(a1, b1);
	while(head != null) {
	    System.out.print(head.val + " ");
	    head = head.next;
	}
	
    }
}
