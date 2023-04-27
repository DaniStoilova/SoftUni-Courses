function solve() {
   const searchInput = document.getElementById('searchField');
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {

   const searchWord = searchInput.value;
   let row = Array.from(document.querySelectorAll('tbody tr'));

   for (const line of row) {

      let textContentTrim = line.textContent.trim();

      debugger;
      if (line.classList.contains('select')){
            line.classList.remove('select');
      }

      if (textContentTrim.includes(searchWord)){
         line.classList.add('select');
      }
      
   }
   searchInput.value = '';

   }
}