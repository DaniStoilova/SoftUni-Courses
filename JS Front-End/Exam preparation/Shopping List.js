function solve(input){
    let arr = input.shift().split('!');
    console.log(arr);
    

    for (const line of input) {
        if(line === 'Go Shopping!') {
            break;
        }

        let data = line.split(' ');
        let command = data[0];
        let commands = [...data.slice(1)];
        
        if (command === 'Urgent'){
            let [item] = commands;
            if (!arr.includes(item)){
                arr.unshift(item);
            }

        }else if(command === 'Unnecessary'){
            let [item] = commands;
            if (arr.includes(item)){
                let index = arr.indexOf(item);
                arr.splice(index,1);
            }
        }else if(command === 'Correct'){
            let [item, newItem] = commands;
            if (arr.includes(item)){
             let index = arr.indexOf(item);
            arr[index] = newItem;
            }
        }else if(command === 'Rearrange'){
            let [item] = commands;
            if (arr.includes(item)){
                let index = arr.indexOf(item);
                arr.splice(index,1);
                arr.push(item);
            }
        }

    }

    console.log(arr.join(', '));



}
solve((["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Urgent Tomatoes",
"Go Shopping!"])
)
solve((["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"])
)
solve((["Tomatoes!Potatoes!Bread",
"Unnecessary Milk",
"Correct Tomatoes Onion",
 "Urgent Milk",
 "Unnecessary Milk",
"Go Shopping!"])
)
