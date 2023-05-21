/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function(o1, o2) {
    if(o1 === o2) return true
    if(o1.length != o2.length) return false

    if(Array.isArray(o1)){
        for(let i = 0;i<o1.length;i++){
            if(o1[i] !== o2[i]) return false
        }
    }


    for(key of Object.keys(o1)){
        if(o2[key] === undefined) return false
        if(o1[key] !== o2[key]) return false
        if(o1[key] === 'object' && !areDeeplyEqual(o1[key],o2[key])) return false

    }

    return true
};