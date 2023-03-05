// function solve(password){
//     const isValidLength = (pass) => pass.length >= 6 && pass.length <= 10;
//     const isLetterAndDigit = (pass) => /^[A-Za-z0-9]+$/g.test(pass);
//     const isWithTwoDigits = (pass) => [...pass.matchAll(/\d/g)].length >= 2;

//     let isValidPass = true;

//     if (!isValidLength(password)){
//         console.log(`Password must be between 6 and 10 characters`);
//         isValidPass = false;
//     }
//     if (!isLetterAndDigit(password)){
//         console.log(`Password must consist only of letters and digits`);
//         isValidPass = false;
//     }
//     if (!isWithTwoDigits(password)){
//         console.log(`Password must have at least 2 digits`);
//         isValidPass = false;
//     }
//     if (isValidPass){
//         console.log(`Password is valid`);
//     }

// }
function solve(password) {
    function isValidLength(password) {
        return password.length >= 6 && password.length <= 10;
    }

    function isLetterDigit(password) {
        return /^[A-Za-z0-9]+$/g.test(password);
    }
    function countDigit(password) {
        let count = 0;
        for (let char of password) {
            let digit = char.charCodeAt(0);
            if (digit >= 48 && digit <= 57) {
                count++;
            }
        }

        return count >= 2;
    }

   

if (!isValidLength(password)) {
    console.log('Password must be between 6 and 10 characters')
}
if (!isLetterDigit(password)) {
    console.log('Password must consist only of letters and digits');
}
if (!countDigit(password)) {
    console.log(`Password must have at least 2 digits`);
}
if (isValidLength(password) && isLetterDigit(password) && countDigit(password)) {
    console.log('Password is valid');

}
}
solve('logIn');
solve('MyPass123');
solve('Pa$s$s');