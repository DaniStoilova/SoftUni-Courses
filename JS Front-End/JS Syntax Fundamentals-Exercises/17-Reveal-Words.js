function solve(word,text) {
  let newText = word.split(', ');

 while(text.includes('*')){
  for (let index = 0; index < newText.length; index++) {
    text = text.replace('*'.repeat(newText[index].length),newText[index]);
  
  }    
  console.log(text);
  }

  
}
solve('great',
'softuni is ***** place for learning new programming languages'
);
solve('great, learning',
'softuni is ***** place for ******** new programming languages'
)