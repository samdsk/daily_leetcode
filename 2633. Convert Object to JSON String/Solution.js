/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if(object === null) return 'null';

    if(Array.isArray(object)){
        const els = object.map((e)=> jsonStringify(e))
        return `[${els.join(',')}]`
    }

    if(typeof object === 'object'){
        const keys = Object.keys(object)
        const pairs = keys.map((key)=> `"${key}":${jsonStringify(object[key])}`)
        return `{${pairs.join(',')}}`
    }

    if(typeof object === 'string'){
        return `"${object}"`
    }

    return String(object)
};