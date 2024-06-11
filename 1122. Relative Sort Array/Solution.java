class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int N = arr1.length;

        for (int n : arr1) {
            freqs.put(n, freqs.getOrDefault(n, 0) + 1);
        }

        int[] ans = new int[N];
        int index = 0;

        for (int n : arr2) {
            while (freqs.containsKey(n)) {
                ans[index] = n;
                freqs.put(n, freqs.get(n) - 1);

                if (freqs.get(n) < 1)
                    freqs.remove(n);
                index++;
            }
        }

        if (index == N)
            return ans;
        int[] rest = new int[N - index];
        int i = 0;

        for (int n : freqs.keySet()) {
            int count = 0;
            while (count < freqs.get(n)) {
                rest[i++] = n;
                count++;
            }
        }

        Arrays.sort(rest);

        for (int j = 0; j < rest.length; j++) {
            ans[index++] = rest[j];
        }

        return ans;
    }
}