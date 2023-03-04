function solve (number,road){
    let speed = 0;

switch(road){
    case 'motorway':
        speed = 130;
        if (number > 130){
            let speeding = number - 130;
        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speed} - ${status(speeding)}`)
        }else{
        console.log(`Driving ${number} km/h in a ${speed} zone`);
        }
    break;
    case 'interstate':
        speed = 90;
        if (number > 90){
            let speeding = number - 90;
        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speed} - ${status(speeding)}`)
        }else{
        console.log(`Driving ${number} km/h in a ${speed} zone`);
        }
    break;
    case 'city':
        speed = 50;
        if (number > 50){
            let speeding = number - 50;
        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speed} - ${status(speeding)}`)
        }else{
        console.log(`Driving ${number} km/h in a ${speed} zone`);
        }
    break;
    case 'residential':
        speed = 20;
        if (number > 20){
            let speeding = number - 20;
        console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speed} - ${status(speeding)}`)
        }else{
        console.log(`Driving ${number} km/h in a ${speed} zone`);
        }
    break;

    function status (speeding){
    if (speeding <= 20) {
        return 'speeding';
        } else if (speeding <= 40) {
        return 'excessive speeding';
        } else {
        return 'reckless driving';
        }

    }  
       
    }

}
solve(40, 'city');
solve(21, 'residential');
solve(120, 'interstate');