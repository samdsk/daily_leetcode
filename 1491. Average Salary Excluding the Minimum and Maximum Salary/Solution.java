class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int n = salary.length;

        for (int i = 0; i < n; i++) {
            if(min>salary[i]) min = salary[i];
            if(max<salary[i]) max = salary[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(salary[i] > min && salary[i]<max){
                sum += salary[i];
            }
        }

        return sum / n;

    }
}