function solve(input){

    let heroes = [];

    for (const line of input) {
        let [heroName,level,item] = line.split(' / ');
        level = Number(level);
        heroes.push({heroName,level,item});
    }

    let sorted = heroes.sort((a,b) => a.level - b.level);

    for (const {heroName,level,item} of sorted) {
        console.log(`Hero: ${heroName}`);
        console.log(`level => ${level}`);
        console.log(`items => ${item}`);
    }
}
solve([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]
    );
solve([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]
    );