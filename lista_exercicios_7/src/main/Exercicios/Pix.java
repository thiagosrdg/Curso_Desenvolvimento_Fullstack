package com.example.shop;


public class Pix extends FormaPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    protected void validarPagamento() {
        if (chave == null || chave.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave PIX inválida");
        }
    }
}
