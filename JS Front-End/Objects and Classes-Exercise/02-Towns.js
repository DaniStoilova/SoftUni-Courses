function solve(input){
    let info = {};

    for (const inputLine of input) {
        let [town,latitude,longitude] = inputLine.split(' |');
       info[town] = [latitude, longitude];
    }
    for (const key in info) {
       console.log(`{ town: '${key}', latitude: '${Number(info[key][0]).toFixed(2)}', longitude: '${Number(info[key][1]).toFixed(2)}' }`)
    }

}
solve(['Sofia | 42.696552 | 23.32601',
'Beijing | 39.913818 | 116.363625']
);
solve(['Plovdiv | 136.45 | 812.575']);
