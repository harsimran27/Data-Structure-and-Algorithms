String reverseWords(String S)
    {
        // code here 
        String str = "";
 
       
        String[] arr = S.split("\\.");
        for(int i=arr.length-1;i>=0;i--){
            str += arr[i];
           
            if(i>0){
                str += ".";
            }
            
        }
        return str;
    }