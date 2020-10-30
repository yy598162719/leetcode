//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 723 👎 0

package cn;

import cn.doc.ListNode;

//java:两两交换链表中的节点
public class 两两交换链表中的节点_24 {
    public static void main(String[] args) {
        Solution solution = new 两两交换链表中的节点_24().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //        递归
        public ListNode swapPairs1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //一共三个节点:head, next, swapPairs(next.next)
            //下面的任务便是交换这3个节点中的前两个节点
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
            return next;
        }

        //        迭代法
        public ListNode swapPairs(ListNode head) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode temp = pre;
            while (temp.next != null && temp.next.next != null) {
                ListNode start=temp.next;
                ListNode end =temp.next.next;
                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return pre.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}