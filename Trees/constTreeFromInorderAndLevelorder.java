import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public static TreeNode helper(int[] inorder ,int[] levelOrder,int is ,int ie){
      
      if(is>ie){
          return null;
      }
      
      TreeNode rootNode = new TreeNode(levelOrder[0]);
      
      if(levelOrder.length==1){
          return rootNode;
      }
      
      HashSet<Integer> set = new HashSet<>();
      int idx = is;
      
      while(inorder[idx]!=rootNode.val){
          idx++;
      }
      
      for(int i=is;i<idx;i++){
          set.add(inorder[i]);
      }
      
      int[] lolArr = new int[idx-is];
      int[] lorArr = new int[ie-idx];
      int ls = 0;
      int rs = 0;
      
      for(int i=1;i<levelOrder.length;i++){
          int ele = levelOrder[i];
          if(set.size()!=0 && set.contains(ele)){
              lolArr[ls++] = ele;
              set.remove(ele);
          }else{
              lorArr[rs++] =ele;
          }
      }
      
      rootNode.left = helper(inorder,lolArr,is,idx-1);
      rootNode.right = helper(inorder,lorArr,idx+1,ie);
      
      return rootNode;
  }

  public static TreeNode buildTree(int[] inorder, int[] levelOrder)
  {
  int n = inorder.length;
  TreeNode root = helper(inorder,levelOrder,0,n-1);
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

  int[] InOrder = new int[n];
  for (int i = 0; i < n; i++)
    InOrder[i] = scn.nextInt();

  int[] LevelOrder = new int[n];
  for (int i = 0; i < n; i++)
    LevelOrder[i] = scn.nextInt();

  TreeNode root = buildTree(InOrder, LevelOrder);
  display(root);
}

public static void main(String[] args) {
  solve();
}

}