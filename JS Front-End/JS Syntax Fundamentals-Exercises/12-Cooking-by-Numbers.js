function solve(number, ...operations){
    let num = Number(number);

    operations
    .forEach((operation) =>{
        switch(operation){
            case 'chop':
            num = num/2;
                break;
            case 'dice':
            num = Math.sqrt(num);
                break;
            case 'spice':
                num++;
                break;
            case 'bake':
                num = num*3;
                break;
            case 'fillet':
                num -= num * 0.20;
                break;
        }
        console.log(num);
    });
   
}
solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');