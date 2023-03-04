function solve(start,end){
    let sum = 0;
    let arr = [];
    for (let current = start; current <= end; current++) {
      arr.push(current);
      sum += current;  
        
    }
    console.log(arr.join(' '));
    console.log(`Sum: ${sum}`);
}
solve(5, 10);
solve(0,26);