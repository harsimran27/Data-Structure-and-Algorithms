import java.util.*;

public class Main{
    
    public static List<List<Integer>> binomialPattern(int n){
        
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        
        for(int i=0;i<n;i++){
            
            List<Integer> list1 = new ArrayList<Integer>();
            
            for(int j=0;j<=i;j++){
                
                if(j==0 || j==i){
                    list1.add(1);
                }else{
                    list1.add(ansList.get(i-1).get(j-1)+ansList.get(i-1).get(j));
                }
                
            }
            
            ansList.add(list1);
            
        }
        
        return ansList;
        
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        List<List<Integer>> ans = binomialPattern(n);
        System.out.println(ans);
    }
    
}