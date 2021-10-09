import java.util.Scanner;
import java.util.*;

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
    
    public static class Pair{
        TreeNode pr;
        int min;
        int max;
        
        Pair(){
            
        }
        
        Pair(TreeNode pr,int min , int max){
            this.pr = pr;
            this.min = min;
            this.max = max;
        }
    }
    
    public static TreeNode constructBSTFromLevelOrder(int[] nums) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();
        q.add(new Pair(null,Integer.MIN_VALUE,Integer.MAX_VALUE));
        
        int idx = 0;
        
        TreeNode root = null;
        
        while(q.size()>0 && idx<nums.length){
            Pair rem = q.remove();
            
            if(nums[idx]<rem.min || nums[idx]>rem.max){
                continue;
            }
            
            TreeNode node = new TreeNode(nums[idx]);
            idx++;
            
            if(rem.pr == null){
                root = node;
            }else{
                if(rem.pr.val>node.val){
                    rem.pr.left = node;
                }else{
                    rem.pr.right = node;
                }
            }
            
            q.add(new Pair(node,rem.min,node.val));
            q.add(new Pair(node,node.val,rem.max));
        }
        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}