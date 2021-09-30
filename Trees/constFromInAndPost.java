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
    
    public static TreeNode helper(int[] inorder , int[] postorder, int is ,int ie , int ps , int pe){
        
        if(ps>pe){
            return null;
        }
        
        TreeNode rootNode = new TreeNode(postorder[pe]);
        int k=-1;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==rootNode.val){
                k=i;
                break;
            }
        }
        
        int cls = k-is;
        
        rootNode.left = helper(inorder,postorder,is,k-1,ps,ps+cls-1);
        rootNode.right = helper(inorder,postorder,k+1,ie,ps+cls,pe-1);
        
        return rootNode;
        
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode root = helper(inorder,postorder,0,n-1,0,n-1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}