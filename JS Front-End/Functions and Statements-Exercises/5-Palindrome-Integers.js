function palindrome(arr){
    
    arr.forEach((element) => {
        console.log(isPalindrome(element));
    });
    function isPalindrome(num){
        let reverseNumber = Number([...num.toString()].reverse().join(''));

        return reverseNumber === num;
    }

}
palindrome([123,323,421,121]);
palindrome([32,2,232,1010]);