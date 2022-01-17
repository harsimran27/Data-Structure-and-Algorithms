import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean duplicateBrackets(String str){
        
        Stack<Character> ans = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch=='('){
                ans.push(ch);
            }else if(ch==')'){
                int pc =0;
                
                while(ans.peek() != '('){
                    pc++;
                    ans.pop();
                }
                ans.pop();
                if(pc == 0){
                    return true;
                }
            }else if(ch != ' '){
                ans.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = duplicateBrackets(str);
        System.out.println(ans);
    }

}