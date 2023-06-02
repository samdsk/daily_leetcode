/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let a = 0
    let b = 1

    while(true){
        yield a;
        // creating and destructing array
        [a,b] = [b,a+b]
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */