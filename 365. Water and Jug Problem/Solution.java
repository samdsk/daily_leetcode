import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    // BFS Version

    // public boolean canMeasureWater(int jug1, int jug2, int target) {
    //     if(jug1 + jug2 < target) return false;
    //     if(jug1 + jug2 == target || jug1 == target || jug2 == target) return true;

    //     Set<Integer> visited = new HashSet<>();
    //     Queue<Integer> queue = new LinkedList<>();

    //     queue.add(0);
    //     visited.add(0);

    //     while(!queue.isEmpty()){
    //         int current = queue.poll();
    //         if(current == target) return true;

    //         if(current+jug1 <= jug1+jug2 && visited.add(current+jug1))
    //             queue.add(current+jug1);

    //         if(current-jug1 >= 0 && visited.add(current-jug1))
    //             queue.add(current-jug1);

    //         if(current+jug2 <= jug1+jug2 && visited.add(current+jug2))
    //             queue.add(current+jug2);

    //         if(current-jug2 >= 0 && visited.add(current-jug2))
    //             queue.add(current-jug2);

    //     }

    //     return false;
    // }

    // Using GCD version
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(jug1 + jug2 < target) return false;
        if(jug1 + jug2 == target || jug1 == target || jug2 == target) return true;

        if(target % gcd(jug1, jug2) == 0) return true;

        return false;
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}