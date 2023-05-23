/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function(arr) {
    const isObject = e => (e!==null && typeof e === 'object')

    const getKeys = (object) =>{
        if(!isObject(object)) return ['']
        const ans = []

        for(const key of Object.keys(object)){
            const childKeys = getKeys(object[key])
            for(const childKey of childKeys){
                ans.push(childKey ? `${key}.${childKey}` : key)
            }
        }

        return ans
    }

    const keySet = arr.reduce((acc,curr)=>{
        getKeys(curr).forEach((k)=>acc.add(k))
        return acc
    },new Set())

    const keys = Array.from(keySet).sort()

    const getValue = (obj,path)=>{
        const paths = path.split('.')
        let i = 0, value = obj

        while(i<paths.length){
            if(!isObject(value)) break
            value = value[paths[i++]]
        }

        if(i<paths.length || isObject(value) || value === undefined) return ''
        return value
    }

    const matrix = [keys]

    arr.forEach(obj => {
        matrix.push(keys.map(key => getValue(obj,key)))
    })

    return matrix
};