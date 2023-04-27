window.addEventListener("load", solve);

function solve() {

  let info = {};


  const inputDOMElements = {
    title: document.getElementById('post-title'),
    category: document.getElementById('post-category'),
    content: document.getElementById('post-content'),
  };
  const others = {
    reviewContainer: document.getElementById('review-list'),
    publishContainer: document.getElementById('published-list'),
    publishBtn: document.getElementById('publish-btn'),
    form: document.querySelector('.newPostContent'),
    clear: document.getElementById('clear-btn'),
  };

  others.publishBtn.addEventListener('click',addNewPostHandler);
  others.clear.addEventListener('click',deleteHandler);

  function addNewPostHandler(){

    const post = Object.values(inputDOMElements);

    for (const input of post) {
      if (input.value === ''){
        return;
      }
    }

    const {title, category,content} = inputDOMElements;

    info = {
      title: title.value,
      category: category.value,
      content: content.value,
    };

    const li = createElement('li',others.reviewContainer,'',['rpost']);
    const article = createElement('article',li);
    createElement('h4',article,`${title.value}`);
    createElement('p',article,`Category: ${category.value}`);
    createElement('p',article,`Content: ${content.value}`);
    const approveBtn = createElement('button',li,'Approve',['action-btn','approve']);
    const editBtn = createElement('button',li,'Edit',['action-btn','edit']);

    editBtn.addEventListener('click',editHandler);
    approveBtn.addEventListener('click',approveHandler);

    others.form.reset();

  }
  function approveHandler(){
   const ref =  this.parentNode;
   ref.remove();
   const edit = ref.querySelector('.action-btn.edit');
   const approve = ref.querySelector('.action-btn.approve');
   others.publishContainer.appendChild(ref);
   edit.remove();
   approve.remove();
   
   
    
  }

  function editHandler(){
    this.parentNode.remove();
    for (const key in info) {
     inputDOMElements[key].value = info[key];
    }
  }
  function deleteHandler(){
    others.publishContainer.innerHTML = '';
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
