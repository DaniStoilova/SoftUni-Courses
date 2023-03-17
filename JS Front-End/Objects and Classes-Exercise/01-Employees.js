function solve(input){
    let employees = {};

    for (const inputLine of input) {
        let [name, length] = inputLine.split(',');
        employees[name] = name.length;
    }
    for (const key in employees) {
       console.log(`Name: ${key} -- Personal Number: ${Number(key.length)}`)
    }

}
solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
    );
    solve([
        'Samuel Jackson',
        'Will Smith',
        'Bruce Willis',
        'Tom Holland'
        ]
        );