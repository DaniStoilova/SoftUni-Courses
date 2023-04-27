function create(words) {

   for (const word of words) {
  const div = document.createElement('div');
  const p = document.createElement('p');
  p.textContent = word;
  p.style.display = 'none';
  div.addEventListener('click', addDisplay);
  div.appendChild(p);

  
      function addDisplay(){
      p.style.display = 'block'
  
}
   let contentDiv = document.getElementById('content');
   contentDiv.appendChild(div);
}

}