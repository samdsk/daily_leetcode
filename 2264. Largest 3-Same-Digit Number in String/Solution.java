class Solution {
    public String largestGoodInteger(String num) {
        int SIZE = 3;

        int n = num.length();
        int index = 1;
        char[] arr = num.toCharArray();
        String ans = "";

        while (index < n) {
            int count = 0;
            //System.out.println("now checking "+ arr[index]);

            for (int i = index; i <= SIZE+index && i < n; i++) { // 6777133339
                //System.out.println("index:"+(i)+" "+arr[i-1]+" "+arr[i]);
                if(arr[i-1] == arr[i]){
                    count++;                
                }else break;
            }

            //System.out.println("count:"+count+" index:"+index);
            if(count == 2){
                String temp = new String(new char[SIZE]).replace('\0', arr[index]);
                
                if(ans.compareTo(temp)<0)
                    ans = temp;

            }
            index++;         
        }
        return ans;
    }


    public static void main(String[] args) {
        String ans = new Solution().largestGoodInteger("6777133339");
        System.out.println(ans);
    }
}