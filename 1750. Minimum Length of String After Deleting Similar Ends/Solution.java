class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if(n < 2) return n;
        int left = 0, right = n - 1;

        char[] arr = s.toCharArray();

        while(left < right){
            char c = arr[left];

            if(c != arr[right]) break;

            while(left <= right && arr[left] == c){
                left++;
            }
            while(left <= right && arr[right] == c){
                right--;
            }

        }
        return right - left + 1;
    }
}