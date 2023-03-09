class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder stemp = new StringBuilder();
        StringBuilder ttemp = new StringBuilder();

        int i = 0, j = 0;

        while(i<s.length() || j<t.length()){
            if(i<s.length()){
                if(s.charAt(i)=='#'){                    
                    if(stemp.length()>0)
                        stemp.deleteCharAt(stemp.length()-1);
                }else{                    
                    stemp.append(s.charAt(i));
                }
                i++;
            }
            if(j<t.length()){
                if(t.charAt(j)=='#'){                    
                    if(ttemp.length()>0)
                        ttemp.deleteCharAt(ttemp.length()-1);
                }else{                    
                    ttemp.append(t.charAt(j));
                }
                j++;
            }
        }

        return stemp.toString().equals(ttemp.toString());
    }
}