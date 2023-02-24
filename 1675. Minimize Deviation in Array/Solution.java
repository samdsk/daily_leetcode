import java.util.Collections;
import java.util.PriorityQueue;


/**
 * 
    First, check if the input array is null or empty. If it is, it returns the maximum integer value.
    Then, initialize a priority queue called "evens" to hold the even numbers in the array (or the doubled odd numbers).

    Also initialize a variable "min" to hold the current minimum value in the array.

    
    Next,loop through each element of the array:

    If the element is even, it adds it to the "evens" priority queue and update "min" if it is smaller than the current value.

    If the element is odd, it doubles it and adds it to the "evens" priority queue, 
    and update "min" if it is smaller than the new value.

    
    After processing all elements,initialize a variable "res" to the maximum integer value.
    Then loop while the maximum element in the "evens" priority queue is even:
    Remove the maximum element from the queue and calculate the difference between it and the current minimum value ("min").
    Update "res" to be the minimum between the current "res" and this difference.

    Divide the maximum element by 2 and add the new value to the "evens" priority queue.

    Update "min" if the new value is smaller than the current minimum.

    Finally, calculate the difference between the current maximum value 
    in the "evens" priority queue and the current minimum value ("min"), 
    and update "res" to be the minimum between the current "res" and this difference.

    Return the final value of "res".

    solution
    https://leetcode.com/problems/minimize-deviation-in-array/solutions/3223767/clean-codes-full-explanation-priority-queue-c-java-python3/

 */
class Solution {
    public int minimumDeviation(int[] nums) {        

        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length,Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(nums[i] % 2 == 0){
                queue.add(nums[i]);
            }else{
                queue.add(nums[i]*2);
                n = n*2;                
            }
            min = Math.min(min, n);
        }

        int res = Integer.MAX_VALUE;

        while(queue.poll() % 2 == 0){
            int max = queue.poll();
            res = Math.min(res,max-min);
            int newMin = max/2;
            queue.offer(newMin);
            min = Math.min(newMin,min);
        }

        res = Math.min(queue.peek() - min, res);
        return res;
        
    }
}