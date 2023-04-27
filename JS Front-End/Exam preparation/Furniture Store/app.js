window.addEventListener('load', solve);

function solve() {

    let sum = 0;

const inputFields = {
    model: document.getElementById('model'),
    year: document.getElementById('year'),
    description: document.getElementById('description'),
    price: document.getElementById('price'),

};
 othersFields = {
    addBtn: document.getElementById('add'),
    furnitureList : document.getElementById('furniture-list'),
    form: document.querySelector('form'),
    total: document.querySelector('.total-price'),
 };

 othersFields.addBtn.addEventListener('click',addHandler);

 function addHandler(e){
    e.preventDefault();
    const furniture = Object.values(inputFields);

    for (const input of furniture) {
        if (input.value === '' || inputFields.year.value <= 0 || inputFields.price.value <= 0){
            console.log('NO');
            return;
        }
    }

    const {model,year,description,price} = inputFields;

    const tr = createElement('tr',othersFields.furnitureList,'',['info']);
    createElement('td',tr,`${model.value}`);
    const priceA = price.value;
    createElement('td',tr, `${Number(priceA).toFixed(2)}`);
    const td = createElement('td',tr);
    const moreButton = createElement('button',td,'More Info',['moreBtn']);
    const buyButton = createElement('button',td,'Buy it',['buyBtn']);
    const tRow = createElement('tr',othersFields.furnitureList,'',['hide']);
    createElement('td',tRow,`Year: ${year.value}`);
    const tdColspan = createElement('td',tRow, `Description: ${description.value}`);
    tdColspan.setAttribute('colspan','3');
    
    model.value = '';
    year.value = '';
    description.value = '';
    price.value = '';

    moreButton.addEventListener('click',()=>{
        if(moreButton.textContent === "More Info"){
            moreButton.textContent = 'Less Info';
            tRow.style.display = 'contents';
        }else{
            moreButton.textContent = "More Info";
            tRow.style.display = "none";   
        }
        
       
    });
    
    buyButton.addEventListener('click',()=>{
       
        othersFields.furnitureList.innerHTML = '';

        sum += Number(priceA);
        

        othersFields.total.textContent = `${(Number(sum).toFixed(2))}`;
    })




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
