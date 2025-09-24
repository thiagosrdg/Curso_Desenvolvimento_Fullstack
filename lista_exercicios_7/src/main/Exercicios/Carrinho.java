package com.example.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Carrinho {
    private final List<ItemCarrinho> itens;
    private final Optional<Integer> cupomDesconto;

    public Carrinho(List<ItemCarrinho> itens, Optional<Integer> cupomDesconto) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.cupomDesconto = cupomDesconto;
    }

    public Carrinho adicionar(ItemCarrinho item) {
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        novosItens.add(item);
        return new Carrinho(novosItens, cupomDesconto);
    }

    public Carrinho aplicarCupom(int desconto) {
        if (desconto < 0 || desconto > 30) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 30%");
        }
        return new Carrinho(itens, Optional.of(desconto));
    }

    public BigDecimal total() {
        BigDecimal subtotal = itens.stream()
                .map(ItemCarrinho::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        return cupomDesconto.map(desconto -> {
            BigDecimal fator = BigDecimal.ONE.subtract(
                BigDecimal.valueOf(desconto).divide(BigDecimal.valueOf(100)));
            return subtotal.multiply(fator);
        }).orElse(subtotal).setScale(2, RoundingMode.HALF_EVEN);
    }
}
