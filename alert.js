let numberOfFilms;

function start() {
  numberOfFilms = +prompt('Сколько фильмов Вы уже посмотрели?', '');

  while(numberOfFilms == '' || numberOfFilms == null || isNaN(numberOfFilms)){
    numberOfFilms = +prompt('Сколько фильмов Вы уже посмотрели?', '');
  }
}

start();

let personalMovieDB = {
  count: numberOfFilms,
  movies: {},
  actors: {},
  genres: [],
  privat: true,
};

console.log(personalMovieDB);

function showMyDB(hidden) {
  if (!hidden) {
    console.log(personalMovieDB);
  }
}

function rememberMyFilms(){
  for (let i=0; i<2; i++) {
    let lastMovie = prompt('Один из последних просмотренных фильмов?', ''),
        scoreMovie = prompt('На сколько оцените его?', '');
   
   if (lastMovie != null && scoreMovie != null && lastMovie != '' && scoreMovie != '' && lastMovie.length < 50){
     personalMovieDB.movies[lastMovie]= scoreMovie;
   } else{
     i--;
   }
   }
}

rememberMyFilms();

function defectPersonalLevel(){
  if (personalMovieDB.count < 10){
    console.log('Просмотрено довольно мало фильмов');
  } else if (personalMovieDB.count > 10 && personalMovieDB.count < 30){
    console.log('Вы классический зритель');
  } else if(personalMovieDB.count > 30){
    console.log('Вы киноман');
  } else console.log('Произошла ошибка');
}

defectPersonalLevel();


function writeYourGenres(){
  for (let i = 0; i < 3; i++){
      personalMovieDB.genres[i] = prompt(`Ваш любимый жанр под номером ${i+1}`, '');;
    }
  }

writeYourGenres();

showMyDB(personalMovieDB.privat);