function solve(num1,num2,num3){
    const sum = (a,b) => a + b;
    const subtract = (sum,c) => sum - c;
    
 return subtract((sum(num1,num2)), num3);
}
console.log(solve(23,
    6,
    10
    ));
    console.log(solve(1,
    17,
    30
    ));
    console.log(solve(42,
    58,
    100
    ));