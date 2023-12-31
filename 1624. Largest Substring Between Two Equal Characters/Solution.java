class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();

        int max = -1;

        Arrays.fill(arr, -1);

        for(int i=0;i<s.length();i++){
            int index = chars[i] - 'a';

            if(arr[index] >= 0)
                max = Math.max(max,i - arr[index] -1);
            else
                arr[index] = i;
        }

        return max;
    }
}