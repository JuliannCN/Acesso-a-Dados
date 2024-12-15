package banco_acesso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {
    private static final String URL = "jdbc:postgresql://localhost/banco";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public String cadastrarConta(String numero, double saldo) {
        String sql = "INSERT INTO public.conta (numero, saldo) VALUES (?, ?)";

        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            pstmt.setDouble(2, saldo);
            pstmt.executeUpdate();
            return "Conta cadastrada com sucesso!";
        } catch (SQLException e) {
            return "Erro ao cadastrar conta: " + e.getMessage();
        }
    }

    public String alterarSaldo(String numero, double saldo) {
        String sql = "UPDATE public.conta SET saldo = ? WHERE numero = ?";

        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, saldo);
            pstmt.setString(2, numero);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0 ? "Saldo alterado com sucesso!" : "Conta não encontrada.";
        } catch (SQLException e) {
            return "Erro ao alterar saldo: " + e.getMessage();
        }
    }
}