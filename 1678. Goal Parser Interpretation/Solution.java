class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i<command.length()){
            if(command.charAt(i) == 'G') {
                ans.append('G');
                i++;
            } else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                ans.append('o');
                i += 2;
            } else {
                ans.append("al");
                i += 4;
            }
        }

        return ans.toString();
    }
}