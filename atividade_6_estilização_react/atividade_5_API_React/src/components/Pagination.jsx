import React from "react";

export default function Pagination({ currentPage, totalPages, onPageChange }) {
  return (
    <div>
      <button disabled={currentPage === 1} onClick={() => onPageChange(currentPage - 1)}>
        Anterior
      </button>
      <span> Página {currentPage} de {totalPages} </span>
      <button disabled={currentPage === totalPages} onClick={() => onPageChange(currentPage + 1)}>
        Próxima
      </button>
    </div>
  );
}
