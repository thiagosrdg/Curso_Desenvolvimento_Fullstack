package com.example.shop;

public class Bicicleta implements IMeioTransporte {
    private int velocidade = 0;
    private static final int VELOCIDADE_MAXIMA = 40;

    @Override
    public void acelerar() {
        if (velocidade + 5 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida");
        }
        velocidade += 5;
        System.out.println("Bicicleta acelerando para " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        velocidade = Math.max(0, velocidade - 5);
        System.out.println("Bicicleta freando para " + velocidade + " km/h");
    }

    @Override
    public int getVelocidadeAtual(){ return velocidade; }
}
