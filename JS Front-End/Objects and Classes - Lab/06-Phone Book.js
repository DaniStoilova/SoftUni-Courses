function phone(data){
    let phoneBook = {};
    for (const inputLine of data) {
        let [name,phoneNumber] = inputLine.split(' ');
        phoneBook[name] = phoneNumber;
    }

    for (const key in phoneBook) {
        console.log(`${key} -> ${phoneBook[key]}`)
        
    }

}
phone(['Tim 0834212554',
'Peter 0877547887',
'Bill 0896543112',
'Tim 0876566344']
);
phone(['George 0552554',
'Peter 087587',
'George 0453112',
'Bill 0845344']
);