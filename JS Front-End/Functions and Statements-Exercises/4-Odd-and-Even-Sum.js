function solve(number){
  let oddSum = 0;
  let evenSum = 0;
  // let y = number.toString().split('');
  // for (let index = 0; index < y.length; index++) {
  //   let num = y[index];
    
  //   if (num % 2 === 0){
  //       evenSum += Number(num);
  //   }else{
  //       oddSum += Number(num);
  //   }
    
  // }
  // console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);


    while (number > 0) {
    let lastNum = number % 10;
        if(lastNum % 2 === 0){
        evenSum += lastNum;
        }else{
        oddSum += lastNum;
       }
       number = Math.floor (number/10);
       
    }
    
    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
        

}
solve(1000435);
solve(3495892137259234);