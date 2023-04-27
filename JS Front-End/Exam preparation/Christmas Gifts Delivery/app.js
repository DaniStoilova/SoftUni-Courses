function solution() {

    const gift = document.querySelector('input');
    const button = document.querySelector('button');
    const listContainer = document.querySelector('body > div > section:nth-child(2) > ul');
    const sendContainer = document.querySelector('body > div > section:nth-child(3) > ul');
    const discardContainer = document.querySelector('body > div > section:nth-child(4) > ul');

    button.addEventListener('click',addHandler);

    function addHandler(){

        const li = createElement('li',listContainer,`${gift.value}`,['gift']);
        const sendBtn = createElement('button',li,'Send',null,'sendButton');
        const discardBtn = createElement('button',li,'Discard',null,'discardButton');

        let all = Array.from(listContainer.querySelectorAll('li'));

        all.sort((a,b)=>a.textContent.localeCompare(b.textContent))
        .forEach((el)=> listContainer.appendChild(el));


        let element = gift.value;

        sendBtn.addEventListener('click',()=>{
            
            const liSend = createElement('li',sendContainer,`${element}`,['gift']);

            listContainer.removeChild(li);
            
        })
        discardBtn.addEventListener('click',()=>{
            const liDiscard = createElement('li',discardContainer,`${element}`,['gift']); 
            listContainer.removeChild(li);
        })
       

        gift.value = '';


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
