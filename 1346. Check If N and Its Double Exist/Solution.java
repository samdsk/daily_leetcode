class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            int n = arr[i];
            if(set.contains(n * 2) || (n%2 == 0 && set.contains(n / 2)) )
                return true;

            set.add(n);
        }

        return false;
    }
}