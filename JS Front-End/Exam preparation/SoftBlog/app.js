function solve(){
   
   const input = {
      author: document.getElementById('creator'),
      title: document.getElementById('title'),
      category: document.getElementById('category'),
      content: document.getElementById('content'),

   };
   const others = {
      createBtn: document.querySelector('body > div > div > aside > section:nth-child(1) > form > button'),
      main: document.querySelector('main > section'),
      ol: document.querySelector('body > div > div > aside > section.archive-section > ol'),
      aside: document.querySelector('aside'),
     
   };

   others.createBtn.addEventListener('click',addHandler);

   function addHandler(e){
         e.preventDefault();

      const {author,title,category,content} = input

      let titleArchive = title.value;

      const article = createElement('article',others.main);
      createElement('h1',article,`${title.value}`);
      const p = createElement('p',article,'Category:');
      createElement('strong',p,`${category.value}`);
      const p1 = createElement('p',article,'Creator:');
      createElement('strong',p1,`${author.value}`);
      const p3 = createElement('p',article,`${content.value}`);
      const div = createElement('div',article,'',['buttons']);
      const deleteBtn = createElement('button',div,'Delete',['btn','delete']);
      const archiveBtn = createElement('button',div,'Archive',['btn','archive']);

      author.value = '';
      title.value = '';
      category.value = '';
      content.value = '';


      archiveBtn.addEventListener('click', ()=>{
      const li = createElement('li',others.ol,`${titleArchive}`);
      article.remove();

      let all = Array.from(document.querySelectorAll('li'));
       
      all.sort((a,b)=>a.textContent.localeCompare(b.textContent))
      .forEach((el)=> others.ol.appendChild(el));
       
      })
      

      deleteBtn.addEventListener('click',()=>{
         article.remove();
         others.aside.remove();
      }
      )
   
   }

   function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
      const element = document.createElement(type);
    
      if (content && useInnerHtml) {
          element.innerHTML = content;
      } else {
        if (content && type !== 'input') {
          element.textContent = content;
        }
    
        if (content && type === 'input') {
          element.value = content;
        }
      }
    
      if (classes && classes.length > 0) {
          element.classList.add(...classes);
      }
    
      if (id) {
          element.id = id;
      }
    
      if (attributes) {
        for (const key in attributes) {
          element.setAttribute(key, attributes[key])
        }
      }
    
      if (parentNode) {
        parentNode.appendChild(element);
      }
    
      return element;
    } 


  }
