function attachEvents() {
    const locationInput = document.getElementById('location');
    const submitBtn = document.getElementById('submit') ;
    const BASE_URL = 'http://localhost:3030/jsonstore/forecaster/locations'
    const forecastContainer = document.getElementById('forecast');
    const currentContainer = document.getElementById('current'); 
    const upcomingContainer = document.getElementById('upcoming');

    submitBtn.addEventListener('click', getWeatherHandler);

    function getSymbol(condition) {
        switch (condition) {
            case'Sunny':
                return '&#x2600;';
            case'Partly sunny':
                return '&#x26C5;';
            case'Overcast':
                return '&#x2601;';
            case'Rain':
                return '&#x2614;';
        }
    }
    

  async function getWeatherHandler(){
        const res = await fetch(BASE_URL);
        const data = await res.json();

        let currentCode = data.find((element) => element.name === locationInput.value);
      
        //today
        let today = 'http://localhost:3030/jsonstore/forecaster/today/'
       
        const resNew = await fetch(today + currentCode.code);
        const newData = await resNew.json();

               
         forecastContainer.style.display = 'block';

        let div = createHTMLEl('div','',currentContainer,'forecasts');
        createHTMLEl('span',getSymbol(newData.forecast.condition),div,'condition symbol');
        let span = createHTMLEl('span','',div,'condition');
        createHTMLEl('span',newData.name,span,'forecast-data');
        createHTMLEl('span',`${newData.forecast.low}&#176/${newData.forecast.high}&#176`,span,'forecast-data');
        createHTMLEl('span',newData.forecast.condition,span,'forecast-data');

        //upcoming
        let upcoming = 'http://localhost:3030/jsonstore/forecaster/upcoming/'

        const resUpcoming = await fetch(upcoming + currentCode.code);
        const dataUpcoming = await resUpcoming.json();

            Array.from(dataUpcoming.forecast).forEach((element)=>{
            const divContainer = createHTMLEl('div','',upcomingContainer,'forecast-info');
            const spanContainer = createHTMLEl('span','',divContainer,'upcoming');
            createHTMLEl('span',getSymbol(element.condition),spanContainer,'symbol');
            createHTMLEl('span',`${element.low}&#176/${element.high}&#176`,spanContainer,'forecast-data');
            createHTMLEl('span',element.condition,spanContainer,'forecast-data');
            });
            }
            
            function createHTMLEl(typeOfEl, content, parentEl, classToAdd) {
                const element = document.createElement(typeOfEl);
                if (content && !content.includes("#")) {
                  element.textContent = content;
                }
                if (content && content.includes("#")) {
                  element.innerHTML = content;
                }
                if(parentEl){
                  parentEl.appendChild(element);
                }
                if(classToAdd){
                  element.className = classToAdd;
                }
                return element;
              }
            }
            
attachEvents();