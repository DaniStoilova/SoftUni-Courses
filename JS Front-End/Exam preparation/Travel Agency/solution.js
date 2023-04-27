window.addEventListener('load', solution);

function solution() {

  let info = {};

  input = {
    first: document.getElementById('fname'),
    email: document.getElementById('email'),
    phone: document.getElementById('phone'),
    address: document.getElementById('address'),
    code: document.getElementById('code'),

  };

  others = {
    submitBTN: document.getElementById('submitBTN'),
    infoPreview: document.getElementById('infoPreview'),
    form: document.getElementById('form'),
    editBTN: document.getElementById('editBTN'),
    continueBTN: document.getElementById('continueBTN'),
    block: document.getElementById('block'),

  }

  others.submitBTN.addEventListener('click',submitHandler);
  others.editBTN.addEventListener('click',editHandler);
  others.continueBTN.addEventListener('click',continueHandler);

  function submitHandler(e){
    e.preventDefault();


    const {first,email,phone,address,code} = input;

    if (first.value === '' && email.value === ''){
      console.log('NO');
      return;
    }

    info = {
      first: first.value,
      email: email.value,
      phone: phone.value,
      address: address.value,
      code: code.value,
    };

    createElement('li',others.infoPreview,`Full Name: ${first.value}`);
    createElement('li',others.infoPreview,`Email: ${email.value}`);
    createElement('li',others.infoPreview,`Phone Number: ${phone.value}`);
    createElement('li',others.infoPreview,`Address: ${address.value}`);
    createElement('li',others.infoPreview,`Postal Code: ${code.value}`);

   

    others.submitBTN.setAttribute('disabled',true);
    others.editBTN.removeAttribute('disabled');
    others.continueBTN.removeAttribute('disabled');

    first.value = ''; 
    email.value = '';
    phone.value = '';
    address.value = '';
    code.value ='';

    // others.form.reset();

  }

  function editHandler(){
    others.infoPreview.remove();

    for (const key in info) {
      input[key].value = info[key];
    }

    others.submitBTN.removeAttribute('disabled');
    others.editBTN.setAttribute('disabled',true);
    others.continueBTN.setAttribute('disabled',true);


  }

  function continueHandler(){
      others.block.innerHTML = '';
      createElement('h3',others.block,`Thank you for your reservation!`);
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
  console.log('TODO: Write the missing functionality!');
}
