package com.example.shop;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- EXERCÍCIO 1/2: PRODUTOS ---");
        ProdutoComDesconto p = new ProdutoComDesconto("p1","Teclado", new BigDecimal("250.00"), 10);
        System.out.println("Antes: " + p);
        p.aplicarDesconto(10);
        System.out.println("Depois 10%: " + p);
        try {
            p.aplicarDesconto(60);
        } catch (Exception e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        try {
            p.setPreco(new BigDecimal("-5"));
        } catch (Exception e) {
            System.out.println("Erro esperado preco negativo: " + e.getMessage());
        }

        System.out.println("\n--- EXERCÍCIO 3: FUNCIONÁRIOS ---");
        List<Funcionario> funcs = new ArrayList<>();
        funcs.add(new Gerente("g1","Mariana", new BigDecimal("8000")));
        funcs.add(new Desenvolvedor("d1","Carlos", new BigDecimal("4000")));
        for (Funcionario f : funcs) {
            System.out.println(f.getNome() + " recebe bônus: " + f.calcularBonus());
        }

        System.out.println("\n--- EXERCÍCIO 4: MEIOS DE TRANSPORTE ---");
        List<IMeioTransporte> meios = Arrays.asList(new Carro(), new Bicicleta(), new Trem());
        for (IMeioTransporte m : meios) {
            try {
                m.acelerar();
                m.acelerar();
                m.frear();
            } catch (Exception e) {
                System.out.println("Operação transporte: " + e.getMessage());
            }
        }

        System.out.println("\n--- EXERCÍCIO 5: PAGAMENTOS ---");
        FormaPagamento cartao = new CartaoCredito("4111 1111 1111 1111","Fulano","12/30");
        FormaPagamento pix = new Pix("meu-email@exemplo.com");
        FormaPagamento boleto = new Boleto("00190500954014481606906809350314337370000000100"); // exemplo 47/44
        cartao.processarPagamento(new BigDecimal("150.00"));
        pix.processarPagamento(new BigDecimal("20.00"));
        boleto.processarPagamento(new BigDecimal("499.90"));

        System.out.println("\n--- EXERCÍCIO 6: CARRINHO IMUTÁVEL ---");
        Produto prod1 = new Produto("p2","Mouse", new BigDecimal("50.00"), 5);
        ItemCarrinho it1 = new ItemCarrinho(prod1, 2);
        Carrinho carr = new Carrinho(Collections.emptyList(), Optional.empty());
        carr = carr.adicionar(it1);
        System.out.println("Total carrinho: " + carr.total());
        carr = carr.aplicarCupom(15);
        System.out.println("Total com cupom 15%: " + carr.total());

        System.out.println("\n--- EXERCÍCIO 7: REPOSITÓRIO ---");
        InMemoryRepository<Produto,String> repo = new InMemoryRepository<>();
        repo.salvar(prod1);
        System.out.println("Listar produtos: " + repo.listarTodos());
        try {
            repo.remover("nao-existe");
        } catch (Exception e) {
            System.out.println("Remover esperado: " + e.getMessage());
        }

        System.out.println("\n--- EXERCÍCIO 8: FRETE STRATEGY ---");
        Pedido pedido = new Pedido("12345-678");
        pedido.addItem(it1);
        pedido.setCalculadoraFrete(new SedexStrategy());
        System.out.println("Frete sedex: " + pedido.calcularFrete());
        // trocar estratégia para promocional lambda (frete grátis acima de 100)
        pedido.setCalculadoraFrete(ped -> {
            java.math.BigDecimal subtotal = ped.getItens().stream().map(ItemCarrinho::getTotal)
                    .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
            if (subtotal.compareTo(new BigDecimal("100")) > 0) return java.math.BigDecimal.ZERO;
            return new BigDecimal("20.00");
        });
        System.out.println("Frete promocional (lambda): " + pedido.calcularFrete());
    }
}
