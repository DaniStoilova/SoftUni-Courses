function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/messenger';
    const submit = document.getElementById('submit');
    const refresh = document.getElementById('refresh');
    const messages = document.getElementById('messages');
    const authors = document.querySelector('#controls > div:nth-child(1) > input[type=text]');
    const msg = document.querySelector('#controls > div:nth-child(2) > input[type=text]');

    submit.addEventListener('click', createHandler);
    refresh.addEventListener('click', refreshHandler);

    async function createHandler() {
        let author = authors.value;
        let content = msg.value;
        const httpHeaders = {
            method: 'POST',
            body: JSON.stringify({author,content})
        }
        const res = await fetch(BASE_URL,httpHeaders);
        const result = await res.json();

        authors.value = '';
        msg.value = '';
      
    }
    async function refreshHandler(){
        const res = await fetch(BASE_URL);
        const data = await res.json();

        let values = Object.values(data);

        messages.value = values.map(m => `${m.author}: ${m.content}`).join(`\n`);

    }
 

}  
attachEvents();




