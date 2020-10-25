class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummpy = new ListNode();
        ListNode temp = dummpy;
        while(l1 != null || l2 != null){
            if(l1 == null){
                temp.next = l2;
                l2 = null;
            }else if(l2 == null){
                temp.next = l1;
                l1 = null;
            }else{
                if(l1.val > l2.val){
                    temp.next = l2;
                    l2 = l2.next;
                }else{
                    temp.next = l1;
                    l1 = l1.next;
                };
                temp = temp.next;
            }
        };
        return dummpy.next;
    }
}