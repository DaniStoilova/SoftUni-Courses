function solve(arr,num){
    let newArr = [];
    for (let index = 0; index < arr.length; index += num) {
        let el = arr[index];
        newArr.push(el); 
    }
    return newArr;
}
console.log(solve(['5', 
'20', 
'31', 
'4', 
'20'], 
2
))
solve(['dsa',
'asd', 
'test', 
'tset'], 
2
)
solve(['1', 
'2',
'3', 
'4', 
'5'], 
6
)
