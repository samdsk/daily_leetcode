class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        int count0 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                if(s.charAt(i) == '1'){
                    count0++;
                }else{
                    count1++;
                }
            }else{
                if(s.charAt(i) == '1'){
                    count1++;
                }else{
                    count0++;
                }
            }
        }       

        return Math.min(count1, count0);
    }

    public static void main(String[] args) {
        String input = "1111";
        int ans = new Solution().minOperations(input);

        System.out.println(ans);
    }
}

// 0100
// 1100