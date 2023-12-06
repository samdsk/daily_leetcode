class Solution {
    public int totalMoney(int n) {
        int weeks = n/7;
        int lastWeek = n%7;
        int FIRST_WEEK = 28;
        int LAST_WEEK = FIRST_WEEK + (7 * (weeks-1));
        int total = (weeks*(FIRST_WEEK + LAST_WEEK)) / 2;
        

        for (int i = 1; i <= lastWeek; i++) {
            total += i+weeks;
        }

        return total;
    }

    public static void main(String[] args) {
        int ans = new Solution().totalMoney(5);

        System.out.println(ans);
    }
}

/*
 * (28 + 7 * 0) + (28 + 7 * 1) = 63 <- 14, 2 weeks
 * = (28 * weeks) + (7 * 1)
 * (28 + 7 * 0) + (28 + 7 * 1) + (28 + 7 * 2) = 105 <- 21, 3 weeks
 * = (28 * weeks) + (7 * 3)
 * (28 + 7 * 0) + (28 + 7 * 1) + (28 + 7 * 2) + (28 + 7 * 3) = 154 <- 28, 4 weeks
 * = (28 * weeks) + (7 * 6) 
 * (28 + 7 * 0) + (28 + 7 * 1) + (28 + 7 * 2) + (28 + 7 * 3) + (28 + 7 * 4) = 210 <- 35, 5 weeks
 * = (28 * weeks) + (7 + 10)
 * (28 + 7 * 0) + (28 + 7 * 1) + (28 + 7 * 2) + (28 + 7 * 3) + (28 + 7 * 4) + (28 + 7 * 5) = 273 <- 42, 6 weeks
 * = (28 * weeks) + (7 + 15) = (weeks(28 + 28 + (7 * (weeks - 1))))/2
 * 
 * https://en.wikipedia.org/wiki/Arithmetic_progression -> k(START+FINISH)/2
 */