window.addEventListener('load', solve);

function solve() {

    const inputDomElements = {
        first: document.getElementById('first-name'),
        last: document.getElementById('last-name'),
        count: document.getElementById('people-count'),
        fromDate: document.getElementById('from-date'),
        days: document.getElementById('days-count'),
    };
    const other = {
        main: document.getElementById('main'),
        form: document.querySelector('form'),
        ticketContainer: document.querySelector('.ticket-info-list'),
        confirmContainer: document.querySelector('.confirm-ticket'),
        nextBtn: document.getElementById('next-btn'),
        body: document.getElementById('body'),


    };

    let info = {};

    other.nextBtn.addEventListener('click',addTicketHandler);

    function addTicketHandler(event){
        event.preventDefault();

        const tickets = Object.values(inputDomElements);

        for (const input of tickets) {
            if (input.value === ''){
                console.log('NO');
                return;
                
            }
        }

        const {first,last,count,fromDate,days} = inputDomElements;
        info = {
            first: first.value,
            last: last.value,
            count: count.value,
            fromDate: fromDate.value,
            days: days.value,

        };
        const li = createElement('li',other.ticketContainer,'',['ticket']);
        const article = createElement('article',li,);
        createElement('h3',article,`Name: ${first.value} ${last.value}`);
        createElement('p',article,`From date: ${fromDate.value}`);
        createElement('p',article,`For ${days.value} days`);
        createElement('p',article,`For ${count.value} people`);
        const editBtn = createElement('button',li,'Edit',['edit-btn']);
        const continueBtn = createElement('button',li,'Continue',['continue-btn']);


        

        editBtn.addEventListener('click',editHandler);
        continueBtn.addEventListener('click',continueHandler);


        other.form.reset();
        other.nextBtn.setAttribute('disabled',true);

    }
    function continueHandler(){
        const ref = this.parentNode;
        other.confirmContainer.appendChild(ref);
        const edit = ref.querySelector('.edit-btn');
        const contBtn = ref.querySelector('.continue-btn');
        const confirmBtn = createElement('button',ref,'Confirm',['confirm-btn']);
        const cancelBtn = createElement('button',ref,'Cancel',['cancel-btn']);
        edit.remove();
        contBtn.remove();

        cancelBtn.addEventListener('click',removeHandler);
        confirmBtn.addEventListener('click',confirmHandler);


    }

    function removeHandler(){
        this.parentNode.remove();
        other.nextBtn.removeAttribute('disabled');
    }

    function confirmHandler(){
      other.main.remove();
      const h1 = createElement('h1',body,'Thank you, have a nice day!',null,'thank-you');
      const back = createElement('button',body,'Back',null,'back-btn');

      back.addEventListener('click',()=>{
        window.location.reload();
      })
    }

    function editHandler(){
        this.parentNode.remove();
        console.log(info);
        for (const key in info) {
            inputDomElements[key].value = info[key];
                
            }
            other.nextBtn.removeAttribute('disabled');
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


    
    
