function solve(input){

let lowerCase = input.toLowerCase().split(' ');

let words = {};

for (const word of lowerCase) {
    if (!words.hasOwnProperty(word)){
         words[word] = 1;
    }else{
        let value = words[word];
        words[word] = value + 1;
    }
   
    
}
let result = [];
for (const w in words) {
    if (words[w] % 2 !== 0){
        result.push(w);
    }
    
}
console.log(result.join(' '));


}
solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
solve('Cake IS SWEET is Soft CAKE sweet Food');