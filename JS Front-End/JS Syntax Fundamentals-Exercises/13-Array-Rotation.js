function solve (arr,rotation){
    // rotation %= arr.length;

    for (let index = 0; index < rotation; index++) {
       let first = arr.shift();
       arr.push(first);
        
    }
    console.log(arr.join(' '));
}
solve([51, 47, 32, 61, 21], 2);
solve([32, 21, 61, 1], 4);