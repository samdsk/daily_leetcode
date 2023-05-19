// Using class

class TimeLimitedCache{
    cache = new Map()

    set(key,value,duration){
        const hasValue = key in this.cache && Date.now() < this.cache[timeout].expiration

        this.cache[key] = {value,timeout: Date.now() + duration}
        return hasValue
    }

    get(key){
        if(this.cache[key] === undefined) return -1
        if(Date.now()>this.cache[key].timeout) return -1
        return this.cache[key].value
    }

    count(){
        let count = 0
        for(const value of Object.values(this.cache)){
            if(Date.now() < value.timeout) count++
        }

        return count
    }
}

// Using Functions

var TimeLimitedCache = function() {
    this.cache = new Map()
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const valueInCache = this.cache.get(key)
    if(valueInCache) clearTimeout(valueInCache.timeout)

    const timeout = setTimeout(()=>this.cache.delete(key),duration)
    this.cache.set(key,{value,timeout})
    return Boolean(valueInCache)
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return this.cache.has(key) ? this.cache.get(key).value : -1
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.cache.size
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */