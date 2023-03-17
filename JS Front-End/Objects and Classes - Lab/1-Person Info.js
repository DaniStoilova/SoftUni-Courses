function info(firstName, lastName, age){
    age = Number(age);
    let person = {firstName, lastName, age};

    return person;
}
console.log(info("Peter", 
"Pan",
"20"
));
console.log(info("George", 
"Smith",
"18"
));