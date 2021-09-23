import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
  
  public static ListNode getNodeAt(int idx,ListNode head){
  
    ListNode temp = head;
    
    while(idx>0){
        temp = temp.next;
        idx--;
    }
    return temp;
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
    ListNode pivotNode = getNodeAt(pivotIdx,head);
    int pivotVal = pivotNode.val;
    
    ListNode sh = new ListNode(-1);
    ListNode st = sh;
    
    ListNode lh = new ListNode(-1);
    ListNode lt = lh;
    
    ListNode temp = head;
    
    while(temp!=null){
        if(temp==pivotNode){
            // Do nothing
        }
        else if(temp.val<=pivotVal){
            st.next = temp;
            st = st.next;
        }
        else{
            lt.next = temp;
            lt = lt.next;
        }
        temp = temp.next;
    }
    
    lt.next=null;
    st.next = pivotNode;
    pivotNode.next = lh.next;
    
    return sh.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}