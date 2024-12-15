package banco_apresentacao;

import banco_negocio.GerenciadorConta;

public class Main {
    public static void main(String[] args) {
        GerenciadorConta gerenciador = new GerenciadorConta();
        String mensagem = gerenciador.cadastrarConta("12345", 500.0);
        System.out.println(mensagem);
    }
}