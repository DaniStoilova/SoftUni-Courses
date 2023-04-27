function attachEvents() {
  const BASE_URL = 'http://localhost:3030/jsonstore/collections/students';
  const submit = document.getElementById('submit');
  const tbody = document.querySelector('tbody');
  const fName = document.getElementsByTagName('input')[0];
  const lName = document.getElementsByTagName('input')[1];
  const number = document.getElementsByTagName('input')[2];
  const grade = document.getElementsByTagName('input')[3];

  
 
  submit.addEventListener('click', create);

  loadHandler();

  async function loadHandler(){
  try {
    const res = await fetch(BASE_URL);
    const data = await res.json();
  
    // const values = Object.values(data);
  
      Object.values(data).forEach((el) => {
      const grade = Number(el.grade);
      const tableRow = createHTMLElement('tr', '', tbody, '');
      createHTMLElement('td', el.firstName, tableRow,'');
      createHTMLElement('td',el.lastName, tableRow, '');
      createHTMLElement('td', el.facultyNumber, tableRow, '');
      createHTMLElement('td', `${grade.toFixed(2)}`, tableRow, '');
    });
  } catch (error) {
    console.error(error);
  }

}

async function create(){
  let name = fName.value;
  let last = lName.value;
  let num = number.value;
  let gradeEX = grade.value;
  let body = {
          firstName: name,
          lastName: last,
          facultyNumber: num,
          grade: gradeEX,
        };
  const httpHeaders = {
      method: 'POST',
      body: JSON.stringify(body)
  };
  try{
      const resCreate = await fetch(BASE_URL,httpHeaders)
      const dataCreate = await resCreate.json();
      tbody.textContent = "";
      loadHandler();
      fName.value = '';
      lName.value = '';
      number.value= '';
      grade.value = '';
  } catch (error) {
    console.error(error);
  }
}

function createHTMLElement(typeOfElement, content, parent, classList) {
  const element = document.createElement(typeOfElement);
  if (content) {
    element.textContent = content;
  }
  if (parent) {
    parent.appendChild(element);
  }
  if (classList) {
    element.classList.add(classList);
  }
  return element;
}

}

attachEvents();













