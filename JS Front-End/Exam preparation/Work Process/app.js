function solve() {
    let workersInfo = {};
    let budget = 0;

const inputFields = {
    first: document.getElementById('fname'),
    last: document.getElementById('lname'),
    email: document.getElementById('email'),
    birth: document.getElementById('birth'),
    position: document.getElementById('position'),
    salary: document.getElementById('salary'),

};

const others = {
    addBtn: document.getElementById('add-worker'),
    form: document.querySelector('form'),
    tbody: document.getElementById('tbody'),
    sum: document.getElementById('sum'),

};

others.addBtn.addEventListener('click',addHandler);

function addHandler(event){
event.preventDefault(event);

const workers = Object.values(inputFields);

for (const input of workers) {
    if (input.value === ''){
        console.log('NO');
        return;
    }
}

const {first,last,email,birth,position,salary} = inputFields;

workersInfo = {
    first: first.value,
    last: last.value,
    email: email.value,
    birth: birth.value,
    position: position.value,
    salary: salary.value,

};


const tr = createElement('tr',others.tbody);
createElement('td',tr,`${first.value}`);
createElement('td',tr,`${last.value}`);
createElement('td',tr,`${email.value}`);
createElement('td',tr,`${birth.value}`);
createElement('td',tr,`${position.value}`);
createElement('td',tr,`${salary.value}`);
const td = createElement('td',tr);
const firedBtn = createElement('button',td,'Fired',['fired']);
const editBtn = createElement('button',td,'Edit',['edit']);


editBtn.addEventListener('click',editHandler);
firedBtn.addEventListener('click',deleteHandler);



budget += Number(workersInfo.salary);

others.sum.textContent = `${Number(budget).toFixed(2)}`;



others.form.reset();

}

function editHandler(){
   const ref = this.parentNode.parentNode;
   
  
  for (const key in workersInfo) {
      inputFields[key].value = workersInfo[key];
    }
    ref.remove();

  budget -= Number(workersInfo.salary);
   
  others.sum.textContent = `${Number(budget).toFixed(2)}`;



}
function deleteHandler(){
  const ref = this.parentNode.parentNode;
  ref.remove();
  budget -= Number(workersInfo.salary);
   
 others.sum.textContent = `${Number(budget).toFixed(2)}`;
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