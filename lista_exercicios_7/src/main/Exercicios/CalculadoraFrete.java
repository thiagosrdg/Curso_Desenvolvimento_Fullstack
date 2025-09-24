package com.example.shop;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculadoraFrete {
    BigDecimal calcular(Pedido pedido);
}
