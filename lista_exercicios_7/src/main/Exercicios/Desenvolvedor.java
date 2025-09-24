package com.example.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String id, String nome, BigDecimal salario) {
        super(id, nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_EVEN);
    }
}
