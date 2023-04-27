function attachEvents() {
  const BASE_URL ='http://localhost:3030/jsonstore/collections/books/';
  const loadBooks = document.getElementById('loadBooks');
  const books = document.querySelector('table > tbody');
  const [titleInput,authorInput] = Array.from(document.querySelectorAll('#form input'));
  const submit = document.querySelector('#form > button');
  const header = document.querySelector('#form > h3');

  let id = null ;
 
  
    loadBooks.addEventListener('click', allHandler)
    submit.addEventListener('click', createBook)

    async function allHandler(){
      books.innerHTML = '';
      const res = await fetch(BASE_URL);
      const data = await res.json();
      
      for (const key in data) {
       
        const {author,title} = data[key];
        const row = createHTMLElement('tr','',books,'');
        createHTMLElement('td', title , row,'');
        
        createHTMLElement('td', author , row, '');
        const editBtn = createHTMLElement('button','Edit', row, '');
        const deleteBtn = createHTMLElement('button','Delete', row, '');
        deleteBtn.id = key;

        editBtn.addEventListener('click', ()=>{
          id = key;
          header.textContent= 'Edit FORM';
          submit.textContent = 'Save';
          titleInput.value = title;
          authorInput.value = author;
      })

      deleteBtn.addEventListener('click',deleteHandler);
        
      }

      
      }

      async function createBook(){
        let title = titleInput.value;  
        let author = authorInput.value;
        const httpHeaders = {
          method: 'POST',
          body: JSON.stringify({title,author})
      };
      let url = BASE_URL;

      if (header.textContent === 'Edit FORM'){
        httpHeaders.method = 'PUT';
        url += id;
      }

      try{
          const resCreate = await fetch(url ,httpHeaders)
          const dataCreate = await resCreate.json();
          allHandler();
          if (header.textContent === 'Edit FORM'){
            header.textContent = "FORM"
            submit.textContent = 'Submit'
          }


          titleInput.value ='';
          authorInput.value ='';


      }catch(err){
        console.log(err);
      }

    
    }
    async function deleteHandler(){
      const id = this.id;
      httpHeaders = {
        method : 'DELETE'
        
      }
      await fetch (BASE_URL + id,httpHeaders);
        allHandler();
     

    }

    function createHTMLElement(typeOfEl, content, parentEl, classToAdd) {
      const element = document.createElement(typeOfEl);
      if (content && !content.includes("#")) {
        element.textContent = content;
      }
      if (content && content.includes("#")) {
        element.innerHTML = content;
      }
      if(parentEl){
        parentEl.appendChild(element);
      }
      if(classToAdd){
        element.className = classToAdd;
      }
      return element;
    }
    
  }

attachEvents();