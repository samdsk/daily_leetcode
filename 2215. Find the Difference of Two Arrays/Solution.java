class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int n : nums1){
            set1.add(n);
        }

        for(int n : nums2){
            set2.add(n);
        }

        for(int n : nums2){
            set1.remove(n);
        }

        for(int n : nums1){
            set2.remove(n);
        }

        List<Integer> l1 = new ArrayList<>(set1);
        List<Integer> l2 = new ArrayList<>(set2);
        List<List<Integer>> ans = List.of(l1,l2);

        return ans;
    }
}