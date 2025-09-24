package com.example.shop;

import java.math.BigDecimal;

public class SedexStrategy implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("35.00");
    }
}
