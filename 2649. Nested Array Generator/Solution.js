/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    // if(!Array.isArray(arr)) yield arr

    // for(let i = 0;i<arr.length;i++)
    //     yield* inorderTraversal(arr[i])

    const stack = [arr]

    while(stack.length>0){
        const el = stack.pop()
        if(!Array.isArray(el)) yield el

        for(let i=el.length-1;i>=0;i--) stack.push(el[i])
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */