/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    async function evalNext(){
        if(functions.length === 0) return
        const f = functions.shift()
        await f()
        await evalNext()
    }
    const promises = Array(n).fill().map(evalNext)
    await Promise.all(promises)
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */