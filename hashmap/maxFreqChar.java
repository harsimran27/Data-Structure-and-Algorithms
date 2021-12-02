import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        freq(str);
    }
    public static void freq(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) == false){
                map.put(ch,1);
            }else {
                 int val = map.get(ch);
                 val +=1;
                 map.put(ch,val);
                 if(val > maxVal){
                     maxVal = val;
                 }
            }
        }
        for(Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()==maxVal){
                System.out.println(entry.getKey());
            }
        }
    
    }

}
