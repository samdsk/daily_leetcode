/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    ans = []
    for(i = 0;i<arr.length;i++){
        ans.push(fn(arr[i],i))
    }
    return ans
};