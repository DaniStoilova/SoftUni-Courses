function solve(data){
    let scheduled = {};
    for (const inputLine of data) {
        let [dayOfWeek,name] = inputLine.split(' ');
        
        if (!scheduled.hasOwnProperty(dayOfWeek)){
            scheduled[dayOfWeek] = name;
            console.log(`Scheduled for ${dayOfWeek}`)
        }else{
            console.log(`Conflict on ${dayOfWeek}!`)
        }
    }

        for (const key in scheduled) {
            console.log(`${key} -> ${scheduled[key]}`)   
        }  
    }
//     solve(['Monday Peter',
//     'Wednesday Bill',
//     'Monday Tim',
//     'Friday Tim']
//    );
    solve(['Friday Bob',
    'Saturday Ted',
    'Monday Bill',
    'Monday John',
    'Wednesday George']
    );

