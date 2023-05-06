import java.util.List;
import java.util.Stack;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()){
            int key = stack.pop();
            for(int room : rooms.get(key)){
                if(!visited[room]){
                    visited[room] = true;
                    stack.push(room);
                }
            }
        }

        for(boolean b : visited) if(!b) return false;

        return true;
    }
}