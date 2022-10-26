import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
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
    public ListNode mergeKLists(ListNode[] lists) {
        // ListNode res = new ListNode(-1),p=res;
        // PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        // for(ListNode l:lists)
        //     if(l!=null)
        //     queue.add(l);
        // while(!queue.isEmpty()){
        //     ListNode top = queue.poll();
        //     p.next = top;
        //     p=p.next;
        //     if(top.next!=null)
        //         queue.add(top.next);
        // }
        // return res.next;
            return merge(lists, 0, lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r) return lists[l];
        if(l>r) return null;
        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode(-1),p=res;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                p.next = p1;
                p1=p1.next;
            }
            else{
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }
        if(p1==null)
            p.next=p2;
        else if(p2==null)
            p.next=p1;
        return res.next;
    }
}
// @lc code=end

