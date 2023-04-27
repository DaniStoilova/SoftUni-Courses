function solve(arr){
    let n = Number(arr.shift());

    let info = {};

    for (let index = 0; index < n; index++) {
        let [piece, composer, key] = arr.shift().split('|');
        info [piece] = { composer, key}
    }


        for (const inputLine of arr) {
            if (inputLine === 'Stop'){
                break;
            }
            let line = inputLine.split('|');
            let command = line[0];
            let commands = [...line.slice(1)]
            if (command === 'Add'){
                let [ piece, composer, key ] = commands;
    
                if (!info.hasOwnProperty(piece)) {
                    info[piece] = { composer, key };
                    console.log(`${piece} by ${composer} in ${key} added to the collection!`);
                } else {
                    console.log(`${piece} is already in the collection!`);
                }
    
            }else if(command === 'Remove'){
                let [ piece ] = commands;
                
    
                if (info.hasOwnProperty(piece)){
                    delete info[piece];
                    console.log(`Successfully removed ${piece}!`)
                    
                }else{
                    console.log(`Invalid operation! ${piece} does not exist in the collection.`)
    
                }
               
            }else if(command === 'ChangeKey'){
                
                let [ piece, newKey ] = commands;
    
                if (!info.hasOwnProperty(piece)) {
                    console.log(`Invalid operation! ${piece} does not exist in the collection.`);
                } else {
                    info[piece].key = newKey;
                    console.log(`Changed the key of ${piece} to ${newKey}!`);
                }
            }
    
        }   

    let composers = Object.entries(info);

    for (const [ piece, info ] of composers) {
        console.log(`${piece} -> Composer: ${info.composer}, Key: ${info.key}`);
    }



}
solve([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'  
  ]
  )