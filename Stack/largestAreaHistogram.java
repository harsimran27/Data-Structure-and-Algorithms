import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    int ans = largestAreaHistogram(a);
    System.out.println(ans);

    // code
    
 }
 
 public static int largestAreaHistogram(int[] arr){
     
     int[] nsel = nextSmallestLeft(arr);
     int[] nser = nextSmallestRight(arr);
     int maxArea = 0;
     for(int i=0;i<arr.length;i++){
         int ht = arr[i];
         int width = nser[i]-nsel[i]-1;
         int area = width*ht;
         
         if(area>maxArea){
             maxArea = area;
         }
     }
    return maxArea;
     
 }
 
 public static int[] nextSmallestRight(int[] arr){
     
     Stack<Integer> st = new Stack<>();
     int[] nser = new int[arr.length];
     st.push(arr.length-1);
     nser[arr.length-1] = arr.length;
     for(int i=arr.length-1;i>=0;i--){
         while(st.size()>0 && arr[st.peek()]>=arr[i]){
             st.pop();
         }
         if(st.size()==0){
             nser[i] = arr.length;
         }else{
             nser[i] = st.peek();
         }
         st.push(i);
     }
     
     return nser;
     
 }
 
 public static int[] nextSmallestLeft(int[] arr){
     
     Stack<Integer> st = new Stack<>();
     int[] nsel = new int[arr.length];
     st.push(0);
     nsel[0] = -1;
     for(int i=1;i<arr.length;i++){
         while(st.size()>0 && arr[st.peek()]>=arr[i]){
             st.pop();
         }
         if(st.size()==0){
             nsel[i] = -1;
         }else{
             nsel[i] = st.peek();
         }
         st.push(i);
     }
     
     return nsel;
     
 }
 
}