const numberOfFilms = +prompt('Сколько фильмов Вы уже посмотрели?', '');
let personalMovieDB = {
  count: numberOfFilms,
  movies: {},
  actors: {},
  genres: [],
  privat: false
};
let lastMovie = prompt('Один из последних просмотренных фильмов?'),
    scoreMovie = prompt('На сколько оцените его?'),
    lastMovie2 = prompt('Один из последних просмотренных фильмов?'),
    scoreMovie2 = prompt('На сколько оцените его?');

personalMovieDB.movies[lastMovie]=scoreMovie;
personalMovieDB.movies[lastMovie2]=scoreMovie2;

console.log(personalMovieDB);