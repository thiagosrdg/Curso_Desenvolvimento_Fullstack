package com.example.shop;

public class Trem implements IMeioTransporte {
    private int velocidade = 0;
    private static final int VELOCIDADE_MAXIMA = 300;

    @Override
    public void acelerar() {
        if (velocidade + 30 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Velocidade máxima atingida");
        }
        velocidade += 30;
        System.out.println("Trem acelerando para " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        velocidade = Math.max(0, velocidade - 30);
        System.out.println("Trem freando para " + velocidade + " km/h");
    }

    @Override
    public int getVelocidadeAtual(){ return velocidade; }
}
