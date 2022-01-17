import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        System.out.println(balanced(str));
    }
    
    public static boolean balanced(String str){
        Stack<Character>st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ']' || ch == '}' || ch == ')'){
                if(st.size()==0){
                    return false;
                }
                char newChar = getBracket(ch);
                if(st.peek() != newChar){
                    return false;
                }
                st.pop();
            }
        }
        if(st.size() > 0){
            return false;
        }else{
            return true;
        }
    }
    
    public static char getBracket(char ch){
        if(ch == ')'){
            return '(';
        }else if(ch == ']'){
            return '[';
        }else{
            return '{';
        }
    }
}