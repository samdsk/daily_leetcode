/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */

// ! mem efficient
var flat = function (arr, n) {
    let res = []
    const flat = (arr,len) =>{
        for(const e of arr){
            if(Array.isArray(e) && len > 0 && len <= n){
                flat(e,len-1)
            }else{
                res.push(e)
            }
        }
    }

    flat(arr,n)
    return res
};

// var flat = function (arr, n) {
//     let res = []
//     const stack = [...arr.map((e)=>[e,n])]

//     while(stack.length>0){
//         const [element,depth] = stack.pop()
//         if(Array.isArray(element) && depth > 0){
//             stack.push(...element.map( e => [e,depth-1]))
//         }else{
//             res.push(element)
//         }
//     }

//     return res.reverse()
// };