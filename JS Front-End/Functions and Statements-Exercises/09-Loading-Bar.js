function solve (number){
    let arr = [];
        let percentage = '%'.repeat(number/10);
        let point = '.'.repeat(10 - number/10);
        arr.push(percentage);
        arr.push(point);


    if (number === 100){
        console.log(`100% Complete!`)
        console.log(`${number}% [${arr.join('')}]`);
    }else{
        console.log(`${number}% [${arr.join('')}]`);
        console.log(`Still loading...`);
    }
    

}
solve(30);
solve(50);
solve(100);