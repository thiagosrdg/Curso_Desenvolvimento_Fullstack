package com.example.shop;

import java.math.BigDecimal;
public class PacStrategy implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.valueOf(10).add(BigDecimal.valueOf(pedido.getItens().size()));
    }
}
