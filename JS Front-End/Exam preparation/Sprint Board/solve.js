
function attachEvents() {

    let info = [];

    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const loadBtn = document.getElementById('load-board-btn');
    const title = document.getElementById('title');
    const description = document.getElementById('description');
    const createBtn = document.getElementById('create-task-btn');
    const first = document.querySelector('#todo-section > ul');
    const second = document.querySelector('#in-progress-section > ul');
    const third = document.querySelector('#code-review-section > ul');
    const four = document.querySelector('#done-section > ul');


    loadBtn.addEventListener('click',loadHandler);
    createBtn.addEventListener('click',addHandler);


  async function loadHandler(){

    first.innerHTML = '';
    second.innerHTML = '';
    third.innerHTML = '';
    four.innerHTML = '';

        const res = await fetch(BASE_URL);
        const data = await res.json();

     info = Object.values(data);

        for (const {title,description,status,_id} of info) {
            let id = _id;
            console.log(_id);
            if (status === 'ToDo'){
                const li = createElement('li',first,'',['task']);
                li.id = _id;
                console.log(li.id);
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const moveProgress = createElement('button',li,'Move to In Progress');

                moveProgress.addEventListener('click',()=>{
                    info = {
                        title: title.value,
                        description: description.value, 
                        status: 'In Progress'
                    }
                    const httpHeaders = {
                          method: 'PATCH',
                          body: JSON.stringify(info)
                    }
                    fetch(BASE_URL + _id, httpHeaders)
                          .then(() => {
                                loadHandler();
                                title.value = '';
                                description.value = '';
                              
                          })
                          .catch((err) => {
                              console.error(err)
                          })
                });

            }else if (status === 'In Progress'){
                const li = createElement('li',second,'',['task']);
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const moveReview = createElement('button',li,'Move to Code Review');

                moveReview.addEventListener('click',()=>{
                    info = {
                        title: title.value,
                        description: description.value, 
                        status: 'Code Review'
                    }
                    const httpHeaders = {
                          method: 'PATCH',
                          body: JSON.stringify(info)
                    }
                    fetch(BASE_URL + _id, httpHeaders)
                          .then(() => {
                                loadHandler();
                                title.value = '';
                                description.value = '';
                              
                          })
                          .catch((err) => {
                              console.error(err)
                          })
                });

            }else if (status === 'Code Review'){
                const li = createElement('li',third,'',['task']);
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const moveDone = createElement('button',li,'Move to Done');

                moveDone.addEventListener('click',()=>{
                    info = {
                        title: title.value,
                        description: description.value, 
                        status: 'Done'
                    }
                    const httpHeaders = {
                          method: 'PATCH',
                          body: JSON.stringify(info)
                    }
                    fetch(BASE_URL + _id, httpHeaders)
                          .then(() => {
                                loadHandler();
                                title.value = '';
                                description.value = '';
                              
                          })
                          .catch((err) => {
                              console.error(err)
                          })
                });
            }else if (status === 'Done'){
                const li = createElement('li',four,'',['task']);
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const close = createElement('button',li,'Close');

                

                close.addEventListener('click',()=>{
                    const httpHeaders = {
                        method: "DELETE",
                    }
                    fetch(`${BASE_URL}${_id}`, httpHeaders)
                        .then(() => loadHandler())
                        .catch((err) => {
                            console.error(err)
                        })


            })
            }
        }

    }
    function addHandler(){
       info = {
            title: title.value,
            description: description.value, 
            status: 'Todo',
        }
        const httpHeaders = {
              method: 'POST',
              body: JSON.stringify({
                            title: title.value,
                            description: description.value,
                            status: 'ToDo'
                        })
        }
        fetch(BASE_URL, httpHeaders)
              .then(() => {
                    loadHandler();
                    title.value = '';
                    description.value = '';
                  
              })
              .catch((err) => {
                  console.error(err)
              })
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


function attachEvents() {

    let info = [];

    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const loadBtn = document.getElementById('load-board-btn');
    const title = document.getElementById('title');
    const description = document.getElementById('description');
    const createBtn = document.getElementById('create-task-btn');
    const first = document.querySelector('#todo-section > ul');
    const second = document.querySelector('#in-progress-section > ul');
    const third = document.querySelector('#code-review-section > ul');
    const four = document.querySelector('#done-section > ul');


    loadBtn.addEventListener('click',loadHandler);
    createBtn.addEventListener('click',addHandler);


    async function loadHandler(){

    first.innerHTML = '';
    second.innerHTML = '';
    third.innerHTML = '';
    four.innerHTML = '';

        const res = await fetch(BASE_URL);
        const data = await res.json();

     info = Object.values(data);

        for (const {title,description,status,_id} of info) {
            if (status === 'ToDo'){
                const li = createElement('li',first,'',['task']);
                li.id = _id;
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const btnMove = createElement('button',li,'Move to In Progress');
                
                btnMove.addEventListener('click',move);
                    

            }else if (status === 'In Progress'){
                const li = createElement('li',second,'',['task']);
                li.id = _id;
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const btnMove = createElement('button',li,'Move to Code Review');

                btnMove.addEventListener('click',move);

            }else if (status === 'Code Review'){
                const li = createElement('li',third,'',['task']);
                li.id = _id;
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const btnMove = createElement('button',li,'Move to Done');
             
                btnMove.addEventListener('click',move);

            }else if (status === 'Done'){
                const li = createElement('li',four,'',['task']);
                li.id = _id;
                createElement('h3',li,`${title}`);
                createElement('p',li,`${description}`);
                const btnMove = createElement('button',li,'Close');

                
                btnMove.addEventListener('click',()=>{
                    const httpHeaders = {
                        method: "DELETE",
                    }
                    fetch(`${BASE_URL}${_id}`, httpHeaders)
                        .then(() => loadHandler())
                        .catch((err) => {
                            console.error(err)
                        })

            })

            }
           
        }

    }
    function addHandler(){
        first.innerHTML = '';
       info = {
            title: title.value,
            description: description.value, 
            status: 'Todo',
        }
        const httpHeaders = {
              method: 'POST',
              body: JSON.stringify({
                            title: title.value,
                            description: description.value,
                            status: 'ToDo'
                        })
        }
        fetch(BASE_URL, httpHeaders)
              .then(() => {
                    loadHandler();
                    title.value = '';
                    description.value = '';
                  
              })
              .catch((err) => {
                  console.error(err)
              })
            }
    function move() {

    let currentId = this.parentNode.id;

    let content = this.textContent;
    console.log(content);

    if (this.textContent === 'Move to In Progress') {
        const httpHeaders = {
            method: "PATCH",
            body: JSON.stringify({
            status: 'In Progress'
            })
         };
        fetch(BASE_URL + currentId, httpHeaders)
            .then(() => {
                loadHandler()
             title.value = '';
             description.value = '';
            }
             )
            .catch(error => alert(error))
            
        } else if (this.textContent === 'Move to Code Review') {
            const httpHeaders = {
            method: "PATCH",
            body: JSON.stringify({
            status: 'Code Review'
            })
        };
        fetch(BASE_URL + currentId, httpHeaders)
            .then(() => {
                loadHandler()
             title.value = '';
             description.value = '';
            }
             )

            .catch(error => alert(error))
        } else if (this.textContent === 'Move to Done') {
            const httpHeaders = {
            method: "PATCH",
            body: JSON.stringify({
            status: 'Done'
            })
        };
        fetch(BASE_URL + currentId, httpHeaders)
            .then(() => {
                loadHandler()
             title.value = '';
             description.value = '';
            }
             )
            .catch(error => alert(error))
                }
                
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

