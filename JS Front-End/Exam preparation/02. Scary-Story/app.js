window.addEventListener("load", solve);

function solve() {

  let scaryStory = {};

const inputDomElements = {
  first: document.getElementById('first-name'),
  last: document.getElementById('last-name'),
  age: document.getElementById('age'),
  title: document.getElementById('story-title'),
  genre: document.getElementById('genre'),
  story: document.getElementById('story')
};
const other = {
  formBtn: document.getElementById('form-btn'),
  preview: document.getElementById('preview-list'),
  form: document.querySelector('form'),
  main: document.getElementById('main'),
};

other.formBtn.addEventListener('click',addHandler);


function addHandler(){
  const info = Object.values(inputDomElements);

  for (const input of info) {
      if (input.value === ''){
          console.log('NO');
          return;
          
      }
  }

  const {first,last,age,title,genre,story} = inputDomElements;

  scaryStory = {
    first: first.value,
    last: last.value,
    age: age.value,
    title: title.value,
    genre: genre.value,
    story: story.value,
  };


  const li = createElement('li',other.preview,'',['story-info']);
  const article = createElement('article',li);
  createElement('h4',article,`Name: ${first.value} ${last.value}`);
  createElement('p',article,`Age: ${age.value}`);
  createElement('p',article,`Title: ${title.value}`); 
  createElement('p',article,`Genre: ${genre.value}`); 
  createElement('p',article,`${story.value}`); 
  const saveBtn = createElement('button',li,'Save Story',['save-btn']);
  const editBtn = createElement('button',li,'Edit Story',['edit-btn']);
  const deleteBtn = createElement('button',li,'Delete Story',['delete-btn']);


  editBtn.addEventListener('click',editHandler);
  saveBtn.addEventListener('click',saveHandler);
  deleteBtn.addEventListener('click',deleteHandler);

  other.form.reset();
  other.formBtn.setAttribute('disabled', true);
}
function deleteHandler(){
  const deleteList = this.parentNode;
  deleteList.remove();
  other.formBtn.removeAttribute('disabled');
}

function editHandler(){
  // const edit = this.parentNode.remove();
  for (const key in scaryStory) {
    inputDomElements[key].value = scaryStory[key];
    }

    other.formBtn.removeAttribute('disabled',true);
    other.preview.innerHTML = '';
    createElement('h3',other.preview,'Preview');
  
  

  }
  function saveHandler(){
    other.main.innerHTML = '';
    createElement('h1',other.main,`Your scary story is saved!`);


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

