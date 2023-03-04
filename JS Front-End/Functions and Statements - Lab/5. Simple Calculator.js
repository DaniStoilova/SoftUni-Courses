function solve(num1,num2,operations){
    const multiply = (a,b) => a * b;
    const divide = (a,b) => a/b;
    const add = (a,b) => a + b;
    const subtract = (a,b) => a - b;

    switch(operations){
        case 'multiply':
            return multiply(num1,num2);
        case 'divide':
            return divide(num1,num2);
        case 'add':
            return add(num1,num2);
        case 'subtract':
            return subtract(num1,num2);
    }
}
console.log(solve(5,
    5,
    'multiply'
    ));
    console.log(solve(40,
        8,
        'divide'
        ));
        console.log(solve(12,
            19,
            'add'
            ));
            console.log(solve(50,
                13,
                'subtract'
                ));
