function solve(word,text){
    let newWord = word.toLowerCase();
    let newText = text.toLowerCase();

    if(newText.includes(newWord)){
        return word;
    }
        
    return `${word} not found!`
}
console.log(solve('javascript',
'JavaScript is the best programming language'
));
console.log(solve('python',
'JavaScript is the best programming language'
));