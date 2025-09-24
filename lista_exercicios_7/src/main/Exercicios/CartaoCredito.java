package com.example.shop;


public class CartaoCredito extends FormaPagamento {
    private String numero;
    @SuppressWarnings("unused")
    private String titular;
    @SuppressWarnings("unused")
    private String validade;

    public CartaoCredito(String numero, String titular, String validade) {
        this.numero = numero;
        this.titular = titular;
        this.validade = validade;
    }

    @Override
    protected void validarPagamento() {
        if (!numero.matches("\\d{4}\\s?\\d{4}\\s?\\d{4}\\s?\\d{4}")) {
            throw new IllegalArgumentException("Número de cartão inválido");
        }
    }
}
