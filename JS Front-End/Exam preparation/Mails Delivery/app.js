function solve() {

    let infoMessages = {};

const inputsFields = {
    recipientName: document.getElementById('recipientName'),
    title: document.getElementById('title'),
    message: document.getElementById('message'),
};
const othersFields = {
    form: document.querySelector('form'),
    addBtn: document.getElementById('add'),
    resetBtn: document.getElementById('reset'),
    listMails: document.getElementById('list'),
    sentList: document.querySelector('.sent-list'),
    deleteList: document.querySelector('.delete-list'),
};

othersFields.addBtn.addEventListener('click',addHandler);
othersFields.resetBtn.addEventListener('click',resetHandler);

function addHandler(event){
    event.preventDefault();

    const sms = Object.values(inputsFields);

    for (const input of sms) {
        if (input.value === ''){
            console.log('no')
            return;
        }
    }

    const {recipientName,title,message} = inputsFields;

    infoMessages = {
        recipientName: recipientName.value,
        title: title.value,
        message: message.value,
        };

        const li  = createElement('li',othersFields.listMails,'');
        createElement('h4',li,`Title: ${title.value}`);
        createElement('h4',li,`Recipient Name: ${recipientName.value}`);
        createElement('span',li,`${message.value}`);
        const div = createElement('div',li,null,null,'list-action');
       
        const sendBtn = createElement('button',div,'Send');
        sendBtn.setAttribute('type', 'submit');
        sendBtn.setAttribute('id', 'send')
        const deleteBtn = createElement('button',div,'Delete');
        deleteBtn.setAttribute('type', 'submit');
        deleteBtn.setAttribute('id', 'delete');
        

        sendBtn.addEventListener('click',sendHandler);
        deleteBtn.addEventListener('click', deleteHandler);

        // othersFields.form.reset();

        recipientName.value = '';
        title.value = '';
        message.value = '';
        
    

}
function deleteHandler(){
    this.parentNode.parentNode.remove();
    const li = createElement('li',othersFields.deleteList);
    createElement('span',li,`To: ${infoMessages.recipientName}`);
    createElement('span',li,`Title: ${infoMessages.title}`);
}
function sendHandler(){
    const ref = this.parentNode.parentNode;
    ref.remove();
    const li = createElement('li',othersFields.sentList);
    createElement('span',li,`To: ${infoMessages.recipientName}`);
    createElement('span',li,`Title: ${infoMessages.title}`);
    const divSend = createElement('div',li,'',['btn']);
    const delBtn = createElement('button',divSend,'Delete');
    delBtn.setAttribute('type','submit')
    delBtn.setAttribute('class' , ['delete']);

   
    delBtn.addEventListener('click',deleteHandler);

}
function resetHandler(event){
    event.preventDefault();
    recipientName.value = '';
    title.value = '';
    message.value = '';


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
solve()