function getInfo() {
 const stopIdInput = document.getElementById('stopId');
 const stopName = document.getElementById('stopName');
 const busContainer = document.getElementById('buses');
 const Base_URL = 'http://localhost:3030/jsonstore/bus/businfo/';
 const stopId = stopIdInput.value;

 stopName.textContent = '';
 buses.innerHTML = '';
// fetch(`${Base_URL}${stopId}`)
fetch(Base_URL + stopId)
    .then((res)=> res.json())
    .then((data)=>{
        const { name , buses } = data;
        stopName.textContent = name;
        for (const bussId in buses) {
            const li = document.createElement('li');
            li.textContent = `Bus ${bussId} arrives in ${buses[bussId]} minutes`;
            busContainer.appendChild(li);
                
            }
        })
    .catch(()=>{
        stopName.textContent = 'Error';

    })

}