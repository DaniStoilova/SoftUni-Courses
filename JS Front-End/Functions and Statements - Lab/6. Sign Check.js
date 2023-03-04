function solve(...numbers){
  return  numbers
    .filter (num => (num < 0))
    .length % 2 === 0 ? 'Positive' : 'Negative';

}
console.log(solve( 5,
    12,
   -15
   ));
   console.log(solve( 5-6,
    -12,
     14
   ));
   console.log(solve( -1,
    -2,
   -3
   ));