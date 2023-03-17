function solve(input){
    let search = input.shift().split(' ');

    let words = {};


    for (const word of search) {
        let count = input.filter((w) => w === word).length;
        words[word] = count;
       
    }
   


    let sorted = Object.entries(words).sort((a,b) => {
        let [nameA,countA] = a;
        let [nameB,countB] = b;


      return  countB - countA});

      for (const [word, count] of sorted) {
        console.log(`${word} - ${count}`);
      }

    
}
solve([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
    );
    solve([
        'is the', 
        'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
        );
