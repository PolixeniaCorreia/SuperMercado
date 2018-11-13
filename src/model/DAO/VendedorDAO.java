package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mercado.conection.ConnectionFactory;
import model.Vendedor;

public class VendedorDAO {

	
	public void inserir(Vendedor v) {
		PreparedStatement ps = null;
		String sql = "insert into vendedor (login,senha) values(?,?)";
		try(Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getNome());
			ps.setString(2, v.getCpf());
			ps.setInt(3, v.getTelefone());
			ps.setString(4, v.getLogin());
			ps.setInt(5, v.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir um Vendedor no banco!");
		}
		
	}

	public void deletar(Vendedor v) {
		PreparedStatement ps = null;
		String sql = "delete from vendedor where cpf = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getCpf());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar uma Vendedor");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Vendedor> listar(){
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		String sql = "select * from vendedor";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vendedor v = new Vendedor();
				v.setNome(rs.getString("Nome"));
				v.setCpf(rs.getString("CPF"));
				v.setTelefone(rs.getInt("Telefone"));
				v.setLogin(rs.getString("Login"));
				v.setSenha(rs.getInt("Senha"));
				vendedor.add(v);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar Vendedor");
			System.out.println(e.getMessage());
		}
		return vendedor;
	}

	public void alterar(Vendedor v, String cpf) {
		PreparedStatement ps = null;
		String sql = "update vendedor set nome=?, cpf=?, telefone=?, login=?, senha=? where cpf=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, v.getNome());
			ps.setString(2, v.getCpf());
			ps.setInt(3, v.getTelefone());
			ps.setString(4, v.getLogin());
			ps.setInt(5, v.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela Vendedor!");
			System.out.println(e.getMessage());
		}
	}





}
