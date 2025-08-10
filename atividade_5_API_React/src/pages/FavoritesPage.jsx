import React from "react";
import MovieCard from "../components/MovieCard";
import useFavorites from "../hooks/useFavorites";

export default function FavoritesPage() {
  const { favorites, toggleFavorite } = useFavorites();

  return (
    <div>
      <h2>Meus Favoritos</h2>
      {favorites.length === 0 ? (
        <p>Você não possui filmes favoritos ainda.</p>
      ) : (
        <div style={{ display: "flex", flexWrap: "wrap" }}>
          {favorites.map((movie) => (
            <MovieCard
              key={movie.imdbID}
              movie={movie}
              onToggleFavorite={toggleFavorite}
              isFavorite={true}
            />
          ))}
        </div>
      )}
    </div>
  );
}
