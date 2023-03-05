function solve(perfectNumber){
    let sum = 0;
    for (let current = 1; current <= perfectNumber/2; current++) {
        if (perfectNumber % current == 0){
            sum += current;
        } 
    }
    
    if (sum == perfectNumber){
        console.log(` We have a perfect number!`);
    }else{
        console.log(`It's not so perfect.`);
    }

}
solve(6);
solve(28);
solve(1236498);