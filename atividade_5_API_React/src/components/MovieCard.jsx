import React from "react";
import { Link } from "react-router-dom";

export default function MovieCard({ movie, onToggleFavorite, isFavorite }) {
  return (
    <div style={{ border: "1px solid #ccc", padding: "0.5rem", margin: "0.5rem" }}>
      <img src={movie.Poster} alt={movie.Title} width="150" />
      <h3>{movie.Title} ({movie.Year})</h3>
      <Link to={`/details/${movie.imdbID}`}>Ver detalhes</Link>
      <button onClick={() => onToggleFavorite(movie)}>
        {isFavorite ? "Remover Favorito" : "Adicionar Favorito"}
      </button>
    </div>
  );
}
