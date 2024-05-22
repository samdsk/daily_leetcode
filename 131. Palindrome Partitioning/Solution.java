class Solution {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());

        return ans;
    }

    private void dfs(String s, int index, List<String> acc){
        if(s.length() == index){
            ans.add(new ArrayList<>(acc));
            return;
        }

        for(int i = index; i < s.length();i++){
            String temp = s.substring(index, i+1);
            if(isPalindrome(temp)){
                acc.add(temp);
                dfs(s, i+1, acc);
                acc.remove(acc.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s){
        if(s.length() == 1) return true;        

        for(int left = 0, right = s.length() - 1; left < right; left++, right--){
            if(s.charAt(left) != s.charAt(right)) return false;
        }

        return true;
    }
}