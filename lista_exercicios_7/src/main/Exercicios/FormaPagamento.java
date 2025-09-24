package com.example.shop;

import java.math.BigDecimal;

public abstract class FormaPagamento {
    protected abstract void validarPagamento();

    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Processando pagamento de " + valor + " via " + this.getClass().getSimpleName());
    }
}
