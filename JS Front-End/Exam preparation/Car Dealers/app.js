 window.addEventListener("load", solve);

function solve() {

let infoAuto = {};
let total = 0;

const inputDOMElements ={
  make: document.getElementById('make'),
  model: document.getElementById('model'),
  year: document.getElementById('year'),
  fuel: document.getElementById('fuel'),
  originalCost: document.getElementById('original-cost'),
  sellingPrice : document.getElementById('selling-price'),

 };

 const others = {

  publish: document.getElementById('publish'),
  tableBody: document.getElementById('table-body'),
  form: document.querySelector('form'),
  carsList: document.getElementById('cars-list'),
  profit: document.getElementById('profit'),

 };

others.publish.addEventListener('click', addInfoHandler);

function addInfoHandler(event){
event.preventDefault();

const auto = Object.values(inputDOMElements);

for (const input of auto) {
  if (input.value === '' ){
    console.log('Yes');
    return;
  }else if (input.value !== '' && (inputDOMElements.originalCost.value < inputDOMElements.sellingPrice.value)){
    console.log('true');
  }else if (input.value !== '' && (inputDOMElements.originalCost.value > inputDOMElements.sellingPrice.value)){
    return;
  }
  
}

const {make,model,year,fuel,originalCost,sellingPrice} = inputDOMElements;

infoAuto = {
  make: make.value,
  model: model.value,
  year: year.value,
  fuel: fuel.value,
  originalCost: originalCost.value,
  sellingPrice: sellingPrice.value,
};

const tr = createElement('tr',others.tableBody,'',['row']);
createElement('td',tr,`${make.value}`)
createElement('td',tr,`${model.value}`)
createElement('td',tr,`${year.value}`)
createElement('td',tr,`${fuel.value}`)
createElement('td',tr,`${originalCost.value}`)
createElement('td',tr,`${sellingPrice.value}`)
const tdButton = createElement('td',tr)
const editBtn = createElement('button',tdButton,'Edit',['action-btn', 'edit']);
const sellBtn = createElement('button',tdButton,'Sell',['action-btn', 'sell']);

editBtn.addEventListener('click',editHandler);
sellBtn.addEventListener('click',sellHandler);

others.form.reset();

}
function sellHandler(e){
  e.target.parentNode.parentNode.remove();

  let diff = Number(infoAuto.sellingPrice - infoAuto.originalCost);

  const {make,model,year,fuel,originalCost,sellingPrice} = infoAuto;

    const li = createElement('li',others.carsList,'',['each-list']);
    createElement('span',li,`${infoAuto.make} ${infoAuto.model}`);
    createElement('span',li,`${infoAuto.year}`);
    createElement('span',li,`${Number(infoAuto.sellingPrice - infoAuto.originalCost)}`);

    total += diff;

    others.profit.textContent = `${Number(total).toFixed(2)}`;
  
  }


function editHandler(e){
  e.target.parentNode.parentNode.remove();
  for (const key in infoAuto) {
    inputDOMElements[key].value = infoAuto[key];
  }
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


// function solve() {
//   const makeInputEl = document.getElementById("make");
//   const modelInputEl = document.getElementById("model");
//   const yearInputEl = document.getElementById("year");
//   const fuelInputEl = document.getElementById("fuel");
//   const firstPriceInputEl = document.getElementById("original-cost");
//   const sellingPriceInputEl = document.getElementById("selling-price");
//   const tableEl = document.getElementById("table-body");
//   const soldCarsEl = document.getElementById("cars-list");
//   const totalProfit = document.getElementById("profit");
//   let profitMade = 0;

//   const submitButtonEl = document
//     .getElementById("publish")
//     .addEventListener("click", (ev) => {
//       ev.preventDefault();
//       if (
//         makeInputEl.value !== "" &&
//         modelInputEl.value !== "" &&
//         yearInputEl.value !== "" &&
//         fuelInputEl.value !== "" &&
//         firstPriceInputEl.value !== "" &&
//         sellingPriceInputEl.value
//       ) {
//         addPost(ev,makeInputEl.value,modelInputEl.value,yearInputEl.value,
//           fuelInputEl.value,firstPriceInputEl.value,
//           sellingPriceInputEl.value);
//         clearInputFileds();
//       }
//     });

//   function addPost( ev,makeInputEl,modelInputEl,yearInputEl,fuelInputEl,firstPriceInputEl,sellingPriceInputEl) {
//     // ev.preventDefault();

//     const tr = elGenerator("tr");
//     tr.setAttribute("class", "row");
//     elGenerator("td", `${makeInputEl}`, tr);
//     elGenerator("td", `${modelInputEl}`, tr);
//     elGenerator("td", `${yearInputEl}`, tr);
//     elGenerator("td", `${fuelInputEl}`, tr);
//     elGenerator("td", `${firstPriceInputEl}`, tr);
//     elGenerator("td", `${sellingPriceInputEl}`, tr);
//     const actionCell = elGenerator("td");
//     tr.appendChild(actionCell);

//     const editBtn = elGenerator("button", "Edit", actionCell);
//     editBtn.setAttribute("class", "action-btn");
//     editBtn.setAttribute("id", "edit");
//     const sellBtn = elGenerator("button", "Sell", actionCell);
//     sellBtn.setAttribute("class", "action-btn");
//     sellBtn.setAttribute("id", "sell");

//     tableEl.appendChild(tr);

//     sellBtn.addEventListener("click", (ev) =>
//       sellCar(
//         ev,
//         makeInputEl,
//         modelInputEl,
//         yearInputEl,
//         firstPriceInputEl,
//         sellingPriceInputEl
//       )
//     );
//     editBtn.addEventListener("click", (ev) => editPost(
//         ev,
//         makeInputEl,
//         modelInputEl,
//         yearInputEl,
//         fuelInputEl,
//         firstPriceInputEl,
//         sellingPriceInputEl
//       )
//     );
//   }

//   function editPost(
//     ev,
//     _makeInputEl,
//     _modelInputEl,
//     _yearInputEl,
//     _fuelInputEl,
//     _firstPriceInputEl,
//     _sellingPriceInputEl
//   ) {
//     ev.target.parentNode.parentNode.remove();

//     makeInputEl.value = _makeInputEl;
//     modelInputEl.value = _modelInputEl;
//     yearInputEl.value = _yearInputEl;
//     fuelInputEl.value = _fuelInputEl;
//     firstPriceInputEl.value = _firstPriceInputEl;
//     sellingPriceInputEl.value = _sellingPriceInputEl;
//   }

//   function sellCar(
//     ev,
//     _makeInputEl,
//     _modelInputEl,
//     _yearInputEl,
//     _firstPriceInputEl,
//     _sellingPriceInputEl
//   ) {
//     ev.target.parentNode.parentNode.remove();

//     let profitForCurrentCar = _sellingPriceInputEl - _firstPriceInputEl;

//     const soldLiEl = document.createElement("li");
//     soldLiEl.className = "each-list";
//     const carName = document.createElement("span");
//     carName.textContent = _makeInputEl + " " + _modelInputEl;
//     const carYear = document.createElement("span");
//     carYear.textContent = _yearInputEl;
//     const carProfit = document.createElement("span");
//     carProfit.textContent = profitForCurrentCar;

//     soldLiEl.appendChild(carName);
//     soldLiEl.appendChild(carYear);
//     soldLiEl.appendChild(carProfit);

//     soldCarsEl.appendChild(soldLiEl);

//     profitMade += profitForCurrentCar;

//     totalProfit.textContent = profitMade;
//   }

//   function clearInputFileds() {
//     makeInputEl.value = "";
//     modelInputEl.value = "";
//     yearInputEl.value = "";
//     fuelInputEl.value = "";
//     firstPriceInputEl.value = "";
//     sellingPriceInputEl.value = "";
//   }

//   function elGenerator(type, content, parent) {
//     const element = document.createElement(type);
//     element.textContent = content;

//     if (parent) {
//       parent.appendChild(element);
//     }
//     return element;
//   }
// }