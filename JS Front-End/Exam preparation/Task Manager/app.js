function solve() {

    const input = {
        task: document.getElementById('task'),
        description: document.getElementById('description'),
        date: document.getElementById('date'),

    };
    const others = {
        addBtn: document.getElementById('add'),
        orange: document.querySelector('body > main > div > section:nth-child(2) > div:nth-child(2)'),
        yellow: document.getElementById('in-progress'),
        green: document.querySelector('body > main > div > section:nth-child(4) > div:nth-child(2)'),
    };

    others.addBtn.addEventListener('click',addHandler);

    function addHandler(e){
        e.preventDefault();
        const fields = Object.values(input);
        for (const input of fields) {
            if (input.value === ''){
                console.log('NO');
                return;
            }
        }

        const {task,description,date} = input;

        const article = createElement('article',others.orange);
        createElement('h3',article,`${task.value}`);
        createElement('p',article,`Description: ${description.value}`);
        createElement('p',article,`Due Date: ${date.value}`);
        const div = createElement('div',article,'',['flex']);
        const startBtn = createElement('button',div,'Start',['green']);
        const deleteBtn = createElement('button',div,'Delete',['red']);


        startBtn.addEventListener('click',startHandler);
        deleteBtn.addEventListener('click', ()=>{
            article.remove();
        })

        task.value = '';
        description.value = '';
        date.value = '';


    }

    function startHandler(){
      const ref =  this.parentNode.parentNode;

    //   ref.remove();
      others.yellow.appendChild(ref);
      const start = ref.querySelector('.green');
      const del = ref.querySelector('.red');
      start.textContent = 'Delete';
      start.setAttribute('class','red');
      del.textContent = 'Finish';
      del.setAttribute('class','orange');

      //Delete
      start.addEventListener('click',()=>{
        ref.remove();
      })
      //Finish
      del.addEventListener('click',()=>{
        others.green.appendChild(ref);
        const all = ref.querySelector('.flex');
        all.remove();
        
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


    console.log("//TODO")
}