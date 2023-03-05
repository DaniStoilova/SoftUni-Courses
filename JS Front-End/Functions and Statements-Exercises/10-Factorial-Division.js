function solve (first,second){
   
    function getFactorial(number){
        if (number === 1){
            return number;

        }
        return number * getFactorial(number - 1);
    }
    console.log ((getFactorial(first)/getFactorial(second)).toFixed(2));

}
solve(5,2);
solve(6,2);