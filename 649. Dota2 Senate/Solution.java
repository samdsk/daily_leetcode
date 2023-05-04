import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        int rs = 0, ds = 0;
        int rBans = 0, dBans = 0;

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);

            q.add(c);

            if(c == 'R') rs++;
            else ds++;
        }

        while(rs>0 && ds>0){
            char c = q.poll();

            if(c == 'D'){
                if(dBans>0){
                    dBans--;
                    ds--;
                }else{
                    rBans++;
                    q.add('D');
                }
            }else{
                if(rBans>0){
                    rBans--;
                    rs--;
                }else{
                    dBans++;
                    q.add('R');
                }
            }
        }

        return rs<ds ? "Dire" : "Radiant";
    }

    // public String predictPartyVictory(String senate) {
    //     int n = senate.length();

    //     Queue<Integer> rq = new LinkedList<>();
    //     Queue<Integer> dq = new LinkedList<>();

    //     for (int i = 0; i < n; i++) {
    //         if(senate.charAt(i) == 'R') rq.add(i);
    //         else dq.add(i);
    //     }

    //     while(!rq.isEmpty() && !dq.isEmpty()){
    //         int r = rq.poll();
    //         int d = dq.poll();

    //         if(r<d) rq.add(r+n);
    //         else dq.add(d+n);
    //     }

    //     return rq.isEmpty() ? "Dire" : "Radiant";
    // }
}