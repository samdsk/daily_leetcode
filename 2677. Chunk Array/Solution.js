/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    let ans = []
    let index = 0
    while(index < arr.length){
        let temp = []
        for(let i = 0;i<size && index<arr.length;i++){
            temp.push(arr[index++])
        }
        ans.push(temp)
    }
    return ans
};