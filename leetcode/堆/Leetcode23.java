package leetcode.堆;

import leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //用最小堆，每次输出最小的数
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //将每个链表的头结点加入
        for (ListNode list : lists) {
            if(list!=null){
                pq.add(list);
            }
        }
        //每次弹出最小的值，并把其结点的下一个节点入堆
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            cur.next =tmp;
            cur = cur.next;
            if(tmp.next!=null){
                pq.add(tmp.next);
            }
        }
        return dummy.next;
    }
}
