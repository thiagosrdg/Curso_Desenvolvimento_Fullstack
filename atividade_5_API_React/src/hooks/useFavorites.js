import { useState, useEffect } from "react";

export default function useFavorites() {
  const [favorites, setFavorites] = useState(() => {
    // Tenta carregar do localStorage na inicialização do hook
    const stored = localStorage.getItem("favorites");
    return stored ? JSON.parse(stored) : [];
  });

  useEffect(() => {
    // Atualiza o localStorage toda vez que favorites mudar
    localStorage.setItem("favorites", JSON.stringify(favorites));
  }, [favorites]);

  const toggleFavorite = (movie) => {
    setFavorites((currentFavs) => {
      // Se já tem, remove; senão adiciona
      const exists = currentFavs.some((fav) => fav.imdbID === movie.imdbID);
      if (exists) {
        return currentFavs.filter((fav) => fav.imdbID !== movie.imdbID);
      } else {
        return [...currentFavs, movie];
      }
    });
  };

  return { favorites, toggleFavorite };
}
