package br.senac.tads.fantasticfour.gerenciamentoprodutos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorProdutos{
    
    Produto produto = new Produto();
        
        
    public static void main(String[] args) {
       
        GerenciadorProdutos gerprod = new GerenciadorProdutos();
                  
        gerprod.Menu();
        
        try {
            gerprod.incluir();
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
   
    public void Menu(){
        
        Scanner leitor = new Scanner(System.in);
        
        int menu;
        
        System.out.println("Digite 0 - Sair | 1 - Incluir | 2 - Listar");
        menu = leitor.nextInt();
        
        switch(menu){
            case 0:
                System.exit(menu);
            case 1:
                Inserir();
        }
    }
    
    public void Inserir(){
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o nome do produto:");
        String nome = leitor.next();
        produto.setNome(nome);
        
        System.out.println("Digite a descrição do produto:");
        String descricao = leitor.next();
        produto.SetDescricao(descricao);
        
        System.out.println("Digite o preço de compra:");
        double preCompra = leitor.nextDouble();
        produto.setPreCompra(preCompra);
        
        System.out.println("Digite o preço de venda:");
        double preVenda = leitor.nextDouble();
        produto.setPreVenda(preVenda);
        
        System.out.println("Digite a quantidade:");
        int quantidade = leitor.nextInt();
        produto.setQuantidade(quantidade);
        
        System.out.println("Digite a data:");
        try {
            String data = leitor.next();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(data);
            produto.setData(dt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
            
       
    }
    
    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendabd", "root", ""); //TROCAR PARA O DRIVER DO NOSSO BANCO
        return conn;
    }

        
    public void incluir() throws ClassNotFoundException, SQLException {
        
        
        try (Connection conn = obterConexao();
        
                Scanner leitor = new Scanner(System.in);
                
           
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO PRODUTOBD.PRODUTO (nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro) VALUES (?,?, ?, ?, ?, ?)")) {
            stmt.setString(1, produto.getNome()); 
            stmt.setString(2, produto.getDescricao()); 
            stmt.setDouble(3, produto.getPreCompra()); 
            stmt.setDouble(4, produto.getPreVenda()); 
            stmt.setInt(5, produto.getQuantidade()); 
            Timestamp t = new Timestamp(produto.getData().getTime());
            stmt.setTimestamp(3, t);
            
            int status = stmt.executeUpdate();
            System.out.println("Status: " + status);
        }
    }

}

