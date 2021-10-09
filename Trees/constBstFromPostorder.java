import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode helper(int[] nums , int min , int max){
        
        if(idx<0 || nums[idx]<min || nums[idx]>max){
            return null;
        }
        
        TreeNode node = new TreeNode(nums[idx]);
        idx--;
        
        node.right = helper(nums,node.val,max);
        node.left = helper(nums,min,node.val);
        
        return node;
    }
    
    static int idx;
    public static TreeNode bstFromPostorder(int[] preorder) {
        idx = preorder.length-1;
        int lr = -(int)1e9-1;
        int rr = (int)1e9+1;
        return helper(preorder,lr,rr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}