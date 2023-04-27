window.addEventListener('load', solve);

function solve() {

let reservationInfo = {};

inputDOMElements = {
    first: document.getElementById('first-name'),
    last: document.getElementById('last-name'),
    dateIn: document.getElementById('date-in'),
    dateOut: document.getElementById('date-out'),
    count: document.getElementById('people-count'),


};
others = {
    form: document.querySelector('form'),
    nextBtn: document.getElementById('next-btn'),
    reservationContainer: document.querySelector('.info-list'),
    confirm: document.querySelector('.confirm-list'),
    verification: document.getElementById('verification'),

}

others.nextBtn.addEventListener('click',addReservationHandler);


function addReservationHandler(event){
    event.preventDefault();

    const reservation = Object.values(inputDOMElements)
    .every((input)=> input.value !== '');

    if (!reservation){
        console.log('Yes')
        return;
    }

    const {first,last,dateIn,dateOut,count} = inputDOMElements;
    
    reservationInfo = {
        first: first.value,
        last: last.value,
        dateIn: dateIn.value,
        dateOut: dateOut.value,
        count: count.value,
    };

    const li = createElement('li',others.reservationContainer,'', ['reservation-content']);
    const article = createElement('article',li);
    createElement('h3',article,`Name: ${first.value} ${last.value}`);
    createElement('p',article,`From date: ${dateIn.value}`);
    createElement('p',article,`To date: ${dateOut.value}`);
    createElement('p',article, `For ${count.value} people`);
    const editBtn = createElement('button',li,'Edit',['edit-btn']);
    const continueBtn = createElement('button',li,'Continue',['continue-btn']);

    

    editBtn.addEventListener('click',editHandler);
    continueBtn.addEventListener('click',continueHandler);
   
    others.form.reset();
    others.nextBtn.setAttribute('disabled', true);
}

function continueHandler(){
    const ref = this.parentNode;
    others.confirm.appendChild(ref);
    const editBtn = ref.querySelector('.edit-btn');
    const continueBtn = ref.querySelector('.continue-btn');
    const confirmBtn = createElement('button',ref,'Confirm',['confirm-btn']);
    const cancelBtn = createElement('button',ref,'Cancel',['cancel-btn']);


    confirmBtn.addEventListener('click',confirmHandler);
    cancelBtn.addEventListener('click',cancelHandler);

    editBtn.remove();
    continueBtn.remove();


}
function cancelHandler(){
    this.parentNode.remove();
    others.verification.setAttribute('class','reservation-cancelled');
    others.verification.textContent = 'Cancelled.';
    others.nextBtn.removeAttribute('disabled');
}

function confirmHandler(){
    this.parentNode.remove();
    others.verification.setAttribute('class','reservation-confirmed');
    others.verification.textContent = 'Confirmed.';
    others.nextBtn.removeAttribute('disabled');
}

function editHandler(){
    const edit = this.parentNode;
    edit.remove();
    
    for (const key in reservationInfo) {
        inputDOMElements[key].value = reservationInfo[key];
            
    }
    others.nextBtn.removeAttribute('disabled');

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



    
    
