package com.example.shop;

import java.math.BigDecimal;

public abstract class Funcionario implements Identificavel<String> {
    protected String id;
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String id, String nome, BigDecimal salario) {
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salário deve ser positivo");
        }
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public abstract BigDecimal calcularBonus();
}
