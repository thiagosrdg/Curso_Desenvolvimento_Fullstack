import React, { useState } from "react";

export default function SearchBar({ onSearch }) {
  const [term, setTerm] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (term.trim()) onSearch(term);
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "1rem" }}>
      <input
        type="text"
        value={term}
        onChange={(e) => setTerm(e.target.value)}
        placeholder="Digite o nome do filme..."
      />
      <button type="submit">Buscar</button>
    </form>
  );
}
