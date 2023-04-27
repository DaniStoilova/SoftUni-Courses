function solve() {
    const BASE_URL = 'http://localhost:3030/jsonstore/bus/schedule/'
    let nextStopId = 'depot';
    let stopName = null;
    const busContainer = document.querySelector('#info > span');
    const departBtn = document.getElementById('depart');
    const arriveBtn = document.getElementById('arrive');
    function depart() {
        arriveBtn.disabled = false;
        departBtn.disabled = true;
        fetch(`${BASE_URL}${nextStopId}`)
        .then((res)=> res.json())
        .then((data)=>{
            const {name , next} = data;
            busContainer.textContent = `Next stop ${name}`;
            nextStopId = next;
            stopName = name;


        })
        .catch(()=>{
        busContainer.textContent = 'Error';
        arriveBtn.disabled = true;
        departBtn.disabled = true;
        busContainer.textContent = `Arriving at ${stopName}`;

    })

    }

    async function arrive() {
        arriveBtn.disabled = true;
        departBtn.disabled = false;

    }

    return {
        depart,
        arrive
    };
}

let result = solve();