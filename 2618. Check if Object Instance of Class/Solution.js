/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if(obj === null || obj === undefined || typeof classFunction !== "function")
        return false

    for(const p of prototypeGen(obj))
        if(p === classFunction.prototype) return true

    return false

};

function* prototypeGen(obj){
    let currentProto = Object.getPrototypeOf(obj)

    while(currentProto !== null){
        yield currentProto
        currentProto = Object.getPrototypeOf(currentProto)
    }
}

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */