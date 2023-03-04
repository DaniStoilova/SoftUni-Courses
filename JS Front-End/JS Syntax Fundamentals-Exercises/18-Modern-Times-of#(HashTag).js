function solve (text){
    let words = text.split(' ');

    let result = [];
    for (const word of words) {
        if (word.startsWith('#') && word.length > 1 && checkWordIsValid(word)){
            result.push(word.slice(1));
        }
    }
   console.log(result.join('\n'));

   function checkWordIsValid(newWord){
        let newWordLower = newWord.toLowerCase().slice(1);
        let isValid = true;

        for (const symbol of newWordLower) {
            let asciCode = symbol.charCodeAt(0);
            if(!(asciCode >= 97 && asciCode <= 122)){
                isValid = false;
                break;
            }

        }
        return isValid;
   }
}
solve('Nowadays everyone uses # to tag a #special word in #socialMedia');
solve('The symbol # is known #variously in English-speaking #regions as the #number sign');