// function attachEvents() {

// const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';
// const addBtn = document.getElementById('add-product');
// const updateB = document.getElementById('update-product');
// const loadBtn = document.getElementById('load-product');
// const tbody= document.getElementById('tbody');


// const input = {
//      product: document.getElementById('product'),
//      count: document.getElementById('count'),
//      price: document.getElementById('price'),
// }


// loadBtn.addEventListener('click', loadHandler);
// addBtn.addEventListener('click',addHandler);
// updateB.addEventListener('click',update);

// let editInfoProduct = {};

// async function loadHandler(event){
//     if (event){
//         event.preventDefault();
//     }
    
//     tbody.innerHTML = '';
    
//     const res = await fetch(BASE_URL);
//     const data = await res.json();

//     const list = Object.values(data);

//     for (const {product, count, price, _id} of list) {
//         const tr = createElement('tr',tbody);
//         tr.id = _id;
//         id =_id;
//         createElement('td',tr,product,['name']);
//         createElement('td',tr,count,['count-product']);
//         createElement('td',tr,price,['product-price']);
//         const td = createElement('td',tr,'',['btn']);
//         const updateBtn = createElement('button',td,'Update',['update']);
//         const deleteBtn = createElement('button',td,'Delete',['delete']);

//         deleteBtn.addEventListener('click',()=>{

//             const httpHeaders = {
//                 method: 'DELETE'
//               };
          
//               fetch(`${BASE_URL}${_id}`, httpHeaders)
//                 .then(() => loadHandler())
//                 .catch((err) => {
//                   console.error(err);
//                 })
//         }
//         )
//          updateBtn.addEventListener('click',()=>{
//             editInfoProduct = list.find((p) => p.product === product);
//             for (const key in input) {
//             input[key].value = editInfoProduct[key];
//             }
//             addBtn.setAttribute('disabled', true);
//             updateB.removeAttribute('disabled');

//          });
//     }

// }
// function update(event){
//     event.preventDefault();
//     let info = {
//         product: product.value,
//         count: count.value,
//         price: price.value,
//       };
//     const httpHeaders = {
//         method: 'PATCH',
//         body: JSON.stringify(info)
//     };
    
//     fetch(BASE_URL + editInfoProduct._id,httpHeaders)
//     .then(()=>{
//         loadHandler();
//         addBtn.removeAttribute('disabled');
//         updateB.setAttribute('disabled', true);
//         product.value = '';
//         count.value = '';
//         price.value = '';
    
//     }
//     )
//     .catch((err) => {
//         console.error(err);
//       })
// }

// function addHandler(event){
//     event.preventDefault();
// let info = {
//     product: product.value,
//     count: count.value,
//     price: price.value,
//   };
// const httpHeaders = {
//     method: 'POST',
//     body: JSON.stringify(info)
// };

// fetch(BASE_URL,httpHeaders)
// .then(()=>{
//     loadHandler();
//     product.value = '';
//     count.value = '';
//     price.value = '';

// }
// )
// .catch((err) => {
//     console.error(err);
//   })

// }



//  function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
//   const element = document.createElement(type);

//   if (content && useInnerHtml) {
//       element.innerHTML = content;
//   } else {
//     if (content && type !== 'input') {
//       element.textContent = content;
//     }

//     if (content && type === 'input') {
//       element.value = content;
//     }
//   }

//   if (classes && classes.length > 0) {
//       element.classList.add(...classes);
//   }

//   if (id) {
//       element.id = id;
//   }

//   if (attributes) {
//     for (const key in attributes) {
//       element.setAttribute(key, attributes[key])
//     }
//   }

//   if (parentNode) {
//     parentNode.appendChild(element);
//   }

//   return element;
// } 
// }
// attachEvents();

function attachEvents() {

  const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';
  const addBtn = document.getElementById('add-product');
  const updateButton = document.getElementById('update-product');
  const loadBtn = document.getElementById('load-product');
  const tbody = document.getElementById('tbody');

  const input ={
    product: document.getElementById('product'),
    count: document.getElementById('count'),
    price: document.getElementById('price'),
  }

  loadBtn.addEventListener('click',loadHandler);
  addBtn.addEventListener('click',addHandler);
  updateButton.addEventListener('click', updateProducts);

  let info = [];
  let updateInfo = {};

async function loadHandler(event){
  if(event){
    event.preventDefault();
  }

    tbody.innerHTML = '';
    
    const res = await fetch(BASE_URL);
    const data = await res.json();

   info = Object.values(data);

    for (const {product,count,price,_id} of info) {
      
      const tr = createElement('tr',tbody);
      tr.id = _id;
      createElement('td',tr,`${product}`,['name']);
      createElement('td',tr,`${count}`,['count-product']);
      createElement('td',tr,`${price}`,['product-price']);
      const td = createElement('td',tr,'',['btn']);
      const updateBtn = createElement('button',td,'Update',['update']);
      const deleteBtn = createElement('button',td,'Delete',['delete']);

      deleteBtn.addEventListener('click',deleteHandler);
      updateBtn.addEventListener('click',updateHandler);


    }
    
    }
    function addHandler(event){
      event.preventDefault();
      let infoProduct = {
        product: product.value,
        count: count.value,
        price: price.value,
      };
      const httpHeaders = {
        method: 'POST',
        body: JSON.stringify(infoProduct),
      }
      fetch (BASE_URL,httpHeaders)
      .then(()=> {
        loadHandler();
        product.value = '';
        count.value = '';
        price.value = '';
      })

}
function deleteHandler(){
  const id = this.parentNode.parentNode.id;
  const httpHeaders = {
    method: 'DELETE'
  }
  fetch(BASE_URL + id,httpHeaders)
  .then(()=>{
    loadHandler();
  })
  .catch((err)=>{
    console.error(err);
  })

}
function updateHandler(){
  const id = this.parentNode.parentNode.id;
  updateInfo = info.find((p)=> p._id === id)
  for (const key in input) {
    input[key].value = updateInfo[key];
  }
addBtn.setAttribute('disabled',true);
updateButton.removeAttribute('disabled');

}
function updateProducts(event){
  event.preventDefault();

  let infoProduct = {
    product: product.value,
    count: count.value,
    price: price.value,
  };
  const httpHeaders = {
    method: 'PATCH',
    body: JSON.stringify(infoProduct),
  }
  fetch (BASE_URL + updateInfo._id,httpHeaders)
  .then(()=> {
    loadHandler();
    addBtn.removeAttribute('disabled');
    updateButton.setAttribute('disabled', true);
    product.value = '';
    count.value = '';
    price.value = '';
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
attachEvents();
