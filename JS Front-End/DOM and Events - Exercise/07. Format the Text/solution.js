function solve() {
  const textArea = document.getElementById('input');
  const div = document.getElementById('output');
  let text = textArea.value.split('.');
  text.pop();

   while(text.length > 0){
    let sentence = text.splice(0,3).map((p) => p.trimStart());
    const p = document.createElement('p');
    p.textContent = sentence.join('.') + ('.');
    div.appendChild(p);
   }
  
}




