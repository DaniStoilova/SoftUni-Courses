// function attachEvents() {
//     //get
//     const phoneBook = document.getElementById('phonebook');
//     const btnLoad = document.getElementById('btnLoad');
//     const BASE_URL = 'http://localhost:3030/jsonstore/phonebook/'
//     //create
//     const personInput = document.getElementById('person');
//     const phoneInput = document.getElementById('phone');
//     const btnCreate = document.getElementById('btnCreate');

//     btnLoad.addEventListener('click',loadHandler);
//     btnCreate.addEventListener('click', createHandler);

//    async function loadHandler(){
//     try {
//         const res =  await fetch(BASE_URL);
//         const data = await res.json();
//         const values = Object.values(data);
//         phoneBook.innerHTML = '';
//         for (const {phone,person,_id} of values) {
//          const li = document.createElement('li');
//          const button = document.createElement('button');
//          button.textContent = 'Delete';
//          li.innerHTML = `${person}: ${phone}`;
//          button.id = _id;
//          button.addEventListener('click', deleteHandler)
//          li.appendChild(button);
//          phoneBook.appendChild(li);
//         }
//     } catch (error) {
//         console.error(error);
//     }
// }

//    function createHandler(){
//         const person = personInput.value;
//         const phone = phoneInput.value;
//         const httpHeaders = {
//             method: 'POST',
//             body: JSON.stringify({phone,person})
//         }
//         fetch(BASE_URL,httpHeaders)
//         .then((res)=> res.json())
//         .then(()=>{
//         loadHandler();
//         personInput.value= '';
//         phoneInput.value = '';
//         })
//         .catch((err)=>{
//             console.error(err);
//         })

//       }
    
//       async function deleteHandler(){
//         const id = this.id;
//         const httpHeader = {
//             method: 'DELETE'
//         }
//       const resDelete =  fetch(BASE_URL + id,httpHeader)
//         .then((res)=> res.json())
//         .then(()=>{
//             loadHandler();
//         })
//         .catch((err)=>{
//             console.error(err);
//         })
//       }
//     }
// attachEvents();
function attachEvents() {
    //get
    const phoneBook = document.getElementById('phonebook');
    const btnLoad = document.getElementById('btnLoad');
    const BASE_URL = 'http://localhost:3030/jsonstore/phonebook/'
    //create
    const personInput = document.getElementById('person');
    const phoneInput = document.getElementById('phone');
    const btnCreate = document.getElementById('btnCreate');

    btnLoad.addEventListener('click',loadHandler);
    btnCreate.addEventListener('click', createHandler);

   async function loadHandler(){
      const res =  await fetch(BASE_URL);
      const data = await res.json();
      const values = Object.values(data);
      phoneBook.innerHTML = '';
      for (const {phone,person,_id} of values) {
       const li = document.createElement('li');
       const button = document.createElement('button');
       li.textContent = `${person}: ${phone}`;
       button.textContent = 'Delete';
       button.id = _id;
       button.addEventListener('click', deleteHandler)
       li.appendChild(button);
       phoneBook.appendChild(li);
           
          }
      }

  async function createHandler(){
        let person = personInput.value;
        let phone = phoneInput.value;
        const httpHeaders = {
            method: 'POST',
            body: JSON.stringify({phone,person})
        }
        try{
            const res = await fetch(BASE_URL,httpHeaders)
            const data = await res.json();
            loadHandler();
            personInput.value= '';
            phoneInput.value = '';
          
        }catch(e){
            console.log(err);

        }
    //     fetch(BASE_URL,httpHeaders)
    //     .then((res)=> res.json())
    //     .then(()=>{
    //     loadHandler();
    //     personInput.value= '';
    //     phoneInput.value = '';
    //     })
    //     .catch((err)=>{
    //         console.log(err);
    //     })
        
      }
     
      async function deleteHandler(){
        const id = this.id;
        const httpHeader = {
            method: 'DELETE'
        }
        try{
            const resDelete = await fetch(BASE_URL + id,httpHeader)
            const dataDelete = await resDelete.json();
            loadHandler();
          
        }catch(e){
            console.log(err);

        }
     
      }
      }


attachEvents();