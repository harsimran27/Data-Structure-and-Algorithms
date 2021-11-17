int findMinPossibleString(String[] arr, int n){
        int min = arr[0].length();
        for(int i=1;i<n;i++){
            if(arr[i].length()<min){
                min = arr[i].length();
            }
        }
        return min;
    }
    
    String longestCommonPrefix(String arr[], int n){
        // code here
        int minLength = findMinPossibleString(arr,n);
        // String comp = arr[0];
        String result = "";
        char curr;
        for(int i=0;i<minLength;i++){
            curr = arr[0].charAt(i);
            for(int j=1;j<n;j++){
                if(!(arr[j].charAt(i)==curr)){
                    if(result.equals(""))
                        return "-1";
                    else
                        return result;
                }
            }
            result+=curr;
        }
        return result;
    }