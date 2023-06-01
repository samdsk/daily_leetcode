/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums
};

ArrayWrapper.prototype.valueOf = function() {
    // let sum = 0;
    // let n = this.nums.length
    // for(let i = 0;i<n;i++){
    //     sum += this.nums[i]
    // }
    // return sum

    return this.nums.reduce((acc,num) => acc + num,0)
}

ArrayWrapper.prototype.toString = function() {
    // let str = "["
    // let n = this.nums.length
    // for(let i = 0;i<n;i++){
    //     str += this.nums[i]
    //     if(i<n-1) str += ","
    // }
    // str += "]"
    return JSON.stringify(this.nums)
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */