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
    public boolean hasCycle(ListNode head) {
      if(head ==null)
      return false;
      
      ListNode temp = head;
      Map<Integer, ListNode> map = new HashMap<>();

      int index = 0;

      while(temp.next!=null)
      {
        if(map.containsValue(temp))
        {
            return true;
        }
        map.put(index, temp);
        temp = temp.next;
        index++;
      }

      return false;
    }
}
