window.addEventListener('load', solve);

function solve() {

inputFields = {
    typeProduct : document.getElementById('type-product'),
    description: document.getElementById('description'),
    name: document.getElementById('client-name'),
    phone: document.getElementById('client-phone'),

};
othersFields = {
    submitBtn: document.querySelector('button'),
    form: document.querySelector('form'),
    receivedOrders: document.getElementById('received-orders'),
    completedOrders: document.getElementById('completed-orders'),
    clearBtn: document.querySelector('.clear-btn'),
    container: document.querySelector(".container"),

}


othersFields.submitBtn.addEventListener('click',receivedHandler);
othersFields.clearBtn.addEventListener('click',clearHandler);

function receivedHandler(e){

    e.preventDefault();

    const info = Object.values(inputFields);

    for (const input of info) {
        if (input.value === ''){
            console.log('No');
            return ;
        }
    }

    const {typeProduct,description,name,phone} = inputFields;

    const div  = createElement('div',othersFields.receivedOrders,'',['container']);
    createElement('h2',div,`Product type for repair: ${typeProduct.value}`);
    createElement('h3',div,`Client information: ${name.value}, ${phone.value}`);
    createElement('h4',div,`Description of the problem: ${description.value}`);
    const startBtn = createElement('button',div,'Start repair',['start-btn']);
    const finishBtn = createElement('button',div,'Finish repair',['finish-btn']);
    finishBtn.setAttribute('disabled', true);

    

        startBtn.addEventListener('click', ()=>{
        startBtn.setAttribute('disabled',true);
        finishBtn.removeAttribute('disabled',true);
    });

    finishBtn.addEventListener('click',completedHandler);


    othersFields.form.reset();



}
function clearHandler(){
    const ref =  this.parentNode;

    const container = Array.from(ref.querySelectorAll('.container'));
    for (const element of container) {
      element.remove();
    }
   


}

function completedHandler(){
  const ref =  this.parentNode;
  ref.remove();
  const start = ref.querySelector('.start-btn');
  const finish = ref.querySelector('.finish-btn');
    othersFields.completedOrders.appendChild(ref);
    start.remove();
    finish.remove();

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