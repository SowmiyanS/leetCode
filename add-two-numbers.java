/**
 *  * Definition for singly-linked list.
 *   * public class ListNode {
 *    *     int val;
 *     *     ListNode next;
 *      *     ListNode() {}
 *       *     ListNode(int val) { this.val = val; }
 *        *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *         * }
 *          */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1str = new StringBuilder();
        StringBuilder l2str = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        ListNode tmp = l1;
        while(tmp != null) {
            l1str.append(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while(tmp != null) {
            l2str.append(tmp.val);
            tmp = tmp.next;
        }

        String l2strs = l2str.toString();
        String l1strs = l1str.toString();

        int carry = 0;
        int crnt = 0;
        if(l2strs.length() < l1strs.length()) {
            for(int i = 0;i < l1strs.length();i++) {
                if(i < l2strs.length()) {
                    crnt += ((int)l2strs.charAt(i)) - 48;
                }
                crnt += ((int)l1strs.charAt(i)) - 48 + carry;
                int qtn = crnt / 10;
                int rdr = crnt % 10;
                answer.append(rdr);
                carry = qtn;
                crnt = 0;
            }
            if(carry > 0) answer.append(carry);
        }
        else {
            for(int i = 0;i < l2strs.length();i++) {
                if(i < l1strs.length()) crnt += ((int)l1strs.charAt(i)) - 48;
                crnt += ((int)l2strs.charAt(i)) - 48 + carry;
                int qtn = crnt / 10;
                int rdr = crnt % 10;
                answer.append(rdr);
                System.out.print(rdr);
                carry = qtn;
                crnt = 0;
                System.out.println();
            }
            if(carry > 0) answer.append(carry);
        }

        char[] ans = answer.reverse().toString().toCharArray();
        ListNode newListNode = new ListNode();
        tmp = newListNode;
        for(int i = ans.length - 1;i >= 0;i--) {
            int t = ((int) ans[i]) - 48;
            tmp.val = t;
            if(i > 0) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }

        return newListNode;
    }
}
