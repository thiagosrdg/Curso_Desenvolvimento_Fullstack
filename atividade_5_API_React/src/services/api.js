const API_KEY = import.meta.env.VITE_OMDB_API_KEY;
const BASE_URL = "https://www.omdbapi.com/";

export async function searchMovies(term, page = 1) {
  const res = await fetch(`${BASE_URL}?apikey=${API_KEY}&s=${term}&page=${page}`);
  return res.json();
}

export async function getMovieDetails(id) {
  const res = await fetch(`${BASE_URL}?apikey=${API_KEY}&i=${id}&plot=full`);
  return res.json();
}
