window.addEventListener("load", solve);

function solve() {


  let info = {};
  let dishes = 0;

  const inputDOMElements = {

    first: document.getElementById('first-name'),
    last: document.getElementById('last-name'),
    age: document.getElementById('age'),
    gender: document.getElementById('genderSelect'),
    task: document.getElementById('task'),

  };

  const others = {
    formBtn: document.getElementById('form-btn'),
    inProgressContainer: document.getElementById('in-progress'),
    form: document.querySelector('form'),
    progressCount: document.getElementById('progress-count'),
    finished: document.getElementById('finished'),
    clear: document.getElementById('clear-btn'),

  };

  others.formBtn.addEventListener('click', descriptionHandler);
  others.clear.addEventListener('click',deleteHandler);

  function descriptionHandler(event){
    event.preventDefault();


    const dish = Object.values(inputDOMElements);

    for (const input of dish) {
      if (input.value === ''){
        console.log('No')
        return;
      }
    }

    const {first,last,age,gender,task} = inputDOMElements;

    info = {
      first: first.value,
      last: last.value,
      age: age.value,
      gender: gender.value,
      task: task.value,
    };

    const li = createElement('li',others.inProgressContainer,'',['each-line']);
    const article = createElement('article',li);
    createElement('h4',article,`${first.value} ${last.value}`);
    createElement('p',article,`${gender.value}, ${age.value}`);
    createElement('p',article,`Dish description: ${task.value}`);
    const editBtn = createElement('button',li,'Edit',['edit-btn']);
    const completeBtn = createElement('button',li,'Mark as complete',['complete-btn']);
    
    editBtn.addEventListener('click', editHandler);
    completeBtn.addEventListener('click',completeHandler);

    dishes++;

    others.progressCount.textContent = `${dishes}`;

    others.form.reset();
  }
  function deleteHandler(){
   others.finished.innerHTML = '';
  }

  function completeHandler(){
   const ref = this.parentNode;
   ref.remove();
   others.finished.appendChild(ref);
   const edit = ref.querySelector('.edit-btn');
   const complete = ref.querySelector('.complete-btn');

   dishes--;
    others.progressCount.textContent = `${dishes}`;

   edit.remove();
   complete.remove();

  }



  function editHandler(){
    this.parentNode.remove();
    for (const key in info) {
      inputDOMElements[key].value = info[key];
      
    }
    dishes--;
    others.progressCount.textContent = `${dishes}`;
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
