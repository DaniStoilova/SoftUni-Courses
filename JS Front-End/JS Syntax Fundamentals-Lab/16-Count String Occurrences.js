function solve (text,searchWord){
    let words = text.split(' ');
    let count = 0;
    for (let word of words) {
        if (word === searchWord) {
           count++;
            
        }  
    }
    console.log(count);
}
solve('softuni is great place for learning new programming languages',
'softuni'
);