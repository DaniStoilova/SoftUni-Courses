function solve (inputFirst,inputSecond){

    let combined = [...inputFirst,...inputSecond];

    let productInfo = {};
  
  for (let index = 0; index < combined.length; index++) {
    let element = combined[index];
        if (index % 2 === 0){
            if (!productInfo.hasOwnProperty(element)){
                 productInfo[element] = 0;
                }
          
        }else{
            let quantity = Number(element);
            let product = combined[index - 1];
            productInfo[product] += quantity;
        }
          
  
  }

    for (const key in productInfo) {
        console.log(`${key} -> ${productInfo[key]}`);
    }


}
solve([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
    );