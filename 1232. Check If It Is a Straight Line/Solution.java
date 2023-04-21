class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

        int dX = coordinates[1][0] - coordinates[0][0];
        int dY = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            if((dY * (coordinates[i][0] - coordinates[0][0])) != (dX * (coordinates[i][1] - coordinates[0][1]))){
                return false;
            }
        }

        return true;
    }


}