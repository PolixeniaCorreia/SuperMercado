package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mercado.conection.ConnectionFactory;
import model.Pessoa;

public class PessoaDAO {
	
		public void inserir(Pessoa p) {
			PreparedStatement ps = null;
			String sql = "insert into produto (nome,cpf,telefone) values(?,?,?)";
			try(Connection conn = new ConnectionFactory().getConnection()) {
				ps = conn.prepareStatement(sql);
				ps.setString(1, p.getNome());
				ps.setString(2, p.getCpf());
				ps.setInt(3, p.getTelefone());
				ps.execute();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error ao inserir uma Pessoa no banco!");
			}
			
		}

		public void deletar(Pessoa p) {
			PreparedStatement ps = null;
			String sql = "delete from produto where cpf = ?";
			try(Connection conn = new ConnectionFactory().getConnection()){
				ps = conn.prepareStatement(sql);
				ps.setString(1, p.getCpf());
				ps.execute();
				ps.close();
			}catch (SQLException e) {
				System.out.println("Error ao deletar uma Pessoa");
				System.out.println(e.getMessage());
			}
			
		}
		
		public ArrayList<Pessoa> listar(){
			ArrayList<Pessoa> pessoa = new ArrayList<>();
			String sql = "select * from produto";
			PreparedStatement ps = null;
			try(Connection conn = new ConnectionFactory().getConnection()){
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Pessoa p = new Pessoa();
					p.setNome(rs.getString("nome"));
					p.setCpf(rs.getString("CPF"));
					p.setTelefone(rs.getInt("Telefone"));
					pessoa.add(p);
				}
				ps.close();
			}catch(SQLException e) {
				System.out.println("Error ao listar Pessoas");
				System.out.println(e.getMessage());
			}
			return pessoa;
		}

		public void alterar(Pessoa p, String cpf) {
			PreparedStatement ps = null;
			String sql = "update pessoa set nome=?, cpf=?, telefone=? where cpf=?";
			try(Connection conn = new ConnectionFactory().getConnection()){
				ps = conn.prepareStatement(sql);
				ps.setString(1, p.getNome());
				ps.setString(2, p.getCpf());
				ps.setInt(3, p.getTelefone());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error ao alterar a tabela Pessoas!");
				System.out.println(e.getMessage());
			}
		}

	

}
