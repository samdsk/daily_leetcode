class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];

        for(char c : s.toCharArray())
            arr[c - 'a']++;

        StringBuilder ans = new StringBuilder();

        for(char c : order.toCharArray()){
            ans.append(String.valueOf(c).repeat(arr[c - 'a']));
            arr[c - 'a'] = 0;
        }

        for(int i=0;i<26;i++){
            char c = (char) (i + 'a');
            String temp = String.valueOf(c).repeat(arr[i]);
            ans.append(temp);
        }

        return ans.toString();
    }
}