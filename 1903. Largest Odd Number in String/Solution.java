class Solution {
    public String largestOddNumber(String num) {
      int n = num.length()-1;
  
      for(int i=n;i>=0;i--){
        if(num.charAt(i) % 2 != 0){
          return num.substring(0,i+1);
        }
      }
      
      return "";
    }
  }