function solve(number){
    let numberToString = number.toString();
    let sum = 0;
    for (let digit of numberToString) {
       let num = Number(digit);
        sum += num;
    }
    console.log(sum);

}
solve (245678)
solve(97561)