import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public record Point(int x, int y) {}

    public boolean isPathCrossing(String path) {
        Map<Character,Point> directions = new HashMap<>();
        directions.put('N', new Point(0, 1)); 
        directions.put('S', new Point(0, -1));
        directions.put('E', new Point(1, 0));
        directions.put('W', new Point(-1, 0));

        Set<Point> visitedPoints = new HashSet<>();

        int x = 0;
        int y = 0;

        visitedPoints.add(new Point(0, 0));

        for(char direction : path.toCharArray()){
            Point dir = directions.get(direction);
            
            x += dir.x;
            y += dir.y;

            Point temp = new Point(x,y);
            
            if(!visitedPoints.add(temp))
                return true;            
        }


        return false;
    }

    public static void main(String[] args) {
        String input = "NNSWWEWSSESSWENNW";
        boolean b = new Solution().isPathCrossing(input);
        System.out.println(b);

    }
}

