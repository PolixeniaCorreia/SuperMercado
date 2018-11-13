package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mercado.conection.ConnectionFactory;
import model.Administrador;

public class AdministradorDAO {
	

	public void inserir(Administrador a) {
		PreparedStatement ps = null;
		String sql = "insert into administrador (login,senha) values(?,?)";
		try(Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCpf());
			ps.setInt(3, a.getTelefone());
			ps.setString(4, a.getLogin());
			ps.setInt(5, a.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir um Administrador no banco!");
		}
		
	}

	public void deletar(Administrador a) {
		PreparedStatement ps = null;
		String sql = "delete from vendedor where cpf = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getCpf());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar uma Administrador");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Administrador> listar(){
		ArrayList<Administrador> administrador = new ArrayList<>();
		String sql = "select * from vendedor";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Administrador a = new Administrador();
				a.setNome(rs.getString("Nome"));
				a.setCpf(rs.getString("CPF"));
				a.setTelefone(rs.getInt("Telefone"));
				a.setLogin(rs.getString("Login"));
				a.setSenha(rs.getInt("Senha"));
				administrador.add(a);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar Administrador");
			System.out.println(e.getMessage());
		}
		return administrador;
	}

	public void alterar(Administrador a, String cpf) {
		PreparedStatement ps = null;
		String sql = "update vendedor set nome=?, cpf=?, telefone=?, login=?, senha=? where cpf=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCpf());
			ps.setInt(3, a.getTelefone());
			ps.setString(4, a.getLogin());
			ps.setInt(5, a.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela Administrador!");
			System.out.println(e.getMessage());
		}

	}
}
