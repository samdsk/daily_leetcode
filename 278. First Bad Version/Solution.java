/**
 * Solution
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1;
        while(i<=n){
            int mid = i + (n-i)/2;
            if(!isBadVersion(mid)) i = mid+1;
            else n = mid-1;
        }

        return i;
    }
}