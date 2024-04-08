class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int c = 0;
        int s = 0;

        for(int student : students){
            if(student == 0) c++;
            else s++;
        }

        for(int sandwich : sandwiches){
            if(sandwich == 0){
                if(c>0) c--;
                else break;
            }else{
                if(s>0) s--;
                else break;
            }
        }

        return s+c;

    }
}