package com.example.shop;

import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> {
    private final Map<ID, T> dados = new HashMap<>();

    public void salvar(T entidade) {
        dados.put(entidade.getId(), entidade);
    }

    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(dados.get(id));
    }

    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(dados.values()));
    }

    public void remover(ID id) {
        if (!dados.containsKey(id)) {
            throw new IllegalArgumentException("Entidade não encontrada: " + id);
        }
        dados.remove(id);
    }
}
