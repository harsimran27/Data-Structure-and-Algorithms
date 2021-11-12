import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0 ; i<n; i++){
            for(int j =0 ; j<m ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        ringRotate(arr,s,r);
        display(arr);
        
    }
    
    public static int[] fillArray(int[][]arr , int s){
        int row = arr.length;
        int col = arr[0].length;
        
        int rs = 0 + s - 1;
        int re = row-s;;
        int cs = 0 + s - 1;
        int ce = col-s;
        
        int tes = (2*(re-rs)+2*(ce-cs));
        
        int[] oneArr = new int[tes];
        int idx = 0;
        
        for(int i =rs;i<=re;i++){
            oneArr[idx] = arr[i][cs];
            idx++;
        }
        cs++;
        
        for(int j=cs;j<=ce;j++){
            oneArr[idx] = arr[re][j];
            idx++;
        }
        re--;
        
        for(int i =re;i>=rs;i--){
            oneArr[idx] = arr[i][ce];
            idx++;
        }
        ce--;
        
        for(int j = ce;j>=cs;j--){
            oneArr[idx] = arr[rs][j]; 
            idx++;
        }
        rs++;
        
        return oneArr;
        
    }
    
    public static void reverse(int[] arr,int low , int high){
        
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            
            low++;
            high--;
        }
    }
    
    public static void rotate(int[] arr, int r){
        
        int n = arr.length;
        
        r = r%n;
        
        if(r<0){
            r=r+n;
        }
        
        reverse(arr,0,n-1);
        reverse(arr,0,r-1);
        reverse(arr,r,n-1);
        
    }
    
    public static void fillShell(int[][] arr , int s , int[]oneArr){
        
        int row = arr.length;
        int col = arr[0].length;
        
        int rs = 0 + s - 1;
        int re = row-s;;
        int cs = 0 + s - 1;
        int ce = col-s;
        
        int tes = (2*(re-rs)+2*(ce-cs));
        
        // int[] oneArr = new int[tes];
        int idx = 0;
        
        for(int i =rs;i<=re;i++){
            arr[i][cs] = oneArr[idx];
            idx++;
        }
        cs++;
        
        for(int j=cs;j<=ce;j++){
            arr[re][j] = oneArr[idx];
            idx++;
        }
        re--;
        
        for(int i =re;i>=rs;i--){
            arr[i][ce] = oneArr[idx];
            idx++;
        }
        ce--;
        
        for(int j = ce;j>=cs;j--){
            arr[rs][j] = oneArr[idx]; 
            idx++;
        }
        rs++;
        
    }
    
    public static void ringRotate(int[][] arr , int s ,int r){
        
        int[] myArr = fillArray(arr ,s);
        
        rotate(myArr,r);
        
        fillShell(arr , s , myArr);
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}