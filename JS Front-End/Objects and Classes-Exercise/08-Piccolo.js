function solve (input){
    let cars = new Set();

    for (const line of input) {
        let [direction, carNumber] = line.split(', ');
        if (direction === 'IN'){
            cars.add(carNumber);
        }else{
            cars.delete(carNumber);

        }
    }

    
    if (cars.size === 0){
        console.log(`Parking Lot is Empty`);
    }else{
        let sorted = [...cars.keys()].sort((a,b) => a.localeCompare(b)).forEach((num) => 
        console.log(num)
        );
        
    }


}
solve(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'IN, CA9999TT',
'IN, CA2866HI',
'OUT, CA1234TA',
'IN, CA2844AA',
'OUT, CA2866HI',
'IN, CA9876HH',
'IN, CA2822UU']
);
solve(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'OUT, CA1234TA']
);