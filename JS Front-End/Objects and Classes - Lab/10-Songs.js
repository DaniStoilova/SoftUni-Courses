 function solve(input){
 class Song{
    constructor(typeList, name, time){
        this.typeList = typeList;
        this.name = name;
        this.time = time;
        }
    }

    let songs = [];
    let numOfSong = input.shift();
    let typeSong = input.pop();

    for (let index = 0; index < numOfSong; index++) {

    let [typeList,name,time] = input[index].split('_');

    songs.push(new Song(typeList,name,time))
      
    }
    if (typeSong === 'all'){
        songs.forEach((song) => console.log(song.name));

    } else {
        let filtered = songs.filter((song) => song.typeList === typeSong);
        filtered.forEach((song) => console.log(song.name));
        
       }
}
    solve([3,
        'favourite_DownTown_3:14',
        'favourite_Kiss_4:16',
        'favourite_Smooth Criminal_4:01',
        'favourite']
        );
        solve([4,
            'favourite_DownTown_3:14',
            'listenLater_Andalouse_3:24',
            'favourite_In To The Night_3:58',
            'favourite_Live It Up_3:48',
            'listenLater']
            );
            solve([2,
                'like_Replay_3:15',
                'ban_Photoshop_3:48',
                'all']
                );
