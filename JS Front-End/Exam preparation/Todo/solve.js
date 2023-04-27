
function attachEvents() {

const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
const title = document.getElementById('title');
const addBtn = document.getElementById('add-button');
const loadBtn = document.getElementById('load-button');
const todoList = document.getElementById('todo-list');


loadBtn.addEventListener('click', loadHandler);
addBtn.addEventListener('click', addHandler);


async function loadHandler(event){
    if (event){
        event.preventDefault();
    }

    todoList.innerHTML = ''
try {

    const res = await fetch(BASE_URL);
    const data = await res.json();

    const value = Object.values(data);
    console.log(value);

    for (const {_id,name} of value) {
        const li = document.createElement('li');
        const span = document.createElement('span');
        const removeBtn = document.createElement('button');
        const editBtn = document.createElement('button');
        
        li.id = _id
        span.textContent = name;
        removeBtn.textContent = 'Remove';
        editBtn.textContent = 'Edit';

        editBtn.addEventListener("click", editHandler);
        removeBtn.addEventListener("click", removeHandler);

        li.append(span, removeBtn, editBtn)
        todoList.appendChild(li);
    }

} catch (error) {
    console.error(error);
}

}
function removeHandler(){
    const id = this.parentNode.id
    const httpHeaders = {
        method: "DELETE",
    }
    fetch(`${BASE_URL}${id}`, httpHeaders)
        .then(() => loadHandler())
        .catch((err) => {
            console.error(err)
        })
}

function addHandler(event){
    event.preventDefault();
    const name = title.value
    const httpHeaders = {
          method: 'POST',
          body: JSON.stringify({name})
    }
    fetch(BASE_URL, httpHeaders)
          .then(() => {
            loadHandler();
            title.value = ''
          })
          .catch((err) => {
              console.error(err)
          })

}
function editHandler(){
    const refLi = this.parentNode;
    const [span,removeBtn,editBtn] = Array.from(refLi.children);
    const input = document.createElement('input');
    input.value = span.textContent; 
    refLi.prepend(input);
    const submitBtn = document.createElement('button');
    submitBtn.textContent = 'Submit';

    submitBtn.addEventListener('click',submitHandler);

    refLi.appendChild(submitBtn);
    span.remove();
    editBtn.remove();
}
function submitHandler(){
  const ref = this.parentNode;
  const inputV = ref.querySelector('input').value;
  const id = this.parentNode.id;
//   const [input] =  Array.from(ref.children);
  const httpHeaders = {
    method: 'PATCH',
    body: JSON.stringify({inputV})
  }

  fetch(`${BASE_URL}${id}`,httpHeaders)
    .then(()=>loadHandler())
    .catch((err)=>
    console.error(err));


}

}

attachEvents();

function attachEvents() {

    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const title = document.getElementById('title');
    const addButton = document.getElementById('add-button');
    const loadButton = document.getElementById('load-button');
    const todoList = document.getElementById('todo-list');

    loadButton.addEventListener('click',loadHandler);
    addButton.addEventListener('click',addHandler);


    async function loadHandler(event){
        if (event){
            event.preventDefault();
        }
       
        todoList.innerHTML = '';

      const res = await fetch(BASE_URL);
      const data = await res.json();
      
      const info = Object.values(data);

      for (const {name,_id} of info) {

        const li = createElement('li',todoList);
        const span = createElement('span',li,`${name}`);
        const removeBtn = createElement('button',li,'Remove');
        const editBtn = createElement('button',li,'Edit');

        removeBtn.addEventListener('click',()=>{
            httpHeaders = {
                method: 'DELETE'
            }
            fetch (BASE_URL + _id,httpHeaders)
            .then(()=>{
                loadHandler();

            })
            .catch((err)=>{
                console.error(err);
            })

        })

        editBtn.addEventListener('click',()=>{
            span.remove();
            editBtn.remove();
            const input = createElement('input','',`${name}`);
            li.prepend(input);
            const submitBtn = createElement('button',li,'Submit');

            submitBtn.addEventListener('click',()=>{
                
                let name = input.value;
                const httpHeaders ={
                    method: 'PATCH',
                    body: JSON.stringify({name}),
                };

                fetch(BASE_URL + _id,httpHeaders)
                .then(()=>{
                    loadHandler();
                })
                .catch((err)=>{
                    console.error(err);
                })


            });

        });
        
      }


    }
    function addHandler(event){
        event.preventDefault();

    let name = title.value;
    const httpHeaders = {
        method: "POST",
        body: JSON.stringify({name}),
    }

    fetch(BASE_URL,httpHeaders)
     .then(()=>{
        loadHandler();
        title.value = '';
     })
     .catch((err)=>{
        console.error(err);
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
attachEvents();
