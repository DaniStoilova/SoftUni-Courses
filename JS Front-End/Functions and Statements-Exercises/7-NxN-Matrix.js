function solve(n){
    return new Array(n).fill(new Array(n).fill(n)).forEach(el => console.log(el.join(' ')));

}
solve(3);
solve(7);
solve(2);