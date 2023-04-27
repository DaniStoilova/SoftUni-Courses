function solve() {
  const generateBtn = document.querySelector('#exercise > button:nth-child(3)');
  const tbody = document.querySelector('.table > tbody');
  const inputArea = document.querySelector('#exercise > textarea:nth-child(2)');
  const buyButton = document.querySelector('#exercise > button:nth-child(6)');
  const textarea = document.querySelector('#exercise > textarea:nth-child(5)');


  generateBtn.addEventListener('click', addHandler);
  buyButton.addEventListener('click',buyHandler);

  function addHandler(){

    const data = JSON.parse(inputArea.value);
  

    for (const {name,img,price,decFactor} of data) {

    const row = createElement('tr',tbody);
    const first = createElement('td',row);
    const imgInput = createElement('img',first,'','','',{src: img});
    const second = createElement('td',row);
    createElement('p',second,name,'');
    const third = createElement('td',row);
    createElement('p',third,price);
    const four = createElement('td',row);
    createElement('p',four,decFactor);
    const five = createElement('td',row);
    const check = createElement('input',five);
    check.setAttribute('type','checkbox');
   
    

  }
}
  function buyHandler(){
    const checkInput = (Array.from(document.querySelectorAll('tbody tr input:checked')));
    let info = [];
    let total = 0;
    let totalDec = 0;


    for (const input of checkInput) {
     const row = input.parentElement.parentElement ;
     const [_first,second,third,four] = Array.from(row.children);
     let element = second.children[0].textContent;
     info.push(element);
     let num = Number(third.children[0].textContent);
     total += num;
     let currentFactor = Number(four.children[0].textContent);
     totalDec += currentFactor;
    }

    textarea.value += `Bought furniture: ${info.join(', ')}\n`;
    textarea.value += `Total price: ${total.toFixed(2)}\n`;
    textarea.value += `Average decoration factor: ${totalDec/checkInput.length}`;

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
