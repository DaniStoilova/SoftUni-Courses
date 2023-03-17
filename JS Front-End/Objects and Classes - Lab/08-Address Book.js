function solve(input){
    let addressBook = {};

    for (const line of input) {
        let [name,address] = line.split(':');
       addressBook[name] = address;
    }

    let arr = [];

    for (const key in addressBook) {
        arr.push(key);
        
    }

    arr.sort((a,b) => a.localeCompare(b)).forEach (key => console.log(`${key} -> ${addressBook[key]}`))
    
}
solve(['Tim:Doe Crossing',
'Bill:Nelson Place',
'Peter:Carlyle Ave',
'Bill:Ornery Rd']
);
solve(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd']
);
