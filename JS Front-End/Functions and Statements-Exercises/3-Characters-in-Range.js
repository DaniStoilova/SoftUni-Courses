function solve(symbol1,symbol2){
    let first = symbol1.charCodeAt(0);
    let second = symbol2.charCodeAt(0);

    let asciFirst = Math.min(first,second);
    let asciSecond = Math.max(first,second);

    let charCollection = [];
    for (let index = asciFirst + 1; index < asciSecond; index++) {


        charCollection.push(String.fromCharCode(index));
    
        
    }
    console.log(charCollection.join(' '));

}
solve('a',
'd'
);
solve('#',
 ':'
);
solve('C',
 '#'
);