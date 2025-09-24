package com.example.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private String cep;
    private List<ItemCarrinho> itens = new ArrayList<>();
    private CalculadoraFrete calculadoraFrete;

    public Pedido(String cep) {
        this.cep = cep;
    }

    public void addItem(ItemCarrinho item) {
        itens.add(item);
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadora) {
        this.calculadoraFrete = calculadora;
    }

    public BigDecimal calcularFrete() {
        return calculadoraFrete.calcular(this);
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public String getCep() {
        return cep;
    }
}
