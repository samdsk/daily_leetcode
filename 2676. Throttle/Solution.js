/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
// set timeout

// var throttle = function(fn, t) {
//     let timeout = null
//     let argsBackup = null

//     const timeoutFunc = () => {
//         if(argsBackup === null) timeout = null
//         else{
//             fn(...argsBackup)
//             argsBackup = null
//             timeout = setTimeout(timeoutFunc,t)
//         }
//     }

//     return function(...args) {
//         if(timeout) argsBackup = args;
//         else{
//             fn(...args)
//             timeout = setTimeout(timeoutFunc,t)
//         }
//     }
// };

// set interval
var throttle = function(fn,t){
    let timeout = null
    let argsToProcess = null

    const timeoutFunc = () => {
        if(argsToProcess === null){
            clearInterval(timeout)
            timeout = null
        }else{
            fn(...argsToProcess)
            argsToProcess = null
        }
    }

    return function(...args){
        if(timeout) argsToProcess = args
        else{
            fn(...args)
            timeout = setInterval(timeoutFunc,t);
        }
    }
}

  /**
   * const throttled = throttle(console.log, 100);
   * throttled("log"); // logged immediately.
   * throttled("log"); // logged at t=100ms.
   */