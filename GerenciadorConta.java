package banco_negocio;

import banco_acesso.ContaDAO;

public class GerenciadorConta {
    private ContaDAO contaDAO;

    public GerenciadorConta() {
        this.contaDAO = new ContaDAO();
    }

    public String cadastrarConta(String numero, double saldo) {
        return contaDAO.cadastrarConta(numero, saldo);
    }

    public String alterarSaldo(String numero, double saldo) {
        return contaDAO.alterarSaldo(numero, saldo);
    }
}