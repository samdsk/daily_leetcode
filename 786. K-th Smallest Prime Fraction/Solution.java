class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int N = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        for(int i=0;i<N;i++){
            pq.offer(new double[]{
                (-1.0) * arr[i] / arr[N-1],
                i, N-1
            });
        }

        while(--k>0){
            double[] cur = pq.poll();
            int nIndex = (int) cur[1];
            int dIndex = (int) cur[2] - 1;

            if(dIndex > nIndex){
                pq.offer(new double[]{
                    (-1.0) * arr[nIndex] / arr[dIndex],
                    nIndex, dIndex
                });
            }
        }

        double[] result = pq.poll();

        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};
    }
}