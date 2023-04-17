bool* kidsWithCandies(int* candies, int candiesSize, int extraCandies, int* returnSize){
    int max = candies[0];

    for(int i = 1; i< candiesSize; i++){
        if(max<candies[i]) max = candies[i];
    }

    max -= extraCandies;
    *returnSize = candiesSize;

    bool* ans = malloc(sizeof(bool)* *returnSize);

    for(int i = 0;i<candiesSize;i++){
        ans[i] = candies[i]>=max;
    }

    return ans;

}