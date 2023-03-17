  function solve(input) {
      let movies = {};
      for (let i = 0; i < input.length; i++) {
        let command = input[i];
          if (command.includes('addMovie')) {
              let movieName = command.replace('addMovie ','');
              if (!movies.hasOwnProperty(movieName)) {
                  movies[movieName] = { name: movieName };
              }
          } else if (command.includes('onDate')) {
              let [movieName, date] = command.split(' onDate ');
              if (movies.hasOwnProperty(movieName)) {
                  movies[movieName] ['date'] = date;
              }
          } else if (command.includes('directedBy')) {
              let [movieName, director] = command.split(' directedBy ');
              if (movies.hasOwnProperty(movieName)) {
                  movies[movieName]['director'] = director;
              }
          }
      }
      for (const movie in movies) {
          let m = movies[movie];
          if (m.hasOwnProperty('name') && m.hasOwnProperty('date') && m.hasOwnProperty('director')) {
              console.log(JSON.stringify(m));
          }
      }
  }

solve([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]
    );
solve([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
    ]
    );
  