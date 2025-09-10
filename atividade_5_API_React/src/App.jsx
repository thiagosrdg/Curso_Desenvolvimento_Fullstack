import React from "react";
import { BrowserRouter, Link } from "react-router-dom";
import RoutesConfig from "./routes";

const styles = {
  header: {
    padding: "1.5rem 2rem",
    background: "linear-gradient(135deg, #1a1a2e 0%, #16213e 100%)",
    color: "#fff",
    boxShadow: "0 2px 8px rgba(0,0,0,0.15)",
    position: "sticky",
    top: 0,
    zIndex: 1000,
  },
  container: {
    maxWidth: "1200px",
    margin: "0 auto",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
  title: {
    margin: 0,
    fontSize: "2rem",
    fontWeight: 600,
    display: "flex",
    alignItems: "center",
    gap: "0.5rem",
    color: "#fff",
    textShadow: "2px 2px 4px rgba(0,0,0,0.2)",
  },
  nav: {
    display: "flex",
    gap: "2rem",
  },
  link: {
    color: "#fff",
    textDecoration: "none",
    fontSize: "1.1rem",
    padding: "0.5rem 1rem",
    borderRadius: "25px",
    transition: "all 0.3s ease",
    "&:hover": {
      backgroundColor: "rgba(255,255,255,0.1)",
      transform: "translateY(-2px)",
    },
  },
  main: {
    padding: "2rem",
    background: "#f8f9fa",
    minHeight: "calc(100vh - 80px)",
  },
};

export default function App() {
  return (
    <BrowserRouter>
      <header style={styles.header}>
        <div style={styles.container}>
          <h1 style={styles.title}>
            <span style={{ fontSize: "2.2rem" }}>🎬</span>
            Buscador de filmes
          </h1>
          <nav style={styles.nav}>
            <Link
              to="/"
              style={styles.link}
              onMouseOver={(e) =>
                (e.target.style.backgroundColor = "rgba(255,255,255,0.1)")
              }
              onMouseOut={(e) =>
                (e.target.style.backgroundColor = "transparent")
              }
            >
              Buscar
            </Link>
            <Link
              to="/favorites"
              style={styles.link}
              onMouseOver={(e) =>
                (e.target.style.backgroundColor = "rgba(255,255,255,0.1)")
              }
              onMouseOut={(e) =>
                (e.target.style.backgroundColor = "transparent")
              }
            >
              Favoritos
            </Link>
          </nav>
        </div>
      </header>
      <main style={styles.main}>
        <div style={styles.container}>
          <RoutesConfig />
        </div>
      </main>
    </BrowserRouter>
  );
}
