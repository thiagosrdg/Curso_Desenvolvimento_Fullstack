package com.example.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoComDesconto extends Produto {
    public ProdutoComDesconto(String id, String nome, BigDecimal preco, int quantidadeEmEstoque) {
        super(id, nome, preco, quantidadeEmEstoque);
    }

    /**
     * Aplica desconto percentual entre 0 e 50 (inclusive)
     */
    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 50%");
        }
        BigDecimal fator = BigDecimal.ONE.subtract(BigDecimal.valueOf(porcentagem).divide(BigDecimal.valueOf(100)));
        setPreco(getPreco().multiply(fator).setScale(2, RoundingMode.HALF_EVEN));
    }
}
