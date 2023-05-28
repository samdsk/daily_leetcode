/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    const ans = {}

    for(const el of this){
        const key = fn(el)
        if(key in ans) ans[key].push(el)
        else ans[key] = [el]
    }

    return ans
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */