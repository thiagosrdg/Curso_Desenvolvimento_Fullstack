package com.example.shop;


public class Boleto extends FormaPagamento {
    private String codigo;

    public Boleto(String codigo) {
        this.codigo = codigo;
    }

    @Override
    protected void validarPagamento() {
        if (!codigo.matches("\\d{47}")) {
            throw new IllegalArgumentException("Código de boleto inválido");
        }
    }
}
