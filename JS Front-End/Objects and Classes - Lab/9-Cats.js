function solve (input){
    class Cat{
        constructor(name,age){
            this.name = name;
            this.age = age;
        }
        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }  

    }
    

    let arrCats = [];
    for (const line of input) {
       let [name, age] = line.split(' ');
       age = Number(age);
       arrCats.push(new Cat(name,age)); 
    }
    
    for (const cat of arrCats) {
        cat.meow();
    }

}
solve(['Mellow 2', 'Tom 5']);
solve(['Candy 1', 'Poppy 3', 'Nyx 2']);