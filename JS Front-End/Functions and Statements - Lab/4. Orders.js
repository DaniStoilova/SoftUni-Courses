function solve(product,quantity ){
    price = 0;
    switch(product){
        case 'coffee':
            price = 1.50;
            break;
        case 'water':
            price = 1.00;
        break;
        case 'coke':
            price = 1.40;
        break;
        case 'snacks':
            price = 2.00;
        break;

    }
    let total = price * quantity;
    console.log(total.toFixed(2))

}
solve("water", 5);
solve("coffee", 2);