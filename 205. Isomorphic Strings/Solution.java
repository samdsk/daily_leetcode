class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sa = new int[256];
        int[] ta = new int[256];

        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(sa[cs] != ta[ct]) return false;

            sa[cs] = i+1;
            ta[ct] = i+1;
        }

        return true;
    }
}