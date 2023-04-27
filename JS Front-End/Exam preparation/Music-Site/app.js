window.addEventListener('load', solve);

function solve() {

let like = 0;

const inputDomElements = {
    genre: document.getElementById('genre'),
    name: document.getElementById('name'),
    author: document.getElementById('author'),
    date: document.getElementById('date'),
};
const otherElements = {
   addBtn: document.getElementById('add-btn'),
   collection : document.querySelector('.all-hits-container'),
   saveContainer : document.querySelector('.saved-container'),
   likeContainer: document.querySelector('.likes > p'),
   form: document.querySelector('form'),
};

otherElements.addBtn.addEventListener('click', addHandler);

function addHandler(event){
    event.preventDefault();

    let songs = Object.values(inputDomElements).every((input)=> input.value !== '');

    if (!songs){
        console.log('Yes');
        return;   
    }
    // let songs = Object.values(inputDomElements);

    // for (const input of songs) {
    //     if (input.value === ''){
    //         return
    //     }
    // }

    const {genre, name, author, date} = inputDomElements;

    const divContainer = createElement('div', otherElements.collection,'',['hits-info']);
    
    createElement('img',divContainer,null,null,null,{src: './static/img/img.png'});
    createElement('h2',divContainer,`Genre: ${genre.value}`);
    createElement('h2',divContainer,`Name: ${name.value}`);
    createElement('h2',divContainer,`Author: ${author.value}`);
    createElement('h3',divContainer,`Date: ${date.value}`);
    const saveBtn = createElement('button',divContainer,'Save song',['save-btn']);
    const likeBtn = createElement('button',divContainer,'Like song',['like-btn']);
    const deleteBtn = createElement('button',divContainer,'Delete',['delete-btn']);
  
    
    likeBtn.addEventListener('click', likeHandler);
    saveBtn.addEventListener('click', saveHandler);
    deleteBtn.addEventListener('click', deleteHandler);

    otherElements.form.reset();
}

function saveHandler(){
  const songReference =  this.parentNode;
  const likeB = songReference.querySelector('.like-btn');
  const saveB = songReference.querySelector('.save-btn');
    otherElements.saveContainer.appendChild(songReference);
    likeB.remove();
    saveB.remove();


}
function deleteHandler(){
// event.currentTarget = this
this.parentNode.remove();


}
function likeHandler(){
    this.setAttribute('disabled',true);
    like++;
    otherElements.likeContainer.textContent = `Total Likes: ${like}`;
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