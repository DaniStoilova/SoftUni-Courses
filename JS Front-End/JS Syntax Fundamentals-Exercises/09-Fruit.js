function solve(fruit,weight,price){

    let gram = weight/1000;
    let totalPrice = gram * price;
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${gram.toFixed(2)} kilograms ${fruit}.`)
}
solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);

