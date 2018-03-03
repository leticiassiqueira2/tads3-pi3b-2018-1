package br.senac.tads.fantasticfour.gerenciamentoprodutos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

public class GerenciadorProdutos{
    
    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendabd", "root", ""); //TROCAR PARA O DRIVER DO NOSSO BANCO
        return conn;
    }

        
    public void incluir() throws ClassNotFoundException, SQLException {
        
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO PRODUTOBD.PRODUTO (nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro) VALUES (?,?, ?, ?, ?, ?)")) {
            stmt.setString(1, "Chocolate"); //nome
            stmt.setString(2, "Ao leite"); //descrição
            stmt.setDouble(3, 5); // preço compra
            stmt.setDouble(4, 8); // preço venda
            stmt.setInt(5, 10); // quantidade
            GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            stmt.setDate(6, new java.sql.Date(cal.getTimeInMillis()));
            
            int status = stmt.executeUpdate();
            System.out.println("Status: " + status);
        }
    }

    public static void main(String[] args) {
        GerenciadorProdutos gerprod = new GerenciadorProdutos();

        try {
            gerprod.incluir();
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}

