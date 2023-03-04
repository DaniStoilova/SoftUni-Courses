function solve (groupPeople,type,day){
    let totalPrice;
    switch(type){
        case 'Students':
            if (day === 'Friday'){
                totalPrice = groupPeople * 8.45;
            }else if(day === 'Saturday'){
                totalPrice =groupPeople * 9.80;
            }else{
                totalPrice = groupPeople * 10.46;
            }
            if (groupPeople >= 30){
                totalPrice -= totalPrice * 0.15;
            }
            break;
        case 'Business':
                if (groupPeople >= 100){
                    groupPeople = groupPeople - 10;
                }
                if (day === 'Friday'){
                    totalPrice = groupPeople * 10.90;
                }else if(day === 'Saturday'){
                    totalPrice = groupPeople * 15.60;
                }else{
                    totalPrice = groupPeople * 16.00;
                }
                break;
        case 'Regular':
                    if (day === 'Friday'){
                        totalPrice = groupPeople * 15.00;
                    }else if(day === 'Saturday'){
                        totalPrice = groupPeople * 20.00;
                    }else{
                        totalPrice = groupPeople * 22.50;
                    }

                    if (groupPeople >= 10 && groupPeople <= 20){
                        totalPrice -= totalPrice * 0.05;
                    }

                    break; 

    }
    console.log(`Total price: ${totalPrice.toFixed(2)}`);

}
solve(30,
    "Students",
    "Sunday"
    );
solve(40,
    "Regular",
    "Saturday"
    );
