package com.example.shop;

public class Carro implements IMeioTransporte {
    private int velocidade = 0;
    private static final int VELOCIDADE_MAXIMA = 200;

    @Override
    public void acelerar() {
        if (velocidade + 20 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida");
        }
        velocidade += 20;
        System.out.println("Carro acelerando para " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        velocidade = Math.max(0, velocidade - 20);
        System.out.println("Carro freando para " + velocidade + " km/h");
    }

    @Override
    public int getVelocidadeAtual(){ return velocidade; }
}
