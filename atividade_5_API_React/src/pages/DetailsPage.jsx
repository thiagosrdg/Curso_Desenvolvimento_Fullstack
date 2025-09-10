import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Loader from "../components/Loader";
import ErrorMessage from "../components/ErrorMessage";
import { getMovieDetails } from "../services/api";
import useFavorites from "../hooks/useFavorites";

export default function DetailsPage() {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const { favorites, toggleFavorite } = useFavorites();

  useEffect(() => {
    getMovieDetails(id)
      .then((data) => {
        if (data.Response === "True") setMovie(data);
        else setError(data.Error);
      })
      .catch(() => setError("Erro ao carregar detalhes."))
      .finally(() => setLoading(false));
  }, [id]);

  if (loading) return <Loader />;
  if (error) return <ErrorMessage message={error} />;

  return (
    <div>
      <h2>{movie.Title} ({movie.Year})</h2>
      <img src={movie.Poster} alt={movie.Title} />
      <p><strong>Diretor:</strong> {movie.Director}</p>
      <p><strong>Elenco:</strong> {movie.Actors}</p>
      <p><strong>Sinopse:</strong> {movie.Plot}</p>
      <p><strong>Avaliação:</strong> {movie.imdbRating}</p>
      <button onClick={() => toggleFavorite(movie)}>
        {favorites.some(f => f.imdbID === movie.imdbID) ? "Remover Favorito" : "Adicionar Favorito"}
      </button>
    </div>
  );
}
